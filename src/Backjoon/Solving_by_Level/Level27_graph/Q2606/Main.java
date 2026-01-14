package Backjoon.Solving_by_Level.Level27_graph.Q2606;

import java.io.*;
import java.util.*;

public class Main {
  static boolean[] visited;
  static ArrayList<Integer>[] graph;
  static int cnt = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int computerCnt = Integer.parseInt(br.readLine());
    int N = Integer.parseInt(br.readLine());

    visited = new boolean[computerCnt + 1];

    graph = new ArrayList[computerCnt + 1];
    for(int i = 0; i < computerCnt + 1; i++) {
      graph[i] = new ArrayList<>();
    }

    StringTokenizer st;
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph[u].add(v);
      graph[v].add(u);
    }

    dfs(1);

    System.out.println(cnt - 1);
    br.close();
  }

  static void dfs(int start) {
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    stack.offerFirst(start);

    while(!stack.isEmpty()) {
      int tmp = stack.pollFirst();
      if (!visited[tmp]) {
        visited[tmp] = true;
        cnt++;

        for (int num : graph[tmp]) {
          if (!visited[num]) {
            stack.offerFirst(num);
          }
        }
      }
    }
  }
}
