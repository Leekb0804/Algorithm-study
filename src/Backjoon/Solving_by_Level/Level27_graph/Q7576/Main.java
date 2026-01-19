package Backjoon.Solving_by_Level.Level27_graph.Q7576;

import java.io.*;
import java.util.*;

public class Main {
  static int M;
  static int N;

  static int[][] board;
  static boolean[][] visited;

  static ArrayDeque<int[]> queue = new ArrayDeque<>();

  static int[] dRow = new int[] {-1, 1, 0, 0};
  static int[] dColumn = new int[] {0, 0, -1, 1};

  static int days = 0;
  static int cnt = 0;

  public static void main(String[] rags) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    board = new int[N][M];
    visited = new boolean[N][M];

    int totalFill = N * M;

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++) {
        int tmp = Integer.parseInt(st.nextToken());
        board[i][j] = tmp;
        if (tmp == 1) {
          queue.offerLast(new int[] {i, j, days});
          visited[i][j] = true;
          cnt++;
        } else if (tmp == -1) {
          totalFill -= 1;
        }
      }
    }

    bfs();
    if (cnt == totalFill) {
      System.out.println(days);
    } else {
      System.out.println("-1");
    }
    br.close();
  }

  static void bfs () {
    while (queue.isEmpty() == false) {
      int[] tmp = queue.pollFirst();

      for(int i = 0; i < 4; i++) {
        int tmpRow = tmp[0] + dRow[i];
        int tmpColumn = tmp[1] + dColumn[i];
        int tmpDays = tmp[2] + 1;

        if (tmpRow < 0 || N <= tmpRow) {
          continue;
        }
        if (tmpColumn < 0 || M <= tmpColumn) {
          continue;
        }
        if (visited[tmpRow][tmpColumn] == true) {
          continue;
        }
        if (board[tmpRow][tmpColumn] != 0) {
          continue;
        }

        queue.offerLast(new int[] {tmpRow, tmpColumn, tmpDays});
        visited[tmpRow][tmpColumn] = true;
        cnt++;
        days = Math.max(days, tmpDays);
      }
    }
  }
}
