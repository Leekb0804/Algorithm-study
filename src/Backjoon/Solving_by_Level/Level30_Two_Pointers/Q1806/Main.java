package Backjoon.Solving_by_Level.Level30_Two_Pointers.Q1806;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // two pointers
    int start = 0;
    int end = 0;
    int tmp = 0;
    int cnt = 0;
    int min = Integer.MAX_VALUE;

    while(true) {
      if (tmp < S) {
        if (end >= N) {
          break;
        }
        tmp += arr[end];
        cnt++;
        end++;
      } else {
        if (start >= N) {
          break;
        }
        min = Math.min(min, cnt);
        tmp -= arr[start];
        start++;
        cnt--;
      }
    }

    if (min == Integer.MAX_VALUE) {
      System.out.println(0);
    } else {
      System.out.println(min);
    }
    br.close();
  }
}


