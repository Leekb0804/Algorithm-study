package Backjoon.Solving_by_Level.Level30_Two_Pointers.Q2470;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] arr = new int[N];
    for(int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    int min = Integer.MAX_VALUE;

    int start = 0;
    int end = N - 1;

    int[] result = new int[2];

    while (start < end) {
      int sum = arr[start] + arr[end];

      int tmp = sum >= 0 ? sum : -sum;

      if (tmp < min) {
        min = tmp;
        result[0] = arr[start];
        result[1] = arr[end];

        if (sum >= 0) {
          end--;
        } else {
          start++;
        }
      } else {
        if (sum >= 0) {
          end--;
        } else {
          start++;
        }
      }
    }

    System.out.println(result[0] + " " + result[1]);
    br.close();
  }
}