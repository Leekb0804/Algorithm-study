package Backjoon.Solving_by_Level.Level23_Greedy.Q13305;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] roads = new int[N - 1];
    for(int i = 0; i < N - 1; i++) {
      roads[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    int[] cities = new int[N];
    int min = Integer.MAX_VALUE;
    long result = 0L;
    for(int i = 0; i < N - 1; i++) {
      int tmp = Integer.parseInt(st.nextToken());
      if (i == 0) {
        min = tmp;
      } else {
        min = Math.min(min, tmp);
      }

      cities[i] = min;
      result += (long)cities[i] * roads[i];
    }

    System.out.println(result);
    br.close();
  }
}
