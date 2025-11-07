package Backjoon.Solving_by_Level.Level15.Q1929;

import java.io.*;
import java.util.*;

public class Main {
  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int M = Integer.parseInt(st.nextToken());
    if (M < 2) {
      M = 2;
    }
    int N = Integer.parseInt(st.nextToken());

    boolean[] isPrime = new boolean[N + 1];
    Arrays.fill(isPrime, true);

    isPrime[0] = false;
    isPrime[1] = false;

    for(int i = 2; i <= Math.sqrt(N); i++) {
      if (isPrime[i]) {
        for(int j = i * i; j <= N; j += i) {
          isPrime[j] = false;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = M; i <= N; i++) {
      if (isPrime[i]) {
        sb.append(i).append(" ");
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();
  }
}