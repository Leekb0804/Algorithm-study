package Backjoon.Solving_by_Level.Level21_DP.Q1932;

import java.io.*;
import java.util.*;

public class Main {
  public static int[][] nums;
  public static int[][] maxSums;
  public static int max;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    nums = new int[n][n];
    maxSums = new int[n][n];

    StringTokenizer st;
    for(int i = 0; i < n; i++) {
      // System.out.println("i : " + i);
      st = new StringTokenizer(br.readLine());

      for(int j = 0; j <= i; j++) {
        // System.out.println("j : " + j);
        int num = Integer.parseInt(st.nextToken());
        nums[i][j] = num;

        if (i == 0) {		// 초기값 설정
          // System.out.println("if 1");
          maxSums[i][j] = num;
          max = num;
        } else {		// max 계산
          int preMax;

          if (j == 0) {			// 층의 첫번째 값
            preMax = maxSums[i - 1][j];
          } else if (j == i) {		// 층의 마지막 값
            preMax = maxSums[i - 1][j - 1];
          } else {			// 그외 층의 중간 값들
            preMax = Math.max(maxSums[i - 1][j - 1], maxSums[i - 1][j]);
          }

          maxSums[i][j] = preMax + num;

          if (i == n - 1) {		// 마지막 층 계산할때
            if (j == 0 ) {		// 마지막 층의 첫번째 값을 max로 설정
              max = maxSums[i][j];
            } else {			// max 갱신
              max = Math.max(max, maxSums[i][j]);
            }
          }
        }
      }
    }

    System.out.println(max);
    br.close();
  }
}