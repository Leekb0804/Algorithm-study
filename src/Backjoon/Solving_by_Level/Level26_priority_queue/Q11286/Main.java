package Backjoon.Solving_by_Level.Level26_priority_queue.Q11286;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> minHeap = new PriorityQueue<>(N, (a, b) -> {
      long absA = Math.abs((long)a);
      long absB = Math.abs((long)b);

      if (absA == absB) {
        return Integer.compare(a, b);
      }

      return Long.compare(absA, absB);
    });

    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < N; i++) {
      int tmp = Integer.parseInt(br.readLine());

      if (tmp == 0) {
        if (minHeap.isEmpty()) {
          sb.append(0).append("\n");
        } else {
          sb.append(minHeap.poll()).append("\n");
        }
      } else {
        minHeap.offer(tmp);
      }
    }

    System.out.println(sb);
    br.close();
  }
}