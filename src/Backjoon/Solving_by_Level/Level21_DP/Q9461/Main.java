package Backjoon.Solving_by_Level.Level21_DP.Q9461;

import java.io.*;
import java.util.*;

public class Main {
  public static long[] table = new long[101];

  public static void makeTable() {
    table[1] = 1L;
    table[2] = 1L;
    table[3] = 1L;
    table[4] = 2L;
    table[5] = 2L;

    for(int i = 6; i <= 100; i++) {
      table[i] = table[i - 1] + table[i - 5];
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    makeTable();

    for(int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      sb.append(table[num]).append("\n");
    }

    System.out.print(sb);

    br.close();
  }
}