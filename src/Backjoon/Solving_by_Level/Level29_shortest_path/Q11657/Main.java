package Backjoon.Solving_by_Level.Level29_shortest_path.Q11657;

/*import java.io.*;
import java.util.*;

public class Main {
  static final long INF = Long.MAX_VALUE;

  static int N;

  static ArrayList<Node>[] list;		// 어떤 인덱스가 가지는 간선을 ArrayList 로 가짐
  static long[] dist;     // long 으로 하는 이유는 N - 1개의 정점으로 이루어진 음수 가중치의 사이클이 존재하는 경우, -10000 * 499 * 500 을 가중치로 가질 수 있기 때문, 이 값은 integer min value 보다 작음.

  static class Node {
    int d;
    int w;

    public Node (int d, int w) {
      this.d = d;
      this.w = w;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    list = new ArrayList[N + 1];
    for(int i = 0; i < N + 1; i++) {
      list[i] = new ArrayList<>();
    }

    dist = new long[N + 1];
    Arrays.fill(dist, INF);

    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());

      list[A].add(new Node(B, C));
    }

    StringBuilder sb = new StringBuilder();
    if (spfa(1)) {
      for(int i = 2; i <= N; i++) {
        if (dist[i] == INF) {
          sb.append("-1").append("\n");
        } else {
          sb.append(dist[i]).append("\n");
        }
      }
    } else {
      sb.append("-1");
    }

    System.out.println(sb);
    br.close();
  }

  // Shortest Path Faster Algorithm
  static boolean spfa(int start) {
    ArrayDeque<Integer> queue = new ArrayDeque<>();		// 도착점과 총 가중치를 저장
    boolean[] inQueue = new boolean[N + 1];
    int[] count = new int[N + 1];     //count[v]는 정점 v가 "나는 시작점에서부터 최소 k개의 간선을 거쳐온 경로의 끝점이다"라고 선언하며 주변을 훑으러 나간 횟수다.

    queue.offerLast(start);
    inQueue[start] = true;
    dist[start] = 0;

    while (queue.isEmpty() == false) {
      int current = queue.pollFirst();
      inQueue[current] = false;

      for(Node next : list[current]) {
        if (dist[next.d] > dist[current] + next.w) {
          dist[next.d] = dist[current] + next.w;


          if (inQueue[next.d] == false) {   //
            count[next.d]++;            // 해당 정점이 몇번 갱신되었는지 저장 (몇번의 bfs 페이즈가 사용되었는가)
            if (count[next.d] >= N) {   // 모든 점의 bfs를 전부 돌렸는데도 최소 경로가 발견되어 다시 또 bfs를 돌리는 겨웅
              return false;
            }

            queue.offerLast(next.d);
            inQueue[next.d] = true;
          }
        }
      }
    }

    return true;
  }
}*/

// 내가 혼자서 해본것 (2026-02-03)
import java.io.*;
import java.util.*;

public class Main {
  static final long INF = Long.MAX_VALUE;

  static int N;

  static ArrayList<Node>[] list;
  static long[] dist;

  static class Node {
    int d;
    int w;

    public Node (int d, int w) {
      this.d = d;
      this.w = w;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    list = new ArrayList[N + 1];
    for(int i = 0; i < N + 1; i++) {
      list[i] = new ArrayList<>();
    }

    dist = new long[N + 1];
    Arrays.fill(dist, INF);

    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());

      list[A].add(new Node(B, C));
    }

    StringBuilder sb = new StringBuilder();
    if (spfa(1) == true) {
      for(int i = 2; i <= N; i++) {
        if (dist[i] == INF) {
          sb.append("-1").append("\n");
        } else {
          sb.append(dist[i]).append("\n");
        }
      }
    } else {
      sb.append("-1");
    }

    System.out.print(sb);
    br.close();
  }

  static boolean spfa(int start) {

    ArrayDeque<Integer> queue = new ArrayDeque<>();
    boolean[] inQueue = new boolean[N + 1];
    int[] count = new int[N + 1];

    queue.offerLast(start);
    dist[start] = 0;

    while (queue.isEmpty() == false) {
      int current = queue.pollFirst();
      inQueue[current] = false;

      for(Node next : list[current]) {
        if (dist[next.d] > dist[current] + next.w) {
          dist[next.d] = dist[current] + next.w;

          if (inQueue[next.d] == false) {
            count[next.d]++;
            if (count[next.d] >= N) {
              return false;
            }

            queue.offerLast(next.d);
            inQueue[next.d] = true;
          }
        }
      }
    }
    return true;
  }
}

