package Backjoon.Solving_by_Level.Level21_DP.Q11054;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] nums = new int[N];
    int[] dpUp = new int[N];	// 해당 인덱스를 마지막으로 가지는 부분수열의 길이(0번째 인덱스부터 증가하는 부분수열)
    int[] dpDown = new int[N];	// 해당 인덱스를 첫번째로 가지는 부분수열의 길이(해당 인덱스에서 마지막 인덱스까지 감소하는 부분수열)
    int maxSize = 1;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      nums[i] = num;
    }

    for(int i = 0; i < N; i++) {
      dpUp[i] = 1;

      for(int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dpUp[i] = Math.max(dpUp[i], dpUp[j] + 1);
        }
      }
      //System.out.println("dpUp[" + i + "] : " + dpUp[i]);
    }

    for(int i = N - 1; i >= 0; i--) {
      dpDown[i] = 1;

      for(int j = N - 1; j > i; j--) {
        if (nums[j] < nums[i]) {
          dpDown[i] = Math.max(dpDown[i], dpDown[j] + 1);
        }
      }

      //System.out.println("dpDown[" + i + "] : " + dpDown[i]);
      maxSize = Math.max(maxSize, dpUp[i] + dpDown[i] - 1);
    }

    System.out.println(maxSize);
    br.close();
  }
}
