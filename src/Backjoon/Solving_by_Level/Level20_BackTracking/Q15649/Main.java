package Backjoon.Solving_by_Level.Level20_BackTracking.Q15649;

import java.io.*;
import java.util.*;

public class Main{
  public static StringBuilder sb = new StringBuilder();
  public static int N;
  public static int M;
  public static boolean[] usedNumber;
  public static int[] number;

  public static void getNumArrays(int index) {
    if (index >= M) {
      for(int i = 0 ; i < M; i++) {
        sb.append(number[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for(int i = 1; i < N + 1; i++) {
      if (usedNumber[i] == false) {
        number[index] = i;
        usedNumber[i] = true;
        getNumArrays(index + 1);
        usedNumber[i] = false;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    usedNumber = new boolean[N + 1];
    number = new int[M];

    for(int i = 0 ; i < N + 1; i++) {
      usedNumber[i] = false;
    }

    getNumArrays(0);

    System.out.println(sb.toString());

    br.close();
  }
}