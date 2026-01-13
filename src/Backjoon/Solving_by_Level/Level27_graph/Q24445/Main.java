package Backjoon.Solving_by_Level.Level27_graph.Q24445;

import java.io.*;
import java.util.*;

public class Main {
  static boolean[] visited;
  static ArrayList<Integer>[] graph;
  static int[] result;
  static int cnt = 1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());

    visited = new boolean[N + 1];

    graph = new ArrayList[N + 1];
    for(int i = 0; i < N + 1; i++) {
      graph[i] = new ArrayList<>();
    }

    result = new int[N + 1];

    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph[u].add(v);
      graph[v].add(u);
    }

    for(int i = 1; i < N + 1; i++) {
      Collections.sort(graph[i], (a, b) -> (Integer.compare(b, a)));
    }

    bfs(R);

    StringBuilder sb = new StringBuilder();
    for(int i = 1; i < N + 1; i++) {
      sb.append(result[i]).append("\n");
    }

    System.out.print(sb);
    br.close();
  }

  static void bfs(int start) {
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.offerLast(start);
    visited[start] = true;
    result[start] = cnt;
    cnt++;

    while (!queue.isEmpty()) {
      int tmp = queue.pollFirst();

      for(int num : graph[tmp]) {
        if (visited[num] == false) {
          queue.offerLast(num);
          visited[num] = true;
          result[num] = cnt;
          cnt++;
        }
      }
    }

  }
}