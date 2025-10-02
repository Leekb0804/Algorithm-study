package Backjoon.Solving_by_Level.Level10.Q1085;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {

    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());

      int xx = Math.min(x, w - x);
      int yy = Math.min(y, h - y);

      System.out.println(Math.min(xx, yy));
    }

  }
}