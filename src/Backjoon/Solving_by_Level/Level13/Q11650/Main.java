package Backjoon.Solving_by_Level.Level13.Q11650;

import java.io.*;
import java.util.*;

public class Main{

  static class Point implements Comparable<Point> {
    int x;
    int y;

    public Point (int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Point other) {
      if (this.x == other.x) {
        return this.y - other.y;
      }
      return this.y - other.y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());

    List<Point> points = new ArrayList<>();
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      Point point = new Point(x, y);
      points.add(point);
    }

    Collections.sort(points);

    StringBuilder sb = new StringBuilder();
    for(Point p : points) {
      sb.append(p.x).append(" ").append(p.y).append("\n");
    }
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();
  }
}



