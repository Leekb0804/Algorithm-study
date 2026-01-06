package Backjoon.Solving_by_Level.Level26_priority_queue.Q2696;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < T; i++) {
      int M = Integer.parseInt(br.readLine());
      sb.append((M / 2) + 1).append("\n");

      PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));		// 중간값보다 작은 수들을 담는 maxHeap
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();								// 중간값보다 큰 수들을 담는 minHeap

      //System.out.println(maxHeap.size());

      int sbCnt = 0;
      for(int repeat = 0; repeat < (M / 10) + 1; repeat++) {
        if (sbCnt >= 10) {
          sb.append("\n");
          sbCnt = 0;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 고르게(size 차이가 2 미만) 정렬 되어 있다고 가정해보자 (작은 값들의 maxHeap) / (큰 값들의 minHeap)
        // 새로운 숫자를 삽입해야 한다.
        // 새로운 숫자를 삽입하는 기준
        // 	새로운 숫자 < maxHeap
        //		maxHeap에 삽입 / 중간 값은 maxHeap의 poll
        // 	maxHeap <= 새로운 숫자 <= minHeap
        //		maxHeap에 삽입 / 중간 값은 새로운 숫자
        // 	minHeap < 새로운 숫자
        //		minHeap에 삽입 / 중간 값은 minHeap의 poll
        //

        int maxRange = 10;
        if (M - repeat * 10 < 10) {
          maxRange = M - repeat * 10;
        }

        for (int j = 1; j <= maxRange; j++) {
          int num = Integer.parseInt(st.nextToken());
          if (!(minHeap.isEmpty()) && num <= minHeap.peek()) {
            maxHeap.offer(num);
          } else {
            minHeap.offer(num);
          }
          //System.out.println("j: " + j + ", num: " + num);

          if (maxHeap.size() - minHeap.size() > 1) {
            int tmp = maxHeap.poll();
            minHeap.offer(tmp);
          }
          if (minHeap.size() - maxHeap.size() > 1) {
            int tmp = minHeap.poll();
            maxHeap.offer(tmp);
          }

          //System.out.println("rebalancing");

          if (maxHeap.size() < minHeap.size()) {
            //System.out.println("j: " + j + " minHeap Peek: " + minHeap.peek());
            sb.append(minHeap.peek()).append(" ");
            sbCnt++;
          }
          if (minHeap.size() < maxHeap.size()) {
            //System.out.println("j: " + j + " maxHeap Peek " + maxHeap.peek());
            sb.append(maxHeap.peek()).append(" ");
            sbCnt++;
          }

          //System.out.println("get Middle");
        }

        if (repeat >= 1) {

        }
      }

      sb.append("\n");

      minHeap.clear();
      maxHeap.clear();
    }

    System.out.print(sb);
    br.close();
  }
}