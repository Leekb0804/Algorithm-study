package Backjoon.Solving_by_Level.Level15.Q17103;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    int[] arr = new int[T];
    int max = 2;
    for(int i = 0; i < T; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      max = Math.max(max, arr[i]);
    }

    boolean[] isPrimary = new boolean[max + 1];
    Arrays.fill(isPrimary, true);

    isPrimary[0] = false;
    isPrimary[1] = false;

    for(int i = 2; i <= Math.sqrt(max); i++) {
      for(int j = i * i; j <= max; j += i) {
        isPrimary[j] = false;
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int num : arr) {
      int cnt = 0;
      for(int i = 2; i <= num / 2; i++) {
        if (isPrimary[i] == true && isPrimary[num - i] == true) {
          cnt++;
        }
      }
      sb.append(cnt).append("\n");
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();
  }
}