package Backjoon.Solving_by_Level.Level27_graph.Q2178;

import java.io.*;
import java.util.*;

public class Main {
  static char[][] board;
  static boolean[][] visited;

  static class Point {
    int row;
    int column;
    int cost;

    public Point(int row, int column, int cost) {
      this.row = row;
      this.column = column;
      this.cost = cost;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    board = new char[N][M];
    visited = new boolean[N][M];

    // 미로 만들기
    for(int i =0 ; i < N; i++) {
      String s = br.readLine();

      for(int j = 0; j < M; j++) {
        board[i][j] = s.charAt(j);
      }
    }

    int result = bfs(N, M);

    System.out.print(result);
    br.close();
  }

  static int bfs(int N, int M) {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    int cost = 1;
    ArrayDeque<Point> queue = new ArrayDeque<>();
    queue.offerLast(new Point(0, 0, cost));
    visited[0][0] = true;

    while (queue.isEmpty() == false) {
      Point tmp = queue.pollFirst();

      for(int i = 0; i < 4; i++) {
        int tmpR = tmp.row + dr[i];
        int tmpC = tmp.column + dc[i];

        if (0 <= tmpR && tmpR < N && 0 <= tmpC && tmpC < M) {
          if (visited[tmpR][tmpC] == false && board[tmpR][tmpC] == '1') {
            if (tmpR == N - 1 && tmpC == M - 1) {
              return (tmp.cost + 1);
            }
            queue.offerLast(new Point(tmpR, tmpC, tmp.cost + 1));
            visited[tmpR][tmpC] = true;
          }
        }
      }
    }


    return 1;
  }
}





