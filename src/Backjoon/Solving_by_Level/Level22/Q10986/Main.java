package Backjoon.Solving_by_Level.Level22.Q10986;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());		// N의 범위 : 1 ~ 1,000,000(100만)
    int M = Integer.parseInt(st.nextToken());		// M의 범위 : 2 ~ 1000

    st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    int[] sum = new int[N];

    long cnt = 0L;
    long[] counting = new long[M];
    for(int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken()) % M;		// 입력 값의 범위 : 0 ~ 1,000,000,000(10억)

      if (i == 0) {
        sum[i] = arr[i];
      } else {
        sum[i] = sum[i - 1] + arr[i];
      }
      counting[sum[i] % M]++;

      if (sum[i] % M == 0) {
        cnt++;
      }
    }

    for(int i = 0; i < M; i++) {
      //System.out.println("counting["+i+"]="+counting[i]);
      if (counting[i] > 1) {
        cnt += (counting[i] * (counting[i] - 1)) / 2;
      }
    }

    System.out.println(cnt);
    br.close();
  }
}