// 내가 혼자서 해본것(2026-02-02 / 틀림)
/*import java.io.*;
import java.util.*;

public class Main {
  static final int INF = Integer.MAX_VALUE;

  static int N;

  static ArrayList<Node>[] list;
  static int[] result;

  public static class Node implements Comparable<Node> {
    int d;
    int w;

    public Node (int d, int w) {
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

    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    list = new ArrayList[N + 1];
    for(int i = 0; i < N + 1; i++) {
      list[i] = new ArrayList<>();
    }

    result = new int[N + 1];
    Arrays.fill(result, INF);

    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());

      list[A].add(new Node(B, C));
    }

    boolean flag = solution();

    if (flag) {
      StringBuilder sb = new StringBuilder();
      for(int i = 2; i <= N; i++) {
        if (result[i] == INF) {
          sb.append("-1").append("\n");
        } else {
          sb.append(result[i]).append("\n");
        }
      }

      System.out.print(sb);
    } else {
      System.out.println("-1");
    }


    br.close();
  }

  static boolean solution() {
    PriorityQueue<Node> minPq = new PriorityQueue<>();
    ArrayDeque<Node> queue = new ArrayDeque<>();

    minPq.offer(new Node(1, 0));

    // i개의 간선을 사용하는 최단경로 계산
    for(int i = 1; i < N - 1; i++) {

      while(minPq.isEmpty() == false) {
        Node current = minPq.poll();

        if (current.w > result[current.d]) {
          continue;
        }

        for(Node next : list[current.d]) {
          if (result[next.d] > current.w + next.w) {
            queue.offerLast(new Node(next.d, current.w + next.w));
            result[next.d] = current.w + next.w;
          }
        }
      }

      // minPq에 넣기 (최단 경로들만)
      for(Node node : queue) {
        if (node.w > result[node.d]) {
          continue;
        }
        minPq.offer(node);
      }
      queue.clear();
    }

    while(minPq.isEmpty() == false) {
      Node current = minPq.poll();

      if (current.w > result[current.d]) {
        continue;
      }

      for(Node next : list[current.d]) {
        if (result[next.d] > current.w + next.w) {
          return false;
        }
      }
    }

    return true;
  }
}*/





// 다익스트라
/*
package Backjoon.Solving_by_Level.Level29_shortest_path.Q11657;

import java.io.*;
import java.util.*;

public class Main {
  static final int INF = Integer.MAX_VALUE;

  static ArrayList<Node>[] list;
  static int[] result;

  public static class Node implements Comparable<Node> {
    int d;
    int w;

    public Node (int d, int w) {
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
    int M = Integer.parseInt(st.nextToken());

    list = new ArrayList[N + 1];
    for(int i = 0; i < N + 1; i++) {
      list[i] = new ArrayList<>();
    }

    result = new int[N + 1];
    Arrays.fill(result, INF);

    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());

      list[A].add(new Node(B, C));
    }

    dijkstra();

    StringBuilder sb = new StringBuilder();
    for(int i = 2; i <= N; i++) {
      sb.append(result[i]).append("\n");
    }

    System.out.print(sb);
    br.close();
  }

  static void dijkstra() {
    PriorityQueue<Node> minPq = new PriorityQueue<>();
    minPq.offer(new Node(1, 0));

    result[1] = 0;

    while (minPq.isEmpty() == false) {
      Node current = minPq.poll();

      System.out.println("continue -- current.d : " + current.d + "/ current.w : " + current.w);

      if (current.w > result[current.d]) {
        continue;
      }

      for(Node next : list[current.d]) {

        System.out.println("result[next.d] : " + result[next.d] + ", current.w + next.w : " + (current.w + next.w) + ", next.d : " + next.d);

        if (result[next.d] > current.w + next.w) {
          minPq.offer(new Node(next.d, current.w + next.w));
          result[next.d] = current.w + next.w;
        }
      }
    }

  }
}*/
