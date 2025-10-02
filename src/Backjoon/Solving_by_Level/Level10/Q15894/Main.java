package Backjoon.Solving_by_Level.Level10.Q15894;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {

    try (
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    ) {
      long N = Long.parseLong(br.readLine());
      N *= 4;
      bw.write(String.valueOf(N));
      bw.flush();
    }
  }
}