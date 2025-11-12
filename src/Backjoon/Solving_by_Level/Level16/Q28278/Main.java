package Backjoon.Solving_by_Level.Level16.Q28278;

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st;
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int result = 0;
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int cmd = Integer.parseInt(st.nextToken());

      switch (cmd) {
        case 1:
          int num = Integer.parseInt(st.nextToken());
          stack.offerFirst(num);
          break;
        case 2:
          if (stack.isEmpty()) {
            result = -1;
          } else {
            result = stack.pollFirst();
          }
          bw.write(String.valueOf(result) + "\n");
          bw.flush();
          break;
        case 3:
          result = stack.size();
          bw.write(String.valueOf(result) + "\n");
          bw.flush();
          break;
        case 4:
          if (stack.isEmpty()) {
            result = 1;
          } else {
            result = 0;
          }
          bw.write(String.valueOf(result) + "\n");
          bw.flush();
          break;
        case 5:
          if (stack.isEmpty()) {
            result = -1;
          } else {
            result = stack.peekFirst();
          }
          bw.write(String.valueOf(result) + "\n");
          bw.flush();
          break;
      }
    }
    br.close();
    bw.close();
  }
}