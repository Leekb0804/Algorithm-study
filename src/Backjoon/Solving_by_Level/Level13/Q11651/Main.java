package Backjoon.Solving_by_Level.Level13.Q11651;

import java.io.*;
import java.util.*;

public class Main{
  public static class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo (Point other) {
      if (this.y == other.y) {
        return Integer.compare(this.x, other.x);
      }
      return Integer.compare(this.y, other.y);
    }


  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());


    StringTokenizer st;

    ArrayList<Point> arr = new ArrayList<>();		// primitive 배열 사용 가능? Point[] 같은

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      Point p = new Point(x, y);
      arr.add(p);
    }

    Collections.sort(arr);

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < N; i++) {
      sb.append(arr.get(i).x).append(" ").append(arr.get(i).y).append("\n");
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();
  }
}