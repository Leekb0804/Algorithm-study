package Backjoon.Solving_by_Level.Level16.Q28279;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Deque<Integer> deque = new ArrayDeque<>();

    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int cmd = Integer.parseInt(st.nextToken());
      int X;
      switch (cmd) {
        case 1:
          X = Integer.parseInt(st.nextToken());
          deque.offerFirst(X);
          break;
        case 2:
          X = Integer.parseInt(st.nextToken());
          deque.offerLast(X);
          break;
        case 3:
          if (deque.isEmpty()) {
            sb.append("-1").append("\n");
          } else {
            sb.append(deque.pollFirst()).append("\n");
          }
          break;
        case 4:
          if (deque.isEmpty()) {
            sb.append("-1").append("\n");
          } else {
            sb.append(deque.pollLast()).append("\n");
          }
          break;
        case 5:
          sb.append(deque.size()).append("\n");
          break;
        case 6:
          if (deque.isEmpty()) {
            sb.append("1").append("\n");
          } else {
            sb.append("0").append("\n");
          }
          break;
        case 7:
          if (deque.isEmpty()) {
            sb.append("-1").append("\n");
          } else {
            sb.append(deque.peekFirst()).append("\n");
          }
          break;
        case 8:
          if (deque.isEmpty()) {
            sb.append("-1").append("\n");
          } else {
            sb.append(deque.peekLast()).append("\n");
          }
          break;
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();
  }
}