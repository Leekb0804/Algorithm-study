package Backjoon.Solving_by_Level.Level20_BackTracking.Q14889;

import java.io.*;
import java.util.*;

public class Main {
  public static int N;
  public static int[][] board;
  public static boolean[] usedNum;
  public static int[] teamA;
  public static int[] teamB;
  public static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    board = new int[N][N];
    usedNum = new boolean[N + 1];
    teamA = new int[N / 2];
    teamB = new int[N / 2];

    StringTokenizer st;
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    getMinScore(0);

    System.out.println(min);
    br.close();
  }

  public static void getMinScore (int teamIndex) {
    if (teamIndex == N / 2) {
      int teamAScore = getTeamAScore();
      int teamBScore = getTeamBScore();
      min = Math.min(Math.abs(teamAScore - teamBScore), min);
      return;
    }

    for(int i = 1; i <= N; i++) {
      if (teamIndex != 0 && teamA[teamIndex - 1] > i) {
        continue;
      }

      if (usedNum[i] == true) {
        continue;
      }
      usedNum[i] = true;
      teamA[teamIndex] = i;
      getMinScore(teamIndex + 1);
      usedNum[i] = false;
    }
  }

  public static int getTeamAScore() {
    int sum = 0;
    for(int i = 0; i < teamA.length; i++) {
      for(int j = 0; j < teamA.length; j++) {
        sum += board[teamA[i] - 1][teamA[j] - 1];
      }
    }
    return sum;
  }

  public static int getTeamBScore() {
    int sum = 0;
    int index = 0;
    for(int i = 1; i <= N; i++) {
      if (usedNum[i] == false) {
        teamB[index] = i;
        index++;
      }
    }

    for(int i = 0; i < teamB.length; i++) {
      for(int j = 0; j < teamB.length; j++) {
        sum += board[teamB[i] - 1][teamB[j] - 1];
      }
    }
    return sum;
  }
}



