package Backjoon.Solving_by_Level.Level25_BinarySearch.Q1920;

import java.io.*;
import java.util.*;

// binarySearch 사용
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] A = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for(int i = 0; i < N; i++){
      A[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(A);

    int M = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());

    for(int i = 0; i < M; i++){
      int tmp = Integer.parseInt(st.nextToken());

      if (Arrays.binarySearch(A, tmp) >= 0) {
        sb.append(1);
      } else {
        sb.append(0);
      }

      sb.append("\n");
    }

    System.out.println(sb);
    br.close();
  }
/*
  public static int binarySearch(int[] A, int target) {
    int left = 0, right = A.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (A[mid] == target) {
        return 1;
      } else if (A[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return 0;
  }*/
}


// hashMap 사용
/*
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    HashSet<Integer> A = new HashSet<>();

    StringTokenizer st = new StringTokenizer(br.readLine());

    for(int i = 0; i < N; i++) {
      A.add(Integer.parseInt(st.nextToken()));
    }

    int M = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());

    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < M; i++) {
      int tmp = Integer.parseInt(st.nextToken());
      if (A.contains(tmp)) {
        sb.append(1);
      } else {
        sb.append(0);
      }
      sb.append("\n");
    }

    System.out.print(sb);
    br.close();
  }
}
*/
