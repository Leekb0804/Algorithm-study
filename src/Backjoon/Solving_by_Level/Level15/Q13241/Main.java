package Backjoon.Solving_by_Level.Level15.Q13241;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());

    long max = getMax(Math.max(A, B), Math.min(A,B));

    long result = A / max * B;
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(result));
    bw.flush();

    br.close();
    bw.close();
  }

  public static long getMax(long a, long b) {
    long tmp;
    while (b > 0) {
      tmp = a % b;
      a = b;
      b = tmp;
    }
    return a;
  }
}