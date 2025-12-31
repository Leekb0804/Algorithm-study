package Backjoon.Solving_by_Level.Level25_BinarySearch.Q2805;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    long M = Long.parseLong(st.nextToken());

    int[] height = new int[N];
    int max = 0;

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      height[i] = Integer.parseInt(st.nextToken());
      max = Math.max(max, height[i]);
    }

    System.out.println(getMax(height, M, max));
    br.close();
  }

  public static int getMax(int[] height, long M, int max) {
    int low = 0;
    int high = max;
    int result = 0;

    while (low <= high) {
      int mid = (low + high) >>> 1;

      // System.out.println("getSum(height, mid) = " + getSum(height, mid) + ", mid = " + mid + ", low = " + low + ", high = " + high);

      if (getSum(height, mid) >= M) {      // mid 값이 큰 경우
        low = mid + 1;            // 절단기 높이 줄이기
        result = mid;
      } else {
        high = mid - 1;
      }
    }

    return result;
  }

  // 높이 len 짜리 절단기일때 획득하는 나무의 높이
  public static long getSum(int[] height, int len) {
    long sum = 0;
    for(int i = 0; i < height.length; i++) {
      int tmp = height[i] - len;
      if (tmp > 0) {
        sum += tmp;
      }
    }

    return sum;
  }
}