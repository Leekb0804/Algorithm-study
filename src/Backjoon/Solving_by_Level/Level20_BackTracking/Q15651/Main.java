package Backjoon.Solving_by_Level.Level20_BackTracking.Q15651;

import java.io.*;
import java.util.*;

public class Main {
  public static int N;
  public static int M;

  public static int[] number;

  public static StringBuilder sb = new StringBuilder();

  public static void print(int depth) {
    if (depth >= M) {
      for(int i = 0; i < M; i++) {
        sb.append(number[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for(int i = 1; i <= N; i++) {
      number[depth] = i;
      print(depth + 1);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    number = new int[M];

    print(0);

    System.out.println(sb);

    br.close();
  }
}