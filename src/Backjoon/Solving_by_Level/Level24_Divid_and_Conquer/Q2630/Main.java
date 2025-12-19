package Backjoon.Solving_by_Level.Level24_Divid_and_Conquer.Q2630;

import java.io.*;
import java.util.*;

public class Main {
  public static int N;
  public static int[][] board;

  public static int blueCnt = 0;
  public static int whiteCnt = 0;

  public static void partition (int xStart, int yStart, int size) {
    int firstNum = board[yStart][xStart];
    boolean check = true;
    for(int i = yStart; i < yStart + size; i++) {
      for(int j = xStart; j < xStart + size; j++) {
        if (board[i][j] != firstNum) {
          check = false;
          break;
        }
      }

      if (check == false) {
        break;
      }
    }

    if (check == true) {
      if (firstNum == 1) {
        blueCnt++;
      } else {
        whiteCnt++;
      }
    } else {
      partition(xStart, yStart, size / 2);	// i
      partition(xStart + (size / 2), yStart, size / 2);	// ii
      partition(xStart, yStart + (size / 2), size / 2);	// iii
      partition(xStart + (size / 2), yStart + (size / 2), size / 2);	// iV
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    board = new int[N][N];

    StringTokenizer st;
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    partition(0, 0, N);

    System.out.println(whiteCnt);
    System.out.println(blueCnt);
    br.close();
  }
}
