package Backjoon.Solving_by_Level.Level27_graph.Q2206;

import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int M;

  static int[][] board;
  static boolean[][][] visited;

  static int[] dRow = new int[] {-1, 1, 0, 0};
  static int[] dColumn = new int[] {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    board = new int[N][M];
    visited = new boolean[2][N][M]; // 벽 부숨 / row / column    // 0은 벽을 안부쉈을때 방문 , 1은 벽을 부쉈을때 방문

    for(int i = 0; i < N; i++) {
      String s = br.readLine();

      for(int j = 0; j < M; j++) {
        board[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
      }
    }

    System.out.print(bfs());
    br.close();
  }

  public static int bfs() {
    // 큐에는 {row, col, distance, isBroken} 저장
    // isBroken: 0 (안부숨), 1 (부숨)
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    queue.offerLast(new int[] {0, 0, 1, 0});
    visited[0][0][0] = true;

    while (!queue.isEmpty()) {
      int[] curr = queue.pollFirst();
      int r = curr[0], c = curr[1], dist = curr[2], broken = curr[3];

      // 목적지 도달 시 즉시 반환 (시작점=끝점 케이스도 자동 처리)
      if (r == N - 1 && c == M - 1) return dist;

      for (int i = 0; i < 4; i++) {
        int nr = r + dRow[i];
        int nc = c + dColumn[i];

        if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

        // 1. 다음 칸이 빈 공간(0)인 경우
        if (board[nr][nc] == 0) {
          if (!visited[broken][nr][nc]) {
            visited[broken][nr][nc] = true;
            queue.offerLast(new int[] {nr, nc, dist + 1, broken});
          }
        }
        // 2. 다음 칸이 벽(1)인 경우
        else if (board[nr][nc] == 1 && broken == 0) { // 아직 안 부쉈을 때만 가능
          if (!visited[1][nr][nc]) {
            visited[1][nr][nc] = true;
            queue.offerLast(new int[] {nr, nc, dist + 1, 1});
          }
        }
      }
    }
    return -1;
  }
}