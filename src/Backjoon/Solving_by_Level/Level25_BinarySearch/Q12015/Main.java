package Backjoon.Solving_by_Level.Level25_BinarySearch.Q12015;

import java.io.*;
import java.util.*;

public class Main {
  static int[] nums;
  static int index = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    nums = new int[N];
    for(int i = 0; i < N; i++) {
      int tmp = Integer.parseInt(st.nextToken());
      solution(tmp);
    }

    System.out.println(index);
    br.close();
  }

  public static void solution(int tmp) {
    if (index == 0) {
      nums[index] = tmp;
      index++;
    } else if(nums[index - 1] < tmp) {
      nums[index] = tmp;
      index++;
    } else{
      replace(tmp);
    }
  }

  public static void replace(int tmp) {
    int low = 0;
    int high = index - 1;
    int replaceIndex = 0;

    while (low <= high) {
      int mid = (low + high) >>> 1;

      if (nums[mid] >= tmp) {
        high = mid - 1;
        replaceIndex = mid;
      } else {
        low = mid + 1;
      }
    }

    nums[replaceIndex] = tmp;
  }
}




