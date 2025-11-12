package Backjoon.Solving_by_Level.Level16.Q9012;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    int sum;
    boolean isVPS;
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < T; i++) {
      sum = 0;
      isVPS = true;
      String str = br.readLine();
      for(int j = 0; j < str.length(); j++) {
        if ( str.charAt(j) == '(' ) {
          sum++;
        } else {
          sum--;
        }

        if (sum < 0) {
          isVPS = false;
          break;
        }
      }

      if (sum != 0) {
        isVPS = false;
      }

      if (isVPS) {
        sb.append("YES").append("\n");
      } else {
        sb.append("NO").append("\n");
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();
  }
}