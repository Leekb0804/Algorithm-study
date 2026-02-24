package Backjoon.Solving_by_Level.Level31_DP2.Q11066;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(st.nextToken());

    StringBuilder sb = new StringBuilder();

    while (T-- > 0) {
      st = new StringTokenizer(br.readLine());
      int K = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      int[] arr = new int[K];
      int[] sum = new int[K + 1];

      for(int i = 0; i < K; i++) {
        arr[i] = Integer.parseInt(st.nextToken());

        sum[i + 1] = sum[i] + arr[i];
      }

      int[][] min = new int[K][K];
      for(int i = 0; i < K; i++) {
        min[i][i] = 0;

        // System.out.println("min[" + i + "][" + i + "] = " + min[i][i] + " arr[" + i + "] = " + arr[i]);
      }

      /*//
      for(int i = 0; i < K - 1; i++) {
        min[i][i + 1] = min[i][i] + min[i + 1][i + 1];
      }

      //
      for(int i = 0; i < K - 2; i++) {
        min[i][i + 2] = Math.min(min[i][i + 1] + min[i + 2][i + 2], min[i][i] + min[i + 1][i + 2]);
      }

      //
      for(int i = 0; i < K - 3; i++) {
        min[i][i + 3] = Math.min(min[i][i] + min[i + 1][i + 3], min[i][i + 1] + min[i + 2][i + 3], min[i][i + 2] + min[i + 3][i + 3]);
      }*/


      for(int i = 1; i < K; i++) {
        for(int j = 0; j < K - i; j++) {
          int tmp = min[j][j] + min[j + 1][j + i] + sum[j + i + 1] - sum[j];
          for(int diff = 1; diff < i; diff++) {
            // System.out.println("tmp = " + tmp + " min[" + j + "][" + (j + diff) + "] = " + min[j][j + diff] + " min[" + (j + diff + 1) + "][" + (j + i) + "] = " + min[j + diff + 1][j + i]);
            tmp = Math.min(tmp, min[j][j + diff] + min[j + diff + 1][j + i] + sum[j + i + 1] - sum[j]);
          }

          min[j][j + i] = tmp;
          // System.out.println("min[" + j + "][" + (j + i) + "] = " + min[j][j + i]);
        }
      }

      sb.append(min[0][K - 1]).append("\n");
    }

    System.out.print(sb);
    br.close();
  }
}