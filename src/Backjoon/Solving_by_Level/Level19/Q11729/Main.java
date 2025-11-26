package Backjoon.Solving_by_Level.Level19.Q11729;

import java.io.*;
import java.util.*;

public class Main {
  public static StringBuilder sb = new StringBuilder();
  public static int cnt  = 0;

  public static void hanoi (int p, int q, int r, int index ) {
    // 다음 인덱스 원판 시키기
    if (index > 1) {
      hanoi(p, r, q, index - 1);
    }

    // 본인 원판 옮기기
    sb.append(String.valueOf(p)).append(" ").append(String.valueOf(r)).append("\n");
    cnt++;


    // 다음 인덱스 원판 원판 시키기
    if (index > 1) {
      hanoi(q, p, r, index - 1);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    hanoi(1, 2, 3, N);

    System.out.println(cnt);
    System.out.println(sb);

    br.close();
  }
}
