package Backjoon.Solving_by_Level.Level10.Q3009;

import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args) throws IOException {

    try (
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    ) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());

      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());

      int x3 = Integer.parseInt(st.nextToken());
      int y3 = Integer.parseInt(st.nextToken());

      int resultx = x1 ^ x2 ^ x3;
      int resulty = y1 ^ y2 ^ y3;

      StringBuilder sb = new StringBuilder();

      sb.append(String.valueOf(resultx) + " " + String.valueOf(resulty));
      bw.write(sb.toString());
      bw.flush();
    }
  }
}


