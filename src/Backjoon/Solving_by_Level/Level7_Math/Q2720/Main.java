package Backjoon.Solving_by_Level.Level7_Math.Q2720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str_T = br.readLine();
    int T = Integer.parseInt(str_T);
    for (int i = 0; i < T; i++) {
      String str_C = br.readLine();
      int C = Integer.parseInt(str_C);

      System.out.print(C / 25 + " ");
      C %= 25;

      System.out.print(C / 10 + " ");
      C %= 10;

      System.out.print(C / 5 + " ");
      C %= 5;

      System.out.println(C);
    }
  }

}
