package Backjoon.Solving_by_Level.Level7_Math.Q2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    // 1 , 7(+6), 19(+12), 37(+18), ...

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int tmp = 1;
    int add = 6;
    int tried = 1;

    while (N > tmp) {
      tmp += add;
      add += 6;
      tried++;
    }

    System.out.println(tried);
  }

}
