package Backjoon.Solving_by_Level.Level27_graph.Q24479;

import java.io.*;
import java.util.*;

public class Main {
  static StringBuilder sb = new StringBuilder();
  static boolean[] visited;
  static ArrayList<ArrayList<Integer>> graph;
  static int[] result;
  static int cnt = 1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());

    visited = new boolean[N + 1];

    graph = new ArrayList<>();
    for(int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    // 값 대입
    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    // 간선 내 정렬
    for(int i = 0; i <= N; i++) {
      Collections.sort(graph.get(i));
    }

    result = new int[N + 1];

    dfs(R);

    for(int i = 1; i <= N; i++) {
      sb.append(result[i]).append("\n");
    }

    System.out.println(sb);
    br.close();
  }

  static void dfs(int start) {
    visited[start] = true;
    result[start] = cnt;
    cnt++;

    ArrayList<Integer> tmp = graph.get(start);

    for(int i = 0; i < tmp.size(); i++) {
      if (visited[tmp.get(i)] == false) {
        dfs(tmp.get(i));
      }
    }

  }
}


// boolean 이차원 배열을 만들기에는 리소스가 너무 큰것 같다.