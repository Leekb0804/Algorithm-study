package Backjoon.Solving_by_Level.Level20_BackTracking.Q15650;

import java.io.*;
import java.util.*;

public class Main{
  public static int N;
  public static int M;
  public static boolean[] usedNum;
  public static int[] number;
  public static StringBuilder sb = new StringBuilder();

  public static void getNum(int min, int depth) {
    if (depth >= M) {
      for(int i = 0; i < M; i++) {
        sb.append(number[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for(int i = min + 1; i <= N; i++) {
      if (usedNum[i] == false) {
        usedNum[i] = true;
        number[depth] = i;
        getNum(i, depth + 1);
        usedNum[i] = false;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    usedNum = new boolean[N + 1];
    number = new int[M];

    getNum(0, 0);

    System.out.println(sb);

    br.close();
  }
}