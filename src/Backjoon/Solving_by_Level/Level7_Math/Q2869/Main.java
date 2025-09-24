package Backjoon.Solving_by_Level.Level7_Math.Q2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    int n = 1;
    V -= A;
    if (V <= 0) {
      System.out.println(n);
    } else {

      int jump = A - B;
      if (V % jump == 0) {
        n = n + (V / jump);
      } else {
        n = n + (V / jump) + 1;
      }

      System.out.println(n);
    }
  }

}
