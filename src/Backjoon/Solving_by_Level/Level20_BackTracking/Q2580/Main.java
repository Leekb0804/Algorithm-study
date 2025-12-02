package Backjoon.Solving_by_Level.Level20_BackTracking.Q2580;

import java.io.*;
import java.util.*;

public class Main{
  public static int[][] board;
  public static StringBuilder sb = new StringBuilder();
  public static ArrayList<Point> zeroList;
  public static boolean[][] rowCheck;
  public static boolean[][] columnCheck;
  public static boolean[][] squareCheck;

  public static class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void sdoqu(int index) {
    if (index == zeroList.size()) {
      for(int i = 0; i < 9; i++) {
        for(int j = 0; j < 9; j++) {
          sb.append(board[i][j]);
          if (j < 8) {
            sb.append(" ");
          }
        }
        sb.append("\n");
      }
      System.out.print(sb);
      System.exit(0);
    }

    Point newPoint = zeroList.get(index);
    for(int i = 1; i <= 9; i++) {
      if(isPossible(newPoint.x, newPoint.y, i)) {
        board[newPoint.y][newPoint.x] = i;
        rowCheck[newPoint.y][i] = true;
        columnCheck[newPoint.x][i] = true;
        squareCheck[(newPoint.y / 3) * 3 + (newPoint.x / 3)][i] = true;

        sdoqu(index + 1);

        board[newPoint.y][newPoint.x] = 0;
        rowCheck[newPoint.y][i] = false;
        columnCheck[newPoint.x][i] = false;
        squareCheck[(newPoint.y / 3) * 3 + (newPoint.x) / 3 ][i] = false;
      }
    }
  }

  public static boolean isPossible(int x, int y, int value) {

    // row check
    if (rowCheck[y][value] == true) {
      return false;
    }

    // column check
    if (columnCheck[x][value] == true) {
      return false;
    }

    // square check
    if (squareCheck[(y / 3) * 3 + (x / 3)][value] == true) {
      return false;
    }

    return true;
  }

  public static void main(String[] args) throws IOException {
    board = new int[9][9];

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    zeroList = new ArrayList<>();
    rowCheck = new boolean[9][10];
    columnCheck = new boolean[9][10];
    squareCheck = new boolean[9][10];

    for(int i = 0; i < 9; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < 9; j++) {
        int num = Integer.parseInt(st.nextToken());
        board[i][j] = num;
        rowCheck[i][num] = true;
        columnCheck[j][num] = true;
        squareCheck[(i / 3) * 3 + (j / 3)][num] = true;
        if (num == 0) {
          zeroList.add(new Point(j, i));
        }
      }
    }

    sdoqu(0);

    br.close();
  }
}

/*
    squareCheck[0][board[0][0]] = true;
    squareCheck[0][board[0][1]] = true;
    squareCheck[0][board[0][2]] = true;
    squareCheck[0][board[1][0]] = true;
    squareCheck[0][board[1][1]] = true;
    squareCheck[0][board[1][2]] = true;
    squareCheck[0][board[2][0]] = true;
    squareCheck[0][board[2][1]] = true;
    squareCheck[0][board[2][2]] = true;

    squareCheck[1][board[0][3]] = true;
    squareCheck[1][board[0][4]] = true;
    squareCheck[1][board[0][5]] = true;
    squareCheck[1][board[1][3]] = true;
    squareCheck[1][board[1][4]] = true;
    squareCheck[1][board[1][5]] = true;
    squareCheck[1][board[2][3]] = true;
    squareCheck[1][board[2][4]] = true;
    squareCheck[1][board[2][5]] = true;

    squareCheck[2][board[0][6]] = true;
    squareCheck[2][board[0][7]] = true;
    squareCheck[2][board[0][8]] = true;
    squareCheck[2][board[1][6]] = true;
    squareCheck[2][board[1][7]] = true;
    squareCheck[2][board[1][8]] = true;
    squareCheck[2][board[2][6]] = true;
    squareCheck[2][board[2][7]] = true;
    squareCheck[2][board[2][8]] = true;

    squareCheck[3][board[3][0]] = true;
    squareCheck[3][board[3][1]] = true;
    squareCheck[3][board[3][2]] = true;
    squareCheck[3][board[4][0]] = true;
    squareCheck[3][board[4][1]] = true;
    squareCheck[3][board[4][2]] = true;
    squareCheck[3][board[5][0]] = true;
    squareCheck[3][board[5][1]] = true;
    squareCheck[3][board[5][2]] = true;
 */