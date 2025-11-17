package Backjoon.Solving_by_Level.Level16.Q2164;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Deque<Integer> queue = new ArrayDeque<>();
    for(int i = 1; i <= N; i++) {
      queue.offerLast(i);
    }

    while (queue.size() > 1) {
      queue.pollFirst();
      int num = queue.pollFirst();
      queue.offerLast(num);
    }

    System.out.println(String.valueOf(queue.pollFirst()));

    br.close();
  }
}