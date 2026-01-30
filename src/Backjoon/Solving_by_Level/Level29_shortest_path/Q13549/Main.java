package Backjoon.Solving_by_Level.Level29_shortest_path.Q13549;

import java.io.*;
import java.util.*;

public class Main {
  static final int INF = Integer.MAX_VALUE;
  static final int MAX = 100000;

  static int[] dist = new int[MAX + 1];

  static class Node implements Comparable<Node> {
    int d;
    int w;

    public Node(int d, int w) {
      this.d = d;
      this.w = w;
    }

    @Override
    public int compareTo(Node o) {
      return Integer.compare(this.w, o.w);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    Arrays.fill(dist, INF);

    int result = dijkstra(N, K);

    System.out.println(result);
    br.close();
  }

  static int dijkstra(int start, int end) {
    PriorityQueue<Node> minPq = new PriorityQueue<>();
    minPq.offer(new Node(start, 0));
    dist[start] = 0;

    while (minPq.isEmpty() == false) {
      Node current = minPq.poll();

      if (dist[current.d] < current.w) {
        continue;
      }

      if (current.d * 2 <= MAX && current.d < end) {
        if (dist[current.d * 2] > current.w) {
          minPq.offer(new Node(current.d * 2, current.w));
          dist[current.d * 2] = current.w;
        }
      }

      if (current.d + 1 <= MAX) {
        if (dist[current.d + 1] > current.w + 1) {
          minPq.offer(new Node(current.d + 1, current.w + 1));
          dist[current.d + 1] = current.w + 1;
        }
      }

      if (current.d - 1 >= 0) {
        if (dist[current.d - 1] > current.w + 1) {
          minPq.offer(new Node(current.d - 1, current.w + 1));
          dist[current.d - 1] = current.w + 1;
        }
      }
    }
    return dist[end];
  }
}


