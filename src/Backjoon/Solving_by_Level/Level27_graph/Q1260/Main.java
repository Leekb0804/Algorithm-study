package Backjoon.Solving_by_Level.Level27_graph.Q1260;

import java.io.*;
import java.util.*;

public class Main {
  static boolean[] visited;
  static ArrayList<Integer>[] graph;

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    visited = new boolean[N + 1];

    graph = new ArrayList[N + 1];
    for(int i = 0; i < N + 1; i++) {
      graph[i] = new ArrayList<>();
    }

    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph[a].add(b);
      graph[b].add(a);
    }

    for(int i = 1; i < N + 1; i++) {
      Collections.sort(graph[i]);
    }

    dfs(V);
    sb.append("\n");
    Arrays.fill(visited, false);
    bfs(V);

    System.out.print(sb);
    br.close();
  }

  static void dfs(int start) {
    visited[start] = true;
    sb.append(start).append(" ");

    for(int num : graph[start]) {
      if (visited[num] == false) {
        dfs(num);
      }
    }
  }

  static void bfs(int start) {
    ArrayDeque<Integer> queue = new ArrayDeque<>();

    queue.offerLast(start);
    visited[start] = true;
    sb.append(start).append(" ");

    while (!queue.isEmpty()) {
      int tmp = queue.pollFirst();

      for(int num : graph[tmp]) {
        if (visited[num] == false) {
          queue.offerLast(num);
          visited[num] = true;
          sb.append(num).append(" ");
        }
      }
    }
  }
}