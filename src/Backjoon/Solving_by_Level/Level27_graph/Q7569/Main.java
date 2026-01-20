package Backjoon.Solving_by_Level.Level27_graph.Q7569;

import java.io.*;
import java.util.*;

public class Main {
  static int M;
  static int N;
  static int H;

  static int[][][] board;

  static ArrayDeque<int[]> queue = new ArrayDeque<>();

  static int[] dRow = new int[] {-1, 1, 0, 0, 0, 0};
  static int[] dColumn = new int[] {0, 0, -1, 1, 0, 0};
  static int[] dHeight = new int[] {0, 0, 0, 0, -1, 1};

  static int cnt = 0;
  static int days;

  public static void main(String[] rags) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    board = new int[N][M][H];

    int totalFill = N * M * H;

    for (int h = 0; h < H; h++) {
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
          int tmp = Integer.parseInt(st.nextToken());
          board[i][j][h] = tmp;
          if (tmp == 1) {
            queue.offerLast(new int[]{i, j, h});
            cnt++;
          } else if (tmp == -1) {
            totalFill -= 1;
          }
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
    days = -1;

    while (queue.isEmpty() == false) {
      days++;
      int size = queue.size();
      for(int s = 0; s < size; s++) {
        int[] tmp = queue.pollFirst();

        for (int i = 0; i < 6; i++) {
          int tmpRow = tmp[0] + dRow[i];
          int tmpColumn = tmp[1] + dColumn[i];
          int tmpHeight = tmp[2] + dHeight[i];

          if (tmpRow < 0 || N <= tmpRow) {
            continue;
          }
          if (tmpColumn < 0 || M <= tmpColumn) {
            continue;
          }
          if (tmpHeight < 0 || H <= tmpHeight) {
            continue;
          }
          if (board[tmpRow][tmpColumn][tmpHeight] != 0) {
            continue;
          }

          queue.offerLast(new int[]{tmpRow, tmpColumn, tmpHeight});
          board[tmpRow][tmpColumn][tmpHeight] = 1;
          cnt++;
        }
      }
    }
  }
}
