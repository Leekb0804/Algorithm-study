package Backjoon.Solving_by_Level.Level10.Q9063;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    if (N < 2) {
      bw.write("0");
    } else {
      int max_x = 0;
      int min_x = 0;
      int max_y = 0;
      int min_y = 0;

      for(int i = 0; i < N; i++) {
        String point = br.readLine();
        StringTokenizer st = new StringTokenizer(point);

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        if (i == 0) {
          max_x = x;
          min_x = x;
          max_y = y;
          min_y = y;
        } else {
          max_x = Math.max(max_x, x);
          min_x = Math.min(min_x, x);
          max_y = Math.max(max_y, y);
          min_y = Math.min(min_y, y);
        }
      }

      int result = (max_x - min_x) * (max_y - min_y);
      bw.write(String.valueOf(result));
    }

    bw.flush();
    br.close();
    bw.close();
  }
}