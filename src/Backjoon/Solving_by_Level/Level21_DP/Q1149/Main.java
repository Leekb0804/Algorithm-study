package Backjoon.Solving_by_Level.Level21_DP.Q1149;

import java.io.*;
import java.util.*;

public class Main {
  public static int N;

  public static int[] costs = new int[3];
  public static int R = 0;
  public static int G = 0;
  public static int B = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    StringTokenizer st;
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      for(int j = 0; j < 3; j++) {
        costs[j] = Integer.parseInt(st.nextToken());
      }

      int tmpR = Math.min(costs[0] + G, costs[0] + B);
      int tmpG = Math.min(costs[1] + R, costs[1] + B);
      int tmpB = Math.min(costs[2] + R, costs[2] + G);

      R = tmpR;
      G = tmpG;
      B = tmpB;
    }
    System.out.println(Math.min(Math.min(R,G), B));

    br.close();
  }
}