package Backjoon.Solving_by_Level.Level15.Q1735;

import java.io.*;
import java.util.*;

public class Main {
  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int aTop = Integer.parseInt(st.nextToken());
    int aBottom = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int bTop = Integer.parseInt(st.nextToken());
    int bBottom = Integer.parseInt(st.nextToken());

    int top = aTop * bBottom + bTop * aBottom;
    int bottom = aBottom * bBottom;

    int max = getMax(top, bottom);

    StringBuilder sb = new StringBuilder();
    sb.append(String.valueOf(top / max)).append(" ").append(String.valueOf(bottom/max));

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();
  }

  public static int getMax(int a, int b) {
    int tmp;

    while (b > 0) {
      tmp = a % b;
      a = b;
      b = tmp;
    }

    return a;
  }
}