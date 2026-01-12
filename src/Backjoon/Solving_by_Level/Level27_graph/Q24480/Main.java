package Backjoon.Solving_by_Level.Level27_graph.Q24480;

import java.io.*;
import java.util.*;

public class Main {
  static boolean[] visited;
  static ArrayList<Integer>[] graph;

  static int cnt = 1;
  static int[] result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());

    visited = new boolean[N + 1];
    graph = new ArrayList[N + 1];
    for(int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }


    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph[u].add(v);
      graph[v].add(u);
    }

    for(int i = 1; i <= N; i++) {
      Collections.sort(graph[i], (a, b) -> Integer.compare(b, a));

      /*System.out.println("i = " + i);
      for(int j = 0; j < graph[i].size(); j++) {
        System.out.print(graph[i].get(j) + " ");
      }
      System.out.println();*/
    }

    result = new int[N + 1];
    dfs_repeat(R);

    StringBuilder sb = new StringBuilder();
    for(int i = 1; i < N + 1; i++) {
      sb.append(result[i]).append("\n");
    }

    System.out.print(sb);
    br.close();
  }

  static void dfs_recursive(int start) {
    // ArrayDeque<Integer> stack = new ArrayDeque<>();

    visited[start] = true;
    result[start] = cnt;
    cnt++;

    for(int tmp : graph[start]) {
      if (visited[tmp] == false) {
        dfs_recursive(tmp);
      }
    }
  }

  static void dfs_repeat(int start) {
    ArrayDeque<Integer> stack = new ArrayDeque<>();

    visited[start] = true;
    result[start] = cnt;
    cnt++;

    for(int i = graph[start].size() - 1; i >= 0; i--) {
      stack.offerFirst(graph[start].get(i));
    }

    while (stack.isEmpty() == false) {
      int tmp = stack.pollFirst();
      if (visited[tmp] == false) {
        visited[tmp] = true;
        result[tmp] = cnt;
        cnt++;

        for (int i = graph[tmp].size() - 1; i >= 0; i--) {
          if (visited[graph[tmp].get(i)] == false) {
            stack.offerFirst(graph[tmp].get(i));
          }
        }
      }
    }
  }
}