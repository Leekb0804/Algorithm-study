package Backjoon.Solving_by_Level.Level27_graph.Q24444;

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

    // 방문 확인용 배열 생성
    visited = new boolean[N + 1];

    // 그래프 생성
    graph = new ArrayList[N + 1];
    for(int i = 0; i < N + 1; i++) {
      graph[i] = new ArrayList<>();
    }

    // 방문 순서 저장용
    result = new int[N + 1];

    // 입력
    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph[u].add(v);
      graph[v].add(u);
    }

    // 정렬
    for(int i = 1; i < N + 1; i++) {
      Collections.sort(graph[i]);

      /*System.out.println("i = " + i);
      for(int j = 0; j < graph[i].size(); j++) {
        System.out.print(graph[i].get(j) + " ");
      }
      System.out.println();*/
    }

    // result 초기화
    result = new int[N+1];

    // bfs
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

    while (queue.isEmpty() == false) {
      int num = queue.pollFirst();

      if (visited[num]) {
        continue;
      }

      visited[num] = true;
      result[num] = cnt;
      cnt++;

      for(int i = 0; i < graph[num].size(); i++) {
        int tmp = graph[num].get(i);

        if (visited[tmp]) {
          continue;
        }

        queue.offerLast(tmp);
      }
    }
  }
}


// 4 - 3 4