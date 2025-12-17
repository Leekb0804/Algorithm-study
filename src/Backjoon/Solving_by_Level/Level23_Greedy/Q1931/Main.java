package Backjoon.Solving_by_Level.Level23_Greedy.Q1931;

import java.io.*;
import java.util.*;

public class Main {
  public static class Time implements Comparable<Time> {
    int start;
    int end;

    public Time(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Time o) {
      if (this.end == o.end) {
        return this.start - o.start;
      }

      return this.end - o.end;
    }

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    List<Time> arr = new ArrayList<>();

    StringTokenizer st;

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      arr.add(new Time(start, end));
    }

    //  arr.sort();   // 이 방식으로 푸는 것도 익숙해질 것
    Collections.sort(arr);


    /*for(int i = 0; i < N; i++) {
      System.out.println("arr[" + i + "].start = " + arr.get(i).start + ", end = " + arr.get(i).end);
    }*/

    int tmpEnd = arr.get(0).end;    // getFirst() 와 get(0) 의 차이는 무엇인가?
    int cnt = 1;
    for(int i = 1; i < N; i++) {
      if (arr.get(i).start >= tmpEnd) {
        cnt++;
        tmpEnd = arr.get(i).end;
      }
    }

    System.out.println(cnt);
    br.close();
  }
}
