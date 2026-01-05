package Backjoon.Solving_by_Level.Level26_priority_queue.Q2075;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    // 1. 최소 힙(Min-Heap) 선언: 상위 N개만 남기기 위함
    // 기본 PriorityQueue는 최소 힙입니다.
    PriorityQueue<Integer> pq = new PriorityQueue<>(N);

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int num = Integer.parseInt(st.nextToken());

        // 2. 일단 큐에 넣고
        pq.offer(num);

        // 3. 큐의 크기가 N보다 커지면 가장 작은 놈을 제거
        if (pq.size() > N) {
          pq.poll();
        }
      }
    }

    // 4. 최종적으로 남은 N개 중 최솟값이 전체의 N번째 큰 수
    System.out.println(pq.peek());
    br.close();
  }
}