package Backjoon.Solving_by_Level.Level27_graph.Q1707;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int K = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    while (K-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int V = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());

      ArrayList<Integer>[] list = new ArrayList[V + 1];
      for(int i = 0; i <= V; i++) {
        list[i] = new ArrayList<>();
      }

      for(int i = 0; i < E; i++) {
        st = new StringTokenizer(br.readLine());

        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        list[u].add(v);
        list[v].add(u);
      }

      int[] colors = new int[V + 1];

      int flag = 0;
      // 모든 정점 순회
      for(int i = 1; i <= V; i++) {
        if (colors[i] == 0) {
          colors[i] = 1;
        }

        if (bfs(i, list, colors) == false) {
          flag = 1;
          break;
        }
      }

      if (flag == 0) {
        sb.append("YES").append("\n");
      } else {
        sb.append("NO").append("\n");
      }
    }

    System.out.print(sb);
    br.close();
  }

  public static boolean bfs(int start, ArrayList<Integer>[] list, int[] colors) {
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.offerLast(start);

    while (queue.isEmpty() == false) {
      int num = queue.pollFirst();
      for(int tmp : list[num]) {
        if (colors[tmp] == colors[num]) {	// 색깔을 넣으려고 하는데 인접한 색깔이랑 같음. (교차)
          return false;
        }

        if (colors[tmp] == (colors[num] % 2) + 1) {	// 이미 올바른 색깔을 넣은 정점 == 이미 방문한(체크한) 정점
          continue;
        }

        // 아직 색깔이 채워지지 않은 정점
        queue.offerLast(tmp);
        colors[tmp] = (colors[num] % 2) + 1;
      }
    }
    return true;
  }
}
