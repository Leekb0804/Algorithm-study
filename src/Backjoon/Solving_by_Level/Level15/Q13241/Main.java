package Backjoon.Solving_by_Level.Level15.Q13241;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());

    long min = Math.min(A, B);
    long max = 1;
    for (long i = 1; i <= min; i++) {
      if (A % i == 0 && B % i == 0) {
        max = i;
      }
    }

    long result = A / max * B;
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(result));
    bw.flush();

    br.close();
    bw.close();
  }
}