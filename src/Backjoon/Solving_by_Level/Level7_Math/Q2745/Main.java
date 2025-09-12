package Backjoon.Solving_by_Level.Level7_Math.Q2745;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    String N = st.nextToken();
    int B = Integer.parseInt(st.nextToken());

    // 수학적인 풀이
    int len = N.length();
    int sum = 0;

    for (int i = 0; i < len; i++) {
      char c = N.charAt(i);

      int num_c = c - '0';
      if (c >= 'A') {
        num_c = 10 + c - 'A';
      }

      sum = sum * B + num_c;
    }

    System.out.println(sum);

    // java 내장 api 사용
    int result = Integer.parseInt(N, B);

    System.out.println(result);
  }

}
