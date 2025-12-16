package Backjoon.Solving_by_Level.Level22.Q10986;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    int[] nums = new int[N];

    for(int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    int sum = 0;
    for(int i = 0; i < K; i++) {
      sum += nums[i];
    }
    int max = sum;

    for(int i = 0; i < N - K; i++) {
      max = Math.max(max, sum - nums[i] + nums[i + K]);
      sum = sum - nums[i] + nums[i + K];
      // System.out.println(i + "번째 : max : " + max);
    }

    System.out.println(max);
    br.close();
  }
}
