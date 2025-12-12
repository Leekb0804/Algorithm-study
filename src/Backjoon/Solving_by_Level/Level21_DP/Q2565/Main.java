package Backjoon.Solving_by_Level.Level21_DP.Q2565;

import java.io.*;
import java.util.*;

public class Main {
  public static class Node implements Comparable<Node> {
    int a;
    int b;

    public Node(int a, int b) {
      this.a = a;
      this.b = b;
    }

    @Override
    public int compareTo(Node o) {
      return Integer.compare(this.a, o.a);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    List<Node> nodes = new ArrayList<>();

    StringTokenizer st;
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      nodes.add(new Node(a, b));
    }

    Collections.sort(nodes);



    int[] B = new int[N];

    for(int i = 0; i < N; i++) {
      B[i] = nodes.get(i).b;
    }



    int[] dp = new int[N];		// 해당 인덱스를 마지막으로 가지는 증가하는 부분수열
    int maxLines = 0;
    for(int i = 0; i < N; i++) {
      dp[i] = 1;

      for(int j = 0; j < i; j++) {
        if (B[j] < B[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }

      maxLines = Math.max(maxLines, dp[i]);
    }

    System.out.println(N - maxLines);
    br.close();
  }
}