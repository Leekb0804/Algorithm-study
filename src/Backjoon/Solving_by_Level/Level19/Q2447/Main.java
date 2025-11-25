package Backjoon.Solving_by_Level.Level19.Q2447;

import java.io.*;
import java.util.*;

public class Main {
  public static char[][] arr;

  public static void setPoint (int x1, int y1, int size) {
    if (size == 1) {
      arr[x1][y1] = '*';
      return;
    }

    size = size / 3;
    for(int i = 0 ; i < 3; i++) {
      for(int j = 0 ; j < 3; j++) {
        if (i == 1 && j == 1) {
          continue;
        }
        setPoint(x1 + i * size, y1 + j * size, size);
      }
    }
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    arr = new char[N][N];

    setPoint(0, 0, N);

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        if (arr[i][j] == '*') {
          sb.append(arr[i][j]);
        } else {
          sb.append(' ');
        }
      }
      sb.append("\n");
    }
    System.out.println(sb);

    br.close();
  }
}