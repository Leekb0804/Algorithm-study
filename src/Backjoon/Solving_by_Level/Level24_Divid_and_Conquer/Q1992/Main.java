package Backjoon.Solving_by_Level.Level24_Divid_and_Conquer.Q1992;

import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int[][] board;
  static int[][] sum;
  static StringBuilder sb = new StringBuilder();

  public static void divid(int row, int col, int size) {
    int row2 = row + size - 1;
    int col2 = col + size - 1;

    int tmp = sum[row2][col2] - sum[row - 1][col2] - sum[row2][col - 1] + sum[row - 1][col - 1];
    // System.out.println("row: " + row + " col: " + col + " size: " + size + " tmp: " + tmp);
    if (tmp == size * size) {
      sb.append("1");
    } else if (tmp == 0) {
      sb.append("0");
    } else {
      sb.append("(");

      divid(row, col, size / 2);
      divid(row, col + size / 2, size / 2);
      divid(row + size / 2, col, size / 2);
      divid(row + size / 2, col + size / 2, size / 2);

      sb.append(")");
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    board = new int[N + 1][N + 1];
    sum = new int[N + 1][N + 1];

    // board , Sum 채우기
    for(int i = 1; i <= N; i++) {
      String s = br.readLine();
      for(int j = 1; j <= N; j++) {
        board[i][j] = s.charAt(j - 1) - '0';
        sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + board[i][j];
      }
    }

    /*System.out.println();
    for(int i = 1; i <= N; i++) {
      for(int j = 1; j <= N; j++) {
        System.out.print(sum[i][j] + " ");
      }
      System.out.println();
    }*/

    divid(1, 1, N);

    System.out.println(sb);
    br.close();
  }
}
