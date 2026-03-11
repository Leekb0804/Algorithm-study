package Backjoon.Solving_by_Level.Level33_Tree.Q11725;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    ArrayList<Integer>[] list =new ArrayList[N + 1];
    for(int i = 0; i <= N; i++) {
      list[i] = new ArrayList<>();
    }

    for(int i = 0; i < N - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      list[a].add(b);
      list[b].add(a);
    }

    int[] parent = new int[N + 1];
    parent[1] = -1;

    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.offerLast(1);

    while(queue.isEmpty() == false) {
      int cur = queue.pollFirst();

      for(int next : list[cur]) {
        if (parent[next] == 0) {
          parent[next] = cur;
          queue.offerLast(next);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 2; i <= N; i++) {
      sb.append(parent[i]).append("\n");
    }

    System.out.print(sb);
    br.close();
  }
}