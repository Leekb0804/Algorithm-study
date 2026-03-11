package Backjoon.Solving_by_Level.Level33_Tree.Q1167;

import java.io.*;
import java.util.*;

public class Main {
  static class Node {
    int v;
    int r;

    public Node(int v, int r) {
      this.v = v;
      this.r = r;
    }

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    ArrayList<Node> arr[] = new ArrayList[N + 1];
    for(int i = 0; i < N + 1; i++) {
      arr[i] = new ArrayList<>();
    }

    int[] visited = new int[N + 1];

    int startIndex = -1;		// 루트나 리프 노드

    for(int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int index = Integer.parseInt(st.nextToken());

      int cnt = 0;
      while(true) {
        int v = Integer.parseInt(st.nextToken());

        if (v == -1) {
          break;
        }

        int r = Integer.parseInt(st.nextToken());
        arr[index].add(new Node(v, r));
        cnt++;
      }

      if (startIndex == -1 && cnt == 1) {
        startIndex = index;
      }
    }

    //System.out.println("step1 : make tree clear!");

    ArrayDeque<Node> queue = new ArrayDeque<>();
    queue.offerLast(new Node(startIndex, 0));
    visited[startIndex] = 1;

    Node maxNode = new Node(0, 0);
    while(queue.isEmpty() == false) {
      Node cur = queue.pollFirst();

      for(Node next : arr[cur.v]) {
        if (visited[next.v] == 0) {
          queue.offerLast(new Node(next.v, cur.r + next.r));
          visited[next.v] = 1;
          if (maxNode.r < cur.r + next.r) {
            maxNode.v = next.v;
            maxNode.r = cur.r + next.r;
          }
        }
      }
    }

    startIndex = maxNode.v;
    Arrays.fill(visited, 0);

    queue = new ArrayDeque<>();
    queue.offerLast(new Node(startIndex, 0));
    visited[startIndex] = 1;

    maxNode = new Node(0, 0);
    while(queue.isEmpty() == false) {
      Node cur = queue.pollFirst();

      for(Node next : arr[cur.v]) {
        if (visited[next.v] == 0) {
          queue.offerLast(new Node(next.v, cur.r + next.r));
          visited[next.v] = 1;
          if (maxNode.r < cur.r + next.r) {
            maxNode.v = next.v;
            maxNode.r = cur.r + next.r;
          }
        }
      }
    }

    System.out.println(maxNode.r);
    br.close();
  }
}