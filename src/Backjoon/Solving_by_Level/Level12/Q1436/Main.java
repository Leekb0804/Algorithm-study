package Backjoon.Solving_by_Level.Level12.Q1436;

import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int cnt = 1;
    int num = 666;

    while (cnt != N) {
      num++;

      if (has666(num)) {
        cnt++;
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(num));
    bw.flush();

    br.close();
    bw.close();
  }

  public static boolean has666(int num) {
    String numString = String.valueOf(num);

    for(int i = 0; i < numString.length() - 2; i++) {
      if (numString.charAt(i) == '6' && numString.charAt(i + 1) == '6' && numString.charAt(i + 2) == '6' ) {
        return true;
      }
    }
    return false;
  }
}
