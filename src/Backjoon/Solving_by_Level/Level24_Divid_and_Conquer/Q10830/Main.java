package Backjoon.Solving_by_Level.Level24_Divid_and_Conquer.Q10830;

import java.io.*;
import java.util.*;

public class Main {
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    long B = Long.parseLong(st.nextToken());

    long[][] matrix = new long[N][N];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++) {
        matrix[i][j] = Long.parseLong(st.nextToken()) % 1000;
      }
    }

    long[][] result = power(matrix, B);

    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        sb.append(result[i][j]).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
    br.close();
  }

  public static long[][] power(long[][] matrix, long B) {
    if (B == 1) {
      return matrix;
    } else {
      long[][] tmp = power(matrix, B / 2);
      if (B % 2 == 1) {
        return multiplyMatrix(multiplyMatrix(tmp, tmp), matrix);
      } else {
        return multiplyMatrix(tmp, tmp);
      }
    }
  }

  public static long[][] multiplyMatrix(long[][] matrix1, long[][] matrix2) {
    long[][] result = new long[N][N];

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        long sum = 0;
        for(int k = 0; k < N; k++) {
          sum += matrix1[i][k] * matrix2[k][j];
        }
        sum %= 1000;
        result[i][j] = sum;
      }
    }

    return result;
  }
}
