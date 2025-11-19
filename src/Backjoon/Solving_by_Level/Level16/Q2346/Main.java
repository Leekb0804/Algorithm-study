package Backjoon.Solving_by_Level.Level16.Q2346;

import java.io.*;
import java.util.*;

public class Main {

  public static class Balloon {

    int index;
    int move;

    public Balloon(int index, int move) {
      this.index = index;
      this.move = move;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    Deque<Balloon> deque = new ArrayDeque<>();

    for (int i = 1; i <= N; i++) {
      int num = Integer.parseInt(st.nextToken());
      deque.offerLast(new Balloon(i, num));
    }

    StringBuilder sb = new StringBuilder();

    while (!deque.isEmpty()) {
      Balloon b = deque.pollFirst();
      sb.append(b.index).append(" ");

      if (b.move > 0) {
        for (int i = 0; i < b.move - 1; i++) {
          Balloon tmp = deque.pollFirst();
          deque.offerLast(tmp);
        }
      } else {
        for (int i = 0; i < Math.abs(b.move); i++) {
          Balloon tmp = deque.pollLast();
          deque.offerFirst(tmp);
        }
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();
  }
}



/*
public class Main {
  public static class Balloon {
    int index;
    int move;

    public Balloon(int index, int move) {
      this.index = index;
      this.move = move;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    Deque<Integer> deque = new ArrayDeque<>();
    List<Integer> match = new ArrayList<>();
    match.add(0);   // 0번 인덱스값 설정
    for(int i = 1; i <= N; i++) {
      int num = Integer.parseInt(st.nextToken());
      deque.offerLast(i);
      match.add(num);
    }

    StringBuilder sb = new StringBuilder();

    int index = deque.pollFirst();;
    int interval = match.get(index);
    sb.append(index).append(" ");

    while (!deque.isEmpty()) {
      for(int i = 0; i < Math.abs(interval) - 1; i++) {
        if (interval > 0) {
          int tmp = deque.pollFirst();
          deque.offerLast(tmp);
        } else {
          int tmp = deque.pollLast();
          deque.offerFirst(tmp);
        }
      }

      if (interval > 0) {
        index = deque.pollFirst();
      } else {
        index = deque.pollLast();
      }
      interval = match.get(index);

      sb.append(index).append(" ");
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();
  }
}
*/
