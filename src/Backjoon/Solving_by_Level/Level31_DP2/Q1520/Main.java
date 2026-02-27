package Backjoon.Solving_by_Level.Level31_DP2.Q1520;

import java.io.*;
import java.util.*;

public class Main {
  static int M;
  static int N;
  static int[][] arr;
  static int[][] dp;

  static int[] dRow = new int[]{1, -1, 0, 0};
  static int[] dColumn = new int[]{0, 0, -1, 1};

  static int cnt = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    arr = new int[M][N];
    dp = new int[M][N];
    for(int i = 0; i < M; i++) {
      Arrays.fill(dp[i], -1);
    }

    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      for(int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // dfs
    System.out.println(dfs(0, 0));
/*
    System.out.println();
    for(int i = 0; i < M; i++) {
      for(int j = 0; j < N; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }*/

    // bfs (메모리 초과)
/*
    int[] dRow = new int[]{1, -1, 0, 0};
    int[] dColumn = new int[]{0, 0, -1, 1};

    int cnt = 0;
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    queue.offerLast(new int[]{0, 0});
    while(queue.isEmpty() == false) {
      int[] tmp = queue.pollFirst();
      int tmpRow = tmp[0];
      int tmpColumn = tmp[1];

      for(int i = 0; i < 4; i++) {
        int nextRow = tmpRow + dRow[i];
        if (nextRow < 0 || nextRow >= M) {
          continue;
        }

        int nextColumn = tmpColumn + dColumn[i];
        if (nextColumn < 0 || nextColumn>= N) {
          continue;
        }

        if (arr[nextRow][nextColumn] < arr[tmpRow][tmpColumn]) {
          if (nextRow == M - 1 && nextColumn == N - 1) {
            cnt++;
            continue;
          }
          queue.offerLast(new int[]{nextRow, nextColumn});
        }
      }
    }

    System.out.println(cnt);
*/
    br.close();
  }

  public static int dfs(int startRow, int startColumn) {

    if (startRow == M - 1 && startColumn == N - 1) {
      dp[startRow][startColumn] = 1;
      return 1;
    }

    // 중복 계산 제거(해당 위치에서 출발한 경로가 계산되어 있는 경우)
    // -1을 조건으로 둔 이유는 계산을 해서 0이 나오는 경우, 경로가 없는 경우가 있을 수도 있기 때문에
    if (dp[startRow][startColumn] != -1) {
      return dp[startRow][startColumn];
    }

    dp[startRow][startColumn] = 0;
    for(int i = 0; i < 4; i++) {
      int nextRow = startRow + dRow[i];
      int nextColumn = startColumn + dColumn[i];

      if (nextRow < 0 || nextRow >= M) {
        continue;
      }
      if (nextColumn < 0 || nextColumn >= N) {
        continue;
      }

      if (arr[nextRow][nextColumn] < arr[startRow][startColumn]) {
        dp[startRow][startColumn] += dfs(nextRow, nextColumn);
      }
    }
    return dp[startRow][startColumn];
  }
}
