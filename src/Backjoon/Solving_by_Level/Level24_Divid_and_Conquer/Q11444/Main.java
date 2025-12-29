package Backjoon.Solving_by_Level.Level24_Divid_and_Conquer.Q11444;

import java.io.*;
import java.util.*;

public class Main{
  static long remainder = 1000000007;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine());

    if (n == 0) {
      System.out.println(0);
    } else if (n == 1) {
      System.out.println(1);
    } else {

      long[][] matrix = new long[2][2];

      matrix[0][0] = 1;
      matrix[0][1] = 1;
      matrix[1][0] = 1;
      matrix[1][1] = 0;

      long[][] tmp = dividAndConquer(matrix, n - 1);

      System.out.println(tmp[0][0]);
    }

    br.close();
  }

  public static long[][] multipleMatrix(long[][] matrix1, long[][] matrix2) {
    long[][] result = new long[2][2];

    for(int i = 0 ; i < 2; i++) {
      for(int j = 0; j < 2; j++) {
        long tmp = 0;
        for(int k = 0; k < 2; k++) {
          tmp += (matrix1[i][k] * matrix2[k][j]) % remainder;
          tmp %= remainder;
        }
        result[i][j] = tmp;
      }
    }

    return result;
  }

  public static long[][] powerMatrix(long[][] matrix, long pow) {
    long[][] tmp = new long[2][2];

    for(int i = 0; i < 2; i++) {
      for(int j = 0; j < 2; j++) {
        tmp[i][j] = matrix[i][j];
      }
    }

    for(int i = 0; i < pow; i++) {
      tmp = multipleMatrix(tmp, matrix);
    }

    return tmp;
  }

  public static long[][] dividAndConquer(long[][] matrix, long n) {
    if (n == 1) {
      return matrix;
    }

    long[][] result = {
        {1, 0},
        {0, 1}
    };

    while(n > 0) {
      if ((n & 1) == 1) {
        result = multipleMatrix(result, matrix);
      }

      matrix = multipleMatrix(matrix, matrix);

      n = n >> 1;
    }

    return result;
  }
}


/*

K^(n + 1)

K = 	(1	1)
    (1	0)


C =	(1)
    (0)

Y(n) =(a(n+2))
    (a(n+1))

Y(n) = K^(n+1) * C

a(3) = K(2) * C

*/
