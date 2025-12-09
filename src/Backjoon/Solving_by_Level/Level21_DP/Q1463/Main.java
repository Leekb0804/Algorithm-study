package Backjoon.Solving_by_Level.Level21_DP.Q1463;

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] min = new int[N + 1];

    min[1] = 0;

    for(int i = 2; i <= N; i++) {

      int tmpMin = i; // 나름의 최댓값으로 초기화

      if (i % 3 == 0) {
        tmpMin = Math.min(tmpMin, min[i / 3] + 1);
      }

      if (i % 2 == 0) {
        tmpMin = Math.min(tmpMin, min[i / 2] + 1);
      }

      tmpMin = Math.min(tmpMin, min[i - 1] + 1);

      min[i] = tmpMin;
    }

    System.out.println(min[N]);
    br.close();
  }
}