package Backjoon.Solving_by_Level.Level27_graph.Q1697;

import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int K;

  static boolean[] visited = new boolean[100001];

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    if (N == K) {
      System.out.println(0);
    } else {
      bfs();
      System.out.print(sb);
    }

    br.close();
  }

  static void bfs() {
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    queue.offerLast(new int[]{N, 0});
    visited[N] = true;

    while (queue.isEmpty() == false) {
      int[] tmp = queue.pollFirst();

      int next = tmp[0];
      int cost = tmp[1];

      if (next - 1 == K || next + 1 == K || next * 2 == K) {
        sb.append(cost+1);
        return;
      }

      if (0 <= next - 1 && next - 1<= 100000 && visited[next - 1] == false) {
        queue.offerLast(new int[]{next - 1, cost + 1});
        visited[next - 1] = true;
      }
      if (0 <= next + 1 && next + 1<= 100000 && visited[next + 1] == false) {
        queue.offerLast(new int[]{next + 1, cost + 1});
        visited[next + 1] = true;
      }
      if (0 <= next * 2 && next * 2 <= 100000 && visited[next * 2] == false) {
        queue.offerLast(new int[]{next * 2, cost + 1});
        visited[next * 2] = true;
      }
    }

  }
}