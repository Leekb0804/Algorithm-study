package Backjoon.Solving_by_Level.Level33_Tree.Q1967;

import java.io.*;
import java.util.*;

public class Main {
  static class Node {
    int v;
    int w;

    public Node (int v, int w) {
      this.v = v;
      this.w = w;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    ArrayList<Node> arr[] = new ArrayList[N + 1];
    for(int i = 0; i < N + 1; i++) {
      arr[i] = new ArrayList<>();
    }

    for(int i = 0; i < N - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int index = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      arr[index].add(new Node(v, w));
      arr[v].add(new Node(index, w));
    }

    boolean[] visited = new boolean[N + 1];
    Arrays.fill(visited, false);

    ArrayDeque<Node> queue = new ArrayDeque<>();
    queue.offerLast(new Node(1, 0));
    visited[1] = true;

    int startV = 1;
    int maxSum = 0;
    while(queue.isEmpty() == false) {
      Node cur = queue.pollFirst();

      for(Node next : arr[cur.v]) {
        if (visited[next.v] == false) {
          queue.offerLast(new Node(next.v, cur.w + next.w));
          visited[next.v] = true;

          if (maxSum < cur.w + next.w) {
            maxSum = cur.w + next.w;
            startV = next.v;
          }
        }
      }
    }

    Arrays.fill(visited, false);

    queue = new ArrayDeque<>();
    queue.offerLast(new Node(startV, 0));
    visited[startV] = true;

    maxSum = 0;
    while(queue.isEmpty() == false) {
      Node cur = queue.pollFirst();

      for(Node next : arr[cur.v]) {
        if (visited[next.v] == false) {
          queue.offerLast(new Node(next.v, cur.w + next.w));
          visited[next.v] = true;

          if (maxSum < cur.w + next.w) {
            maxSum = cur.w + next.w;
          }
        }
      }

    }

    System.out.println(maxSum);
    br.close();
  }
}