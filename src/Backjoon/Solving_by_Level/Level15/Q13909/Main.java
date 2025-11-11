package Backjoon.Solving_by_Level.Level15.Q13909;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long N = Long.parseLong(br.readLine());

    int cnt = 0;
    // 약수의 개수가 홀수 : 무엇인가의 제곱 수들
    for (long i = 1L; i * i <= N; i++) {
      cnt++;
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(cnt));
    bw.flush();

    br.close();
    bw.close();
  }
}
