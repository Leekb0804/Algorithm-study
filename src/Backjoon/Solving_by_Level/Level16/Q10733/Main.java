package Backjoon.Solving_by_Level.Level16.Q10733;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int K = Integer.parseInt(br.readLine());
    Deque<Integer> stack = new ArrayDeque<>();
    for(int i = 0; i < K; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num != 0) {
        stack.offerFirst(num);
      } else {
        stack.pollFirst();
      }
    }

    int sum = 0;
    while (stack.peekFirst() != null) {
      sum += stack.pollFirst();
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(sum));
    bw.flush();

    br.close();
    bw.close();
  }
}