package Backjoon.Solving_by_Level.Level31_DP2.Q11049;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());


    int[][] matrix = new int[N + 1][2];
    for(int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      matrix[i][0] = Integer.parseInt(st.nextToken());
      matrix[i][1] = Integer.parseInt(st.nextToken());
    }

    int[][] minMatrix = new int[N + 1][N + 1];		// minMatrix[1][2] 는 matrix[1] * matrix[2] 의 연산 비용 최솟값

    int[][][] multipliedMatrix = new int[N + 1][N + 1][2];    // 3차원 배열 필요없이 matrix[j][0], matrix[j + k][1], matrix[j + i][1] 로 계산가능 (왜그럴까??? 직관적으로 안와닿음)
    for(int i = 1; i <= N; i++) {
      multipliedMatrix[i][i][0] = matrix[i][0];
      multipliedMatrix[i][i][1] = matrix[i][1];
    }

    // 1번째 반복
    // minMatrix[1][1] = 0 , minMatrix[2][2] = 0
    // 2번째 반복
    // minMatrix[1][2] = ? , minMatrix[2][3] = ? , minMatrix[3][4] = ?
    // 3번째 반복
    // minMatrix[1][3] = ? , minMatrix[2][4] = ?	// 구하는법은 Math.min(minMatrix[1][1] + minMatrix[2][3]), minMatrix[1][2] + minMatrix[3][3])
    // 4번째 반복
    // // minMatrix[1][4] = ?	// 구하는법은 Math.min(minMatrix[1][1] + minMatrix[2][4]), minMatrix[1][2] + minMatrix[3][4], minMatrix[1][3] + minMatrix[4][4])

    for(int i = 1; i < N; i++) {
      for(int j = 1; j <= N - i; j++) {
        int tmp = minMatrix[j][j] + minMatrix[j + 1][j + i] + (multipliedMatrix[j][j][0] * multipliedMatrix[j][j][1] * multipliedMatrix[j + 1][j + i][1]);
        int tmpX = multipliedMatrix[j][j][0];
        int tmpY = multipliedMatrix[j + 1][j + i][1];

        for(int k = 1; k < i; k++) {
          if (tmp > minMatrix[j][j + k] + minMatrix[j + k + 1][j + i] + (multipliedMatrix[j][j + k][0] * multipliedMatrix[j][j + k][1] * multipliedMatrix[j + k + 1][j + i][1])) {
            tmp = minMatrix[j][j + k] + minMatrix[j + k + 1][j + i] + (multipliedMatrix[j][j + k][0] * multipliedMatrix[j][j + k][1] * multipliedMatrix[j + k + 1][j + i][1]);
            tmpX = multipliedMatrix[j][j + k][0];
            tmpY = multipliedMatrix[j + k + 1][j + i][1];
          }
        }

        minMatrix[j][j + i] = tmp;
        multipliedMatrix[j][j + i][0] = tmpX;
        multipliedMatrix[j][j + i][1] = tmpY;
      }
    }

    System.out.println(minMatrix[1][N]);
    br.close();
  }
}
