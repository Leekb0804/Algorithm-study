package Backjoon.Solving_by_Level.Level16.Q18258;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Deque<Integer> queue = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder();

    StringTokenizer st;
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      String cmd = st.nextToken();

      switch(cmd) {
        case "push" :
          int num = Integer.parseInt(st.nextToken());
          queue.offerLast(num);
          break;
        case "pop" :
          if (queue.peekFirst() == null) {
            sb.append("-1").append("\n");
          } else {
            int result = queue.pollFirst();
            sb.append(result).append("\n");
          }
          break;
        case "size" :
          sb.append(queue.size()).append("\n");
          break;
        case "empty" :
          if (queue.isEmpty()) {
            sb.append("1").append("\n");
          } else {
            sb.append("0").append("\n");
          }
          break;
        case "front" :
          if (queue.peekFirst() == null) {
            sb.append("-1").append("\n");
          } else {
            int result = queue.peekFirst();
            sb.append(result).append("\n");
          }
          break;
        case "back" :
          if (queue.peekFirst() == null) {
            sb.append("-1").append("\n");
          } else {
            int result = queue.peekLast();
            sb.append(result).append("\n");
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