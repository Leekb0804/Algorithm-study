package Backjoon.Solving_by_Level.Level30_Two_Pointers.Q3273;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int x = Integer.parseInt(br.readLine());

    Arrays.sort(arr);

    int start = 0;
    int end = n - 1;

    int cnt = 0;
    while(start < end) {
      int tmp = arr[start] + arr[end];
      if (tmp == x) {
        cnt++;
        start++;		// 서로 다른 수들이 입력받으므로(중복 없음)
        end--;
      } else if (tmp < x) {
        start++;
      } else {
        end--;
      }
    }

    System.out.print(cnt);
    br.close();
  }
}
