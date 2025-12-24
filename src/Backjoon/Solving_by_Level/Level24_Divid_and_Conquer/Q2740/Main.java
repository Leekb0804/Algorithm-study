package Backjoon.Solving_by_Level.Level24_Divid_and_Conquer.Q2740;

import java.io.*;
import java.util.*;

public class Main {
  static int[][] A;
  static int[][] B;
  static int[][] C;

  static int N;
  static int M;
  static int K;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    A = new int[N][M];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // A 행렬 확인
    /*for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        System.out.print(A[i][j] + " ");
      }
      System.out.println();
    }*/

    st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    B = new int[M][K];

    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < K; j++) {
        B[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // B 행렬 확인
    /*for(int i = 0; i < M; i++) {
      for(int j = 0; j < K; j++) {
        System.out.print(B[i][j] + " ");
      }
      System.out.println();
    }
*/
    C = new int[N][K];

    multipleMatrix();

    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < K; j++) {
        sb.append(C[i][j]).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb.toString());
    br.close();
  }

  public static void multipleMatrix() {
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < K; j++) {
        int sum = 0;
        for(int k = 0; k < M; k++) {
          sum += A[i][k] * B[k][j];
        }
        C[i][j] = sum;
        //System.out.println("i = " + i + " j = " + j + " sum = " + sum);
      }
    }
  }
}






// 행렬곱

