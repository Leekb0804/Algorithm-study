package Backjoon.Solving_by_Level.Level21_DP.Q10844;

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[][] cnt = new int[10][N + 1];		// 0~9까지의 수로 끝나는 자릿수들 (N자리까지)
    // cnt[1][2] 는 1로 끝나는 2자릿수의 개수

    for(int i = 1; i < 10; i++) {		// 0으로 끝나는 1자릿수는 없음.
      cnt[i][1] = 1;
    }

    for(int i = 2; i <= N; i++) {
      for(int j = 0; j <= 9; j++) {
        if (j - 1 < 0) {
          cnt[j][i] = cnt[j + 1][i - 1];
        } else if (j + 1 > 9) {
          cnt[j][i] = cnt[j - 1][i - 1];
        } else {
          cnt[j][i] = (cnt[j - 1][i -1] + cnt[j + 1][i - 1]) % 1000000000;
        }
      }
    }

    int sum = 0;
    for(int i = 0; i <= 9; i++) {
      sum += cnt[i][N];
      sum %= 1000000000;
    }

    System.out.println(sum);
    br.close();
  }
}