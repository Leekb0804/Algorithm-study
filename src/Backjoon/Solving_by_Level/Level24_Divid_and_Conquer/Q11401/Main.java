package Backjoon.Solving_by_Level.Level24_Divid_and_Conquer.Q11401;

import java.io.*;
import java.util.*;

public class Main {
  static long[] fact;
  static long P = 1000000007;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    fact = new long[N + 1];

    factorial(N);

    long up = fact[N];
    long down = (fact[K] * fact[N - K]) % P;

    // 답은 up * (down^(P -2)) % P		/ P는 소수일때
    long inverse = getInverse(down, P - 2);

    long result = (up * inverse) % P;

    System.out.println(result);
    br.close();
  }

  public static void factorial(int N) {
    fact[0] = 1;
    for(int i = 1; i <= N; i++) {
      fact[i] = (fact[i - 1] * (i % P)) % P;
    }
  }

  public static long getInverse(long down, long exp) {
    return recursive(down, exp);
  }

  public static long recursive(long down, long exp) {
    if (exp == 1) {
      return down;
    } else {
      long tmp = recursive(down, exp / 2) % P;
      if (exp % 2 == 1) {
        return (((tmp * tmp) % P) * down) % P ;
      } else {
        return (tmp * tmp) % P;
      }
    }
  }
}


/*
	exp가 홀수면
	down ^(exp / 2) * down ^ (exp / 2) * down;

	exp가 짝수면
	down ^(exp / 2) * down ^ (exp / 2);
*/

// 정답 코드
/*

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // 문제에서 주어진 나누는 수 (소수)
  // 연산 과정에서 int 범위를 넘을 수 있으므로 long 사용 권장
  final static long P = 1000000007;

  public static void main(String[] args) throws IOException {
    // 입출력 속도 향상을 위해 BufferedReader 사용
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    // 1. 팩토리얼 미리 계산 (Memoization)
    // N이 최대 400만이므로 배열 크기 할당
    long[] fact = new long[N + 1];
    fact[0] = 1;

    for (int i = 1; i <= N; i++) {
      // 곱셈 과정에서 long 범위 내에서 계산되도록 함
      fact[i] = (fact[i - 1] * i) % P;
    }

    // 이항 계수 공식: N! / (K! * (N-K)!) % P

    // 2. 분자 계산: N! % P
    long numerator = fact[N];

    // 3. 분모 계산: (K! * (N-K)!) % P
    long denominator = (fact[K] * fact[N - K]) % P;

    // 4. 페르마의 소정리를 이용해 분모의 역원 구하기(분자 나누기 분모 를 P로 나눈 나머지는 분자 * 분모^(P -2) 를 P로 나눈 나머지와 같다)
    // 분모^(P-2) % P
    long inverseDenominator = power(denominator, P - 2);

    // 5. 최종 결과: 분자 * 분모의 역원 % P
    long result = (numerator * inverseDenominator) % P;

    System.out.println(result);
  }

  */
/*
   * 고속 거듭제곱 알고리즘 (분할 정복)
   * 기능: (base ^ exp) % P 를 O(log exp)에 계산
   *//*

  public static long power(long base, long exp) {
    long res = 1;
    base = base % P; // base가 P보다 클 경우를 대비

    while (exp > 0) {
      // 지수가 홀수면 현재 base를 결과에 곱함
      // (exp % 2 == 1)과 동일하지만 비트 연산이 더 빠름
      if ((exp & 1) == 1) {
        res = (res * base) % P;
      }

      // base를 제곱하고 지수를 반으로 줄임
      base = (base * base) % P;

      // 지수를 2로 나눔 (비트 시프트 연산)
      exp >>= 1;
    }

    return res;
  }
}*/
