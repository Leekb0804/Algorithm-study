package Backjoon.Solving_by_Level.Level7_Math.Q2903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 사각형의 개수는 4배씩 증가
    // 사각형의 가로, 세로 개수는 2배씩 증가

    String str_N = br.readLine();
    int N = Integer.parseInt(str_N);
    int square_num = 1;

    for(int i = 0; i < N; i++) {
      square_num *= 2;
    }

    System.out.println((square_num + 1) * (square_num + 1));
  }

}
