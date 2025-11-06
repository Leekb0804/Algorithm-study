package Backjoon.Solving_by_Level.Level12.Q2839;

import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());

    int y = N / 5;	// 5kg 봉지의 개수
    int x = (N - (5*y)) / 3;;		// 3kg 봉지의 개수

    while ((3 * x) + (5 * y) != N) {

      y--;

      if (y < 0) {
        break;
      }

      x = (N - (5*y)) / 3;
    }

    if (y < 0) {
      bw.write(String.valueOf(-1));
    } else {
      bw.write(String.valueOf(x + y));
    }
    bw.flush();

    br.close();
    bw.close();
  }
}