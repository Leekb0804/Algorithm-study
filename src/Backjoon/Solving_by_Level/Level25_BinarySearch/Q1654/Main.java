package Backjoon.Solving_by_Level.Level25_BinarySearch.Q1654;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int K = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    int[] lansun = new int[K];
    int max = 0;

    for(int i = 0; i < K; i++) {
      lansun[i] = Integer.parseInt(br.readLine());
      max = Math.max(max, lansun[i]);
    }


    int result = getMaxLansunLength(lansun, K, N, max);

    System.out.println(result);
    br.close();
  }

  public static int getMaxLansunLength(int[] lansun, int K, int N, int max) {
    int low = 1;
    int high = max;

    int result = 0;

    while (low <= high) {
      int mid = (low + high) >>> 1;

      long cnt = getCount(lansun, mid);
      if (cnt >= N) {
        low = mid + 1;			// mid 값이 커질 수록 cnt 값은 작아진다.
        result = Math.max(result, mid);
      } else {
        high = mid - 1;
      }
    }

    return result;
  }

  public static long getCount(int[] lansun, int len) {
    long cnt = 0;
    for(int i = 0; i < lansun.length; i++) {
      cnt += lansun[i] / len;
    }

    return cnt;
  }
}