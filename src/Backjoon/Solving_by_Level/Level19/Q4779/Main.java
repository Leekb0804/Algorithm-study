package Backjoon.Solving_by_Level.Level19.Q4779;

import java.io.*;
import java.util.*;

public class Main {
  public static StringBuilder sb = new StringBuilder();

  public static void cantore(long start, long end) {
    if (start == end) {
      sb.append("-");
    } else {
      long buff = (end - start + 1) / 3 - 1;

      cantore(start, start + buff);

      for(long i = start + buff + 1L; i < end - buff; i++) {
        sb.append(" ");
      }

      cantore(end - buff, end);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    while (s != null) {
      int N = Integer.parseInt(s);
      sb.setLength(0);
      long size = 1;
      for (int i = 0 ; i < N; i++) {
        size *= 3;
      }

      cantore(1L, size);

      System.out.println(sb.toString());

      s = br.readLine();
    }


  }
}