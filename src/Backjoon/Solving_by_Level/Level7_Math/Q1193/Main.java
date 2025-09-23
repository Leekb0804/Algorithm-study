package Backjoon.Solving_by_Level.Level7_Math.Q1193;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int X = Integer.parseInt(br.readLine());

    int N = 1;

    while (X > 0) {

      X -= N;
      N += 1;
    }

    N -= 1;
    X += N;
    N += 1;

    if (N % 2 == 0) {
      bw.write((N - X) + "/" + X);
    } else {
      bw.write(X + "/" + (N - X));
    }
    bw.flush();
  }

}
