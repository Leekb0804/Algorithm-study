package Backjoon.Solving_by_Level.Level21_DP.Q9184;

import java.io.*;
import java.util.*;

public class Main {
  public static int[][][] table = new int[21][21][21];

	/*
	public static int w(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		} else if ( a > 20 || b > 20 || c > 20) {
			return w(20, 20, 20);
		} else if (a < b && b < c) {
			return w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		} else {
			return w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
		}
	}
	*/

  public static void makeTable() {
    for(int i = 1; i <= 20; i++) {
      for(int j = 1; j <= 20; j++) {
        for(int k = 1; k <= 20; k++) {
          if (i < j && j < k) {
            table[i][j][k] = table[i][j][k - 1] + table[i][j - 1][k - 1] - table[i][j - 1][k];
          } else{
            table[i][j][k] = table[i - 1][j][k] + table[i - 1][j - 1][k] + table[i - 1][j][k- 1] - table[i - 1][j - 1][k - 1];
          }
        }
      }
    }
  }

  public static int w(int a, int b, int c) {
    if (a <= 0 || b <= 0 || c <= 0) {
      return 1;
    } else if (a > 20 || b > 20 || c > 20) {
      return table[20][20][20];
    } else {
      return table[a][b][c];
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    for(int i = 0; i < 21; i++) {
      for(int j = 0; j < 21; j++) {
        for(int k = 0; k < 21; k++) {
          table[i][j][k] = 1;
        }
      }
    }

    makeTable();

    StringBuilder sb = new StringBuilder();

    while (true) {
      if (a == -1 && b == -1 && c == -1) {
        break;
      }

      sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a, b, c)).append("\n");

      st = new StringTokenizer(br.readLine());

      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
    }

    System.out.println(sb);
    br.close();
  }
}