package Backjoon.Solving_by_Level.Level16.Q24511;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] types = new int[N];
    Deque<Integer> queue = new ArrayDeque<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      int type = Integer.parseInt(st.nextToken());
      types[i] = type;
    }

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      if (types[i] == 0) {
        queue.offerLast(num);
      }
    }

    StringBuilder sb = new StringBuilder();

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < M; i++) {
      int num = Integer.parseInt(st.nextToken());
      queue.offerFirst(num);
      sb.append(queue.pollLast()).append(" ");
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();
  }
}