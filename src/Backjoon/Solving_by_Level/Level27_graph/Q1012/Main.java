package Backjoon.Solving_by_Level.Level27_graph.Q1012;

import java.io.*;
import java.util.*;

public class Main {
  static int[][] graph = new int[50][50];
  static boolean[][] visited = new boolean[50][50];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    StringTokenizer st;
    for(int t = 0; t < T; t++) {
      st = new StringTokenizer(br.readLine());

      int M = Integer.parseInt(st.nextToken());
      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());

      // 지렁이 개수
      int cnt = 0;

      // graph, visited 초기화
      for(int i = 0; i < N; i++) {
        Arrays.fill(graph[i], 0);
        Arrays.fill(visited[i], false);
      }

      // 배추 넣기
      for(int k = 0; k < K; k++) {
        st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        graph[Y][X] = 1;
      }

      // 배추 밭 순회
      for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
          if (visited[i][j] == false && graph[i][j] == 1) {
            bfs(i, j, N, M);
            cnt++;
          }
        }
      }

      sb.append(cnt).append("\n");
    }

    System.out.print(sb);
    br.close();
  }

  static void bfs(int y, int x, int N, int M) {
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.offerLast(y);
    queue.offerLast(x);
    visited[y][x] = true;

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    while (queue.isEmpty() == false) {
      int r = queue.pollFirst();
      int c = queue.pollFirst();

      for(int i = 0; i < 4; i++) {
        int tmpR = r + dr[i];
        int tmpC = c + dc[i];

        if (0 <= tmpR && tmpR < N && 0 <= tmpC && tmpC < M) {
          if (visited[tmpR][tmpC] == false && graph[tmpR][tmpC] == 1) {
            queue.offerLast(tmpR);
            queue.offerLast(tmpC);

            visited[tmpR][tmpC] = true;
          }
        }
      }
    }

  }
}