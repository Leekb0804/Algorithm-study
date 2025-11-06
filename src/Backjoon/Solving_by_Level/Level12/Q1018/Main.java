package Backjoon.Solving_by_Level.Level12.Q1018;

import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    char[][] arr = new char[N][M];

    for(int i = 0; i < N; i++) {
      String s = br.readLine();
      for(int j = 0; j < M; j++) {
        arr[i][j] = s.charAt(j);
      }
    }

    int min = 64;
    // 좌상단이 흰색인 경우
    // 좌상단이 검은색인 경우
    // 두 경우를 합치면 반드시 64가 됨.(바꿔야 하는 타일의 개수의 합이)
    for(int i = 0; i <= N - 8; i++) {
      for(int j = 0; j <= M - 8; j++) {
        char start = arr[i][j];

        int cnt = 0;
        for(int ii = i; ii < i+8; ii++) {
          for(int jj = j; jj < j + 8; jj++) {
            if ((i + j) % 2 == (ii + jj) % 2) {
              if (arr[ii][jj] != start) {
                cnt++;
              }
            } else {
              if (arr[ii][jj] == start) {
                cnt++;
              }
            }
          }
        }
        cnt = cnt < 64 - cnt ? cnt : 64 - cnt;
        if (min > cnt) {
          min = cnt;
        }
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(min));
    bw.flush();

    br.close();
    bw.close();
  }
}