package Backjoon.Solving_by_Level.Level21_DP.Q1904;

import java.io.*;
import java.util.*;

public class Main {
  public static long[] table;

  public static void makeTable(int N) {
    table[1] = 1L;
    if (N >= 2) {
      table[2] = 2L;
      for (int i = 3; i <= N; i++) {
        table[i] = (table[i - 1] + table[i - 2]) % 15746L;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    table = new long[N + 1];

    makeTable(N);

    System.out.println(table[N]);
    br.close();
  }
}