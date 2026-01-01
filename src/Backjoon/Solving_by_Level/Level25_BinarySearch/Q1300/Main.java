package Backjoon.Solving_by_Level.Level25_BinarySearch.Q1300;

import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int k;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    k = Integer.parseInt(br.readLine());

    System.out.println(solution());
    br.close();
  }

  public static int solution ( ) {
    int low = 1;
    int high = k;			// 왜 k로 해도 되는가? 왜 최댓값이 k인가?
    int answer = 1;

    while (low <= high) {
      int mid = (low + high) >>> 1;

      //System.out.println("mid = " + mid);

      if (getSmallerCnt(mid) >= k) {		// mid 보다 작은 숫자의 개수가 k보다 작거나 같을때
        high = mid - 1;		// mid를 키우기
        answer = mid;
      } else {					// mid 보다 작은 숫자의 개수 k 보다 클때
        low = mid + 1;		// mid 를 낮추기
      }
    }

    return answer;
  }

  public static int getSmallerCnt(int tmp) {
    int cnt = 0;
    for(int row = 1; row <= N; row++) {
      cnt += Math.min(N, tmp / row);
    }

    //System.out.println("tmp = " + tmp + ", cnt = " + cnt);

    return cnt;
  }
}