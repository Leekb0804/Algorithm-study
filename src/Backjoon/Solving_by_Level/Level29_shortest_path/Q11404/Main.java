package Backjoon.Solving_by_Level.Level29_shortest_path.Q11404;

import java.io.*;
import java.util.*;

public class Main {
  static final int INF = Integer.MAX_VALUE;
  static int[][] dist;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    dist = new int[n + 1][n + 1];
    for(int i = 0; i < n + 1; i++) {
      Arrays.fill(dist[i], INF);
    }
    for(int i = 1; i <= n; i++) {
      dist[i][i] = 0;
    }

    for(int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c= Integer.parseInt(st.nextToken());

      dist[a][b] = Math.min(dist[a][b], c);
    }


    // i -> 1 - > 3 -> 2 -> j 가 최단 경로 일 경우

    // i,j for문의 한 사이클
    // 1 -> 2 경로 초기화
    // 1 -> 3 경로 초기화
    // 1 -> j 경로 초기화

    // 2 -> j 경로 초기화

    // 3 -> 2 경로 초기화
    // 3 -> j 경로 초기화

    // i -> 1 경로 초기화
    // i -> 2 경로 초기화
    // i -> 3 경로 초기화
    // i -> j 경로 초기화

    // k == 1 이면,
    // i -> 1 -> j 를 i -> j 와 비교

    // k == 2 면,
    // 1 -> 2 -> j 를 1 -> j 와 비교		( 1 -> 2 -> j 에서 1 -> 2의 경로가 k == 3 일때 1 -> 3 -> 2의 경로와 비교됨.)
    // 3 -> 2 -> j 를 3 -> j 와 비교
    // i -> 2 -> j 를 i -> j 와 비교

    // k == 3 이면,
    // 1 -> 3 -> j 를 1 -> j 와 비교
    // i -> 3 -> j 를 i -> j 와 비교

    // k 를 증가시키며 순회하다보면 모든 경로를 비교하고 초기화됨.



    for(int k = 1; k <= n; k++) {		// 거쳐가는 정점
      for(int i = 1; i <= n; i++) {		// 시작 정점
        for(int j = 1; j <= n; j++) {		// 도착 정점
          if(dist[i][k] != INF && dist[k][j] != INF) {
            //System.out.println("i : " + i + "/ j : " + j + "/ k : " + k + "/ dist[i][k] : " + dist[i][k] + "/ dist[k][j] : " + dist[k][j] + "/ dist[i][j] : " + dist[i][j]);
            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
          }
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 1; i <= n; i++) {
      for(int j = 1; j <= n; j++) {
        if (dist[i][j] == INF) {
          sb.append("0").append(" ");
        } else {
          sb.append(dist[i][j]).append(" ");
        }
      }
      sb.append("\n");
    }


    System.out.print(sb);
    br.close();
  }
}

// 첫번째 풀이(n 번의 다익스트라)
/*import java.io.*;
import java.util.*;

public class Main {
  static final int INF = Integer.MAX_VALUE;

  static int n;

  static ArrayList<Node>[] list;
  static int[] dist;

  static class Node implements Comparable<Node> {
    int d;
    int w;

    public Node (int d, int w) {
      this.d = d;
      this.w = w;
    }

    public int compareTo(Node o) {
      return Integer.compare(this.w, o.w);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    list = new ArrayList[n + 1];
    for(int i = 0; i < n + 1; i++) {
      list[i] = new ArrayList<>();
    }

    dist = new int[n + 1];

    for(int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      list[a].add(new Node(b, c));
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 1; i <= n; i++) {
      Arrays.fill(dist, INF);

      dijkstra(i);
      for(int j = 1; j <= n; j++) {
        if (dist[j] == INF) {
          sb.append("0").append(" ");
        } else {
          sb.append(dist[j]).append(" ");
        }
      }
      sb.append("\n");
    }

    System.out.print(sb);
    br.close();
  }

  static void dijkstra(int start) {
    PriorityQueue<Node> minPq = new PriorityQueue<>();
    minPq.offer(new Node(start, 0));
    dist[start] = 0;

    while (minPq.isEmpty() == false) {
      Node current = minPq.poll();

      for(Node next : list[current.d]) {
        if (current.w > dist[current.d]) {
          continue;
        }

        if (dist[next.d] > current.w + next.w) {
          dist[next.d] = current.w + next.w;
          minPq.offer(new Node(next.d, current.w + next.w));
        }
      }
    }
  }
}*/
