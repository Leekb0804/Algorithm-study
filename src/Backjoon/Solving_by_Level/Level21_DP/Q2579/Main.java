package Backjoon.Solving_by_Level.Level21_DP.Q2579;

import java.io.*;
import java.util.*;

public class Main {
  public static int[] stairs;
  public static int[] maxSums;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    stairs = new int[n];
    maxSums = new int[n];

    for(int i = 0; i < n; i++) {
      int num = Integer.parseInt(br.readLine());

      stairs[i] = num;
      if (i == 0) {
        maxSums[i] = num;
      } else if (i == 1) {
        maxSums[i] = maxSums[i - 1] + num;
      } else if (i == 2) {
        maxSums[i] = Math.max(maxSums[i - 2] + num, stairs[i - 1] + num);
      } else {
        maxSums[i] = Math.max(maxSums[i - 2] + num, maxSums[i - 3] + stairs[i - 1] + num);
      }
    }

    System.out.println(maxSums[n - 1]);
    br.close();
  }
}