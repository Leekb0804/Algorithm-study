package Backjoon.Solving_by_Level.Level21_DP.Q1912;

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int max = -1000;
    int sum = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());

      if (sum + num < num) {
        sum = num;
      } else {
        sum += num;
      }
      max = Math.max(max, sum);
    }

    System.out.println(max);
    br.close();
  }
}