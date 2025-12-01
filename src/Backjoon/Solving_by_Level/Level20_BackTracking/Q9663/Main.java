package Backjoon.Solving_by_Level.Level20_BackTracking.Q9663;

/*
import java.io.*;
import java.util.*;

public class Main {
  public static int N;
  public static int cnt = 0;
  public static int[][] map;

  public static void nQueen(int queenNum) {
    if (queenNum >= N) {
      cnt++;
      return;
    }

    for(int i = 0; i < N; i++) {
      if (map[queenNum][i] == 0) {
        for(int j = 0; j < N; j++) {
          map[queenNum][j]++;    // 퀸의 세로줄
          map[j][i]++;           // 퀸의 가로줄
        }

        for(int k = -N; k <= N; k++) {
          if (0 <= queenNum + k && queenNum + k < N && 0 <= i + k && i + k < N) {
            map[queenNum + k][i + k]++;    // 퀸의 대각선 1
          }
          if (0 <= queenNum + k && queenNum + k < N && 0 <= i - k && i - k < N) {
            map[queenNum + k][i - k]++;    // 퀸의 대각선 2
          }
        }

        nQueen(queenNum + 1);

        for(int j = 0; j < N; j++) {
          map[queenNum][j]--;    // 퀸의 세로줄
          map[j][i]--;           // 퀸의 가로줄
        }

        for(int k = -N; k <= N; k++) {
          if (0 <= queenNum + k && queenNum + k < N && 0 <= i + k && i + k < N) {
            map[queenNum + k][i + k]--;    // 퀸의 대각선 1
          }
          if (0 <= queenNum + k && queenNum + k < N && 0 <= i - k && i - k < N) {
            map[queenNum + k][i - k]--;    // 퀸의 대각선 2
          }
        }

      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    map = new int[N][N];
    for(int i = N; i < N; i++) {
      for(int j = 0; j < N; j++) {
        map[i][j] = 0;
      }
    }

    nQueen(0);

    System.out.println(cnt);

    br.close();
  }
}*/

/*import java.io.*;
import java.util.*;

public class Main {
  public static int N;
  public static int cnt;
  public static int[] map;

  public static void nQueen(int index) {
    if (index >= N) {
      cnt++;
      return;
    }

    for(int i = 0; i < N; i++) {
      if (isPossible(index, i)) {
        map[index] = i;
        nQueen(index + 1);
      }
    }
  }

  public static boolean isPossible(int index, int value) {
    for(int i = 0; i < index; i++) {
      if (map[i] == value) {
        return false;
      }
      if (map[i] + (index - i) == value) {
        return false;
      }
      if (map[i] - (index - i) == value) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    map = new int[N];

    nQueen(0);

    System.out.println(cnt);

    br.close();
  }
}*/

import java.io.*;
import java.util.*;

public class Main {
  public static int N;
  public static int cnt = 0;
  public static boolean[] usedColumn;
  public static boolean[] rightRow;
  public static boolean[] leftRow;

  public static void nQueen(int row) {
    if (row >= N) {
      cnt++;
      return;
    }

    for(int i = 0; i < N; i++) {
      if (usedColumn[i] == true) {
        continue;
      }

      if (rightRow[row - i + N] == true) {
        continue;
      }

      if (leftRow[row + i] == true) {
        continue;
      }

      usedColumn[i] = true;
      rightRow[row - i + N] = true;
      leftRow[row + i] = true;

      nQueen(row + 1);

      usedColumn[i] = false;
      rightRow[row - i + N] = false;
      leftRow[row + i] = false;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    usedColumn = new boolean[N];
    Arrays.fill(usedColumn, false);
    rightRow = new boolean[N * 2];
    Arrays.fill(rightRow, false);
    leftRow = new boolean[N * 2];
    Arrays.fill(leftRow, false);

    nQueen(0);

    System.out.println(cnt);

    br.close();
  }
}











