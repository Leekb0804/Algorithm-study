package Backjoon.Solving_by_Level.Level27_graph.Q2667;

import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static char[][] board;
  static boolean[][] visited;
  static int tmpCnt;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    board = new char[N][N];
    visited = new boolean[N][N];

    StringTokenizer st;
    for(int i = 0; i < N; i++) {
      String input = br.readLine();
      for(int j = 0; j < N; j++) {
        char c = input.charAt(j);
        board[i][j] = c;
      }
    }

    int totalCnt = 0;

    ArrayList<Integer> result = new ArrayList<>();

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        if (visited[i][j] == false && board[i][j] == '1') {
          tmpCnt = 0;
          dfs(i, j);
          result.add(tmpCnt);
          totalCnt++;
        }
      }
    }

    Collections.sort(result);

    StringBuilder sb = new StringBuilder();
    sb.append(totalCnt).append("\n");

    for(int tmp : result) {
      sb.append(tmp).append("\n");
    }

    System.out.print(sb);
    br.close();
  }

  static void dfs(int i, int j) {
    visited[i][j] = true;
    tmpCnt++;

    // (i + 1, j) , (i, j + 1), (i - 1, j), (i, j - 1)
    if (i + 1 < N) {
      if (visited[i + 1][j] == false && board[i + 1][j] == '1') {
        dfs(i + 1, j);
      }
    }
    if (j + 1 < N) {
      if (visited[i][j + 1] == false && board[i][j + 1] == '1') {
        dfs(i, j + 1);
      }
    }
    if (i - 1 >= 0) {
      if (visited[i - 1][j] == false && board[i - 1][j] == '1') {
        dfs(i - 1, j);
      }
    }
    if (j - 1 >= 0) {
      if (visited[i][j - 1] == false && board[i][j - 1] == '1') {
        dfs(i, j - 1);
      }
    }
  }

}