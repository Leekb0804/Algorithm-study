package Backjoon.Solving_by_Level.Level29_shortest_path.Q1504;

import java.io.*;
import java.util.*;

public class Main {
  static final int INF = 1000 * 200000;

  public static ArrayList<Node>[] list;

  static int[][] dist;

  static int N;

  public static class Node implements Comparable<Node> {
    int d;
    int w;
    int mask;

    public Node (int d, int w, int mask) {
      this.d = d;
      this.w = w;
      this.mask = mask;
    }

    @Override
    public int compareTo(Node o) {
      return Integer.compare(this.w, o.w);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    list = new ArrayList[N + 1];
    for(int i = 0; i < N + 1; i++) {
      list[i] = new ArrayList<>();
    }

    for(int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      list[a].add(new Node(b, c, 0));
      list[b].add(new Node(a, c, 0));
    }

    st = new StringTokenizer(br.readLine());
    int v1 = Integer.parseInt(st.nextToken());
    int v2 = Integer.parseInt(st.nextToken());

    dist = new int[N + 1][4];
    for(int i = 0; i < N + 1; i++) {
      Arrays.fill(dist[i], INF);
    }

    int result = dijkstra(v1, v2);
    if (result < INF) {
      System.out.println(result);
    } else {
      System.out.println("-1");
    }

    br.close();
  }

  static public int dijkstra(int v1, int v2) {
    PriorityQueue<Node> minPq = new PriorityQueue<>();
    int startMask = 0;
    if (1 == v1) {
      startMask = startMask | 1;
    }
    if (1 == v2) {
      startMask = startMask | 2;
    }

    minPq.offer(new Node(1, 0, startMask));
    dist[1][startMask] = 0;

    while(minPq.isEmpty() == false) {
      Node current = minPq.poll();

      // 아래 for문에서 list를 순회할때 같은 next.d 를 가지지만 점점 작아지는 next.w를 가지는 노드들을 순회하게 될 경우, 계속 초기화됨. 그래서 이 조건문으로 가짓수 제한
      if (current.w > dist[current.d][current.mask]) {
        continue;
      }

      for(Node next : list[current.d]) {
        int nextMask = current.mask;

        if (next.d == v1) {
          nextMask = nextMask | 1;
        }
        if (next.d == v2) {
          nextMask = nextMask | 2;
        }

        if (dist[next.d][nextMask] < current.w + next.w) {
          continue;
        }

        minPq.offer(new Node(next.d, current.w + next.w, nextMask));
        dist[next.d][nextMask] = current.w + next.w;
      }
    }

    return dist[N][3];
  }
}




/*
import java.util.*;
import java.io.*;

public class Main {
  static final int INF = Integer.MAX_VALUE;

  static int N;
  static int E;

  static ArrayList<Node>[] list;

  static int[][] dist;

  public static class Node implements Comparable<Node> {
    int v;		// 도착정점
    int w;		// 가중치 합계
    int mask;	// 경유 정점 확인용

    public Node(int v, int w, int mask) {
      this.v = v;
      this.w = w;
      this.mask = mask;
    }

    @Override
    public int compareTo(Node o) {
      return Integer.compare(this.w, o.w);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    list = new ArrayList[N + 1];
    for(int i = 0; i < N + 1; i++) {
      list[i] = new ArrayList<>();
    }

    for(int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      list[a].add(new Node(b, c, 0));
      list[b].add(new Node(a, c, 0));
    }

    st = new StringTokenizer(br.readLine());

    int v1 = Integer.parseInt(st.nextToken());
    int v2 = Integer.parseInt(st.nextToken());

    dist = new int[N + 1][4];
    for(int i = 0; i < N + 1; i++) {
      Arrays.fill(dist[i], INF);
    }

    int result = dijkstra(v1, v2);
    if (result == INF) {
      System.out.println("-1");
    } else {
      System.out.println(result);
    }

    br.close();
  }

  static int dijkstra(int v1, int v2) {
    PriorityQueue<Node> minPq = new PriorityQueue<>();

    int startMask = 0;
    if (1 == v1) {
      startMask = startMask | 1;
    }
    if (1 == v2) {
      startMask = startMask | 2;
    }
    dist[1][startMask] = 0;
    minPq.offer(new Node(1, 0, startMask));

    while(minPq.isEmpty() == false) {
      Node current = minPq.poll();

      if (dist[current.v][current.mask] < current.w) {
        continue;
      }

      for(Node next : list[current.v]) {
        int nextMask = current.mask;
        if (next.v == v1) {
          nextMask = nextMask | 1;
        }
        if (next.v == v2) {
          nextMask = nextMask | 2;
        }

        if (current.w + next.w < dist[next.v][nextMask] ) {
          dist[next.v][nextMask] = current.w + next.w;
          minPq.offer(new Node(next.v, current.w + next.w, nextMask));
        }
      }
    }

    return dist[N][3];
  }
}*/
