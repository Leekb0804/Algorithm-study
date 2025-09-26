package Backjoon.Solving_by_Level.Level9.Q1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int sum = 0;
    for (int i = 0; i < N; i++) {
      int k = Integer.parseInt(st.nextToken());

      if (isSosu(k)) {
        sum++;
      }
    }
    br.close();
    System.out.println(sum);
  }

  public static boolean isSosu(int k) {
    int count = 0;

    for (int i = 1; i <= k; i++) {
      if (k % i == 0) {
        count++;
      }
    }

    if (count == 2) {
      return true;
    } else {
      return false;
    }
  }

}
