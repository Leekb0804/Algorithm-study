package Backjoon.Solving_by_Level.Level24_Divid_and_Conquer.Level1780;

import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int[][] board;

  static int[] cnt = new int[3];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    board = new int[N][N];

    for(int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      for(int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dividPartition(0, 0, N);

    StringBuilder sb = new StringBuilder();
    sb.append(cnt[0]).append("\n").append(cnt[1]).append("\n").append(cnt[2]);

    System.out.println(sb);
    br.close();
  }

  public static void dividPartition (int row, int column, int size) {

    int firstNum = board[row][column];

    boolean check = true;
    for(int i = row; i < row + size; i++) {
      for(int j = column; j < column + size; j++) {
        if (firstNum != board[i][j]) {
          check = false;
          break;
        }
      }
    }

    if (check) {
      cnt[firstNum + 1]++;
    } else {
      dividPartition(row, column, size / 3);
      dividPartition(row, column + size / 3, size / 3);
      dividPartition(row, column + size / 3 * 2, size / 3);

      dividPartition(row + size / 3, column, size / 3);
      dividPartition(row + size / 3, column + size / 3, size / 3);
      dividPartition(row + size / 3, column + size / 3 * 2, size / 3);

      dividPartition(row + size / 3 * 2, column, size / 3);
      dividPartition(row + size / 3 * 2, column + size / 3, size / 3);
      dividPartition(row + size / 3 * 2, column + size / 3 * 2, size / 3);
    }
  }
}