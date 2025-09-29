package Backjoon.Solving_by_Level.Level9.Q2581;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int M = Integer.parseInt(br.readLine());
    int N = Integer.parseInt(br.readLine());



    br.close();

    ArrayList<Integer> arr = new ArrayList<>();
    for (int i = M; i <= N; i++) {
      if (isSosu(i)) {
        arr.add(i);
      }
    }

    if (arr.isEmpty()) {
      System.out.println("-1");
    } else {

      int sum = 0;
      for (int i = 0; i < arr.size(); i++) {
        sum += arr.get(i);
      }
      System.out.println(sum);
      System.out.println(arr.get(0));
    }
  }

  public static boolean isSosu(int k) {
    int cnt = 0;

    for(int i = 1; i <= k; i++) {
      if (k % i == 0) {
        cnt++;
      }
    }

    if (cnt== 2) {
      return true;
    } else {
      return false;
    }
  }
}
