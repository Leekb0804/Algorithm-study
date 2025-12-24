package Backjoon.Solving_by_Level.Level24_Divid_and_Conquer.Q1629;

import java.io.*;
import java.util.*;

public class Main {
  static long A;
  static long B;
  static long C;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long A = Integer.parseInt(st.nextToken());
    long B = Integer.parseInt(st.nextToken());
    long C = Integer.parseInt(st.nextToken());

    System.out.println(calculate(A % C, B, C) % C);
    br.close();
  }

  public static long calculate(long A, long B, long C) {
    if (B == 1) {
      return A;
    }
    long tmp = calculate(A, B / 2, C) % C;
    if (B % 2 == 0) {
      return tmp * tmp;
    } else {
      return ((tmp * tmp) % C) * A;
    }
  }
}