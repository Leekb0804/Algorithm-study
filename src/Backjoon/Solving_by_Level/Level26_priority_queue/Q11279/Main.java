package Backjoon.Solving_by_Level.Level26_priority_queue.Q11279;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(N, Collections.reverseOrder());

    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < N; i++) {
      int tmp = Integer.parseInt(br.readLine());

      if (tmp == 0) {
        if (maxHeap.isEmpty()) {
          sb.append(0).append("\n");
        } else {
          sb.append(maxHeap.poll()).append("\n");
        }
      } else {
        maxHeap.offer(tmp);
      }

    }

    System.out.println(sb);
    br.close();

  }
}