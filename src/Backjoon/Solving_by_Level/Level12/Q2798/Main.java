package Backjoon.Solving_by_Level.Level12.Q2798;

import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    StringTokenizer st = new StringTokenizer(s);

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    s = br.readLine();
    st = new StringTokenizer(s);

    int[] arr = new int[N];
    for(int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int max = 0;
    for(int i = 0; i < N; i++) {
      for(int j = i + 1; j < N; j++) {
        for(int k = j + 1; k < N; k++) {
          if( arr[i] + arr[j] + arr[k] <= M && max < arr[i] + arr[j] + arr[k]) {
            max = arr[i] + arr[j] + arr[k];
          }
        }
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(max));
    bw.flush();

    br.close();
    bw.close();
  }
}