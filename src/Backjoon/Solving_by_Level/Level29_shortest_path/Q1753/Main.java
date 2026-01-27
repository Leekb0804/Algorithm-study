package Backjoon.Solving_by_Level.Level29_shortest_path.Q1753;

import java.io.*;
import java.util.*;

public class Main {
  static final int INF = Integer.MAX_VALUE;

  static ArrayList<Node>[] list;
  static int[] result;

  static class Node implements Comparable<Node> {
    int end;
    int weight;

    public Node (int end, int weight) {
      this.end = end;
      this.weight = weight;
    }

    @Override
    public int compareTo (Node o) {
      return Integer.compare(this.weight, o.weight);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    list = new ArrayList[V + 1];
    for (int i = 0; i < V + 1; i++) {
      list[i] = new ArrayList<>();
    }

    result = new int[V + 1];
    Arrays.fill(result, INF);

    int K = Integer.parseInt(br.readLine());

    for(int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());

      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      list[u].add(new Node(v, w));
    }

    dijkstra(K);

    StringBuilder sb = new StringBuilder();
    for(int i = 1; i <= V; i++) {
      if (result[i] == INF) {
        sb.append("INF").append("\n");
      } else {
        sb.append(result[i]).append("\n");
      }
    }

    System.out.print(sb);
    br.close();
  }

  static void dijkstra(int start) {
    // pq에 들어갈 Node 는 end : 도착 정점 / weight : 해당 정점까지의 총 비용
    PriorityQueue<Node> minPq = new PriorityQueue<>();

    minPq.offer(new Node(start, 0));
    result[start] = 0;

    while (minPq.isEmpty() == false) {
      Node node = minPq.poll();

      int currentV = node.end;
      int currentW = node.weight;

      if (currentW > result[currentV]) {
        continue;
      }

      for(Node tmp : list[currentV]) {
        int nextV = tmp.end;
        int nextW = tmp.weight;

        if (currentW + nextW < result[tmp.end]) {
          minPq.offer(new Node(nextV, currentW + nextW));
          result[nextV] = currentW + nextW;
        }

      }

    }
  }
}