package Backjoon.Solving_by_Level.Level16.Q11866;

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    Deque<Integer> queue = new ArrayDeque<>();

    for(int i = 1; i <= N; i++) {
      queue.offerLast(i);
    }

    List<Integer> nums = new ArrayList<>();

    while (!queue.isEmpty()) {
      for(int i = 0; i < K - 1; i++) {
        int tmp = queue.pollFirst();
        queue.offerLast(tmp);
      }
      nums.add(queue.pollFirst());
    }

    StringBuilder sb = new StringBuilder();
    sb.append("<");
    for(int i = 0; i < nums.size(); i++) {
      sb.append(nums.get(i));
      if (i != nums.size() - 1) {
        sb.append(", ");
      }
    }
    sb.append(">");

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();
  }
}