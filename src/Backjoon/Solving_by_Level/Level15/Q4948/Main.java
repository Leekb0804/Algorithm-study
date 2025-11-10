package Backjoon.Solving_by_Level.Level15.Q4948;

import java.io.*;
import java.util.*;

// 매번 소수인지 판별하는 배열을 구할 필요는 없고 입력을 받은 자연수중 가장 큰 값까지만 배열을 만들어두고 나머지는 그걸 활용하면 됨.

public class Main {
  /*public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int max = N;

    List<Integer> arr = new ArrayList<>();

    StringBuilder sb = new StringBuilder();

    while (N != 0) {
      arr.add(N);

      N = Integer.parseInt(br.readLine());
      max = Math.max(max, N);
    }

    int a = max;
    int b = 2 * max;

    boolean[] isPrimaryNum = new boolean[b + 1];
    Arrays.fill(isPrimaryNum, true);

    isPrimaryNum[0] = false;
    isPrimaryNum[1] = false;

    for(int i = 2; i <= Math.sqrt(b); i++) {
      for(int j = i * i; j <= b; j+= i) {
        isPrimaryNum[j] = false;
      }
    }

    for(int num : arr) {
      int cnt = getPrimaryCount(isPrimaryNum, num);
      sb.append(cnt).append("\n");
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();
  }

  public static int getPrimaryCount(boolean[] isPrimaryNum, int N) {

    int a = N;
    int b = 2 * N;

    int cnt = 0;
    for(int i = a + 1; i <= b; i++) {
      if (isPrimaryNum[i] == true) {
        cnt++;
      }
    }

    return cnt;
  }*/

  // 문제의 최대 범위 n=123,456 이므로, 2n의 최댓값은 246,912 입니다.
  // 0-based index를 고려해 246,913 크기로 설정
  final static int MAX_LIMIT = 246912;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    // 1. 에라토스테네스의 체를 프로그램 시작 시 딱 한 번만 생성
    boolean[] isPrime = new boolean[MAX_LIMIT + 1];
    Arrays.fill(isPrime, true);
    isPrime[0] = isPrime[1] = false; // 0과 1은 소수가 아님

    // i * i <= MAX_LIMIT (Math.sqrt() 호출보다 빠름)
    for (int i = 2; i * i <= MAX_LIMIT; i++) {
      if (isPrime[i]) {
        // j = i * i 부터 시작 (i * 2, i * 3 ... 등은 이미 지워졌음)
        for (int j = i * i; j <= MAX_LIMIT; j += i) {
          isPrime[j] = false;
        }
      }
    }

    // 2. 소수 개수 '누적 합' 배열 생성 (Prefix Sum)
    int[] primeCount = new int[MAX_LIMIT + 1];
    for (int i = 1; i <= MAX_LIMIT; i++) {
      // 이전 값 + (현재 값이 소수이면 1, 아니면 0)
      primeCount[i] = primeCount[i - 1] + (isPrime[i] ? 1 : 0);
    }

    // 3. 입력을 받으면서 O(1) 연산으로 즉시 처리
    while (true) {
      int n = Integer.parseInt(br.readLine());
      if (n == 0) {
        break; // 입력 종료
      }

      // O(1) 쿼리: (n+1 ~ 2n) = (1 ~ 2n) - (1 ~ n)
      int count = primeCount[2 * n] - primeCount[n];
      sb.append(count).append("\n");
    }

    // 4. 전체 결과 한 번에 출력
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();
  }

}