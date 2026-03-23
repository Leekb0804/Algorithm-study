package Backjoon.Solving_by_Level.Level33_Tree.Q5639;

import java.io.*;
import java.util.*;

public class Main {
  static ArrayList<Integer> list = new ArrayList<>();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    while(s != null) {
      int num = Integer.parseInt(s);

      list.add(num);

      s = br.readLine();
    }

    solution(0, list.size());

    System.out.println(sb);
    br.close();
  }

  static void solution(int start, int end) {
    if (start >= end) {
      return;
    }

    int root = list.get(start);
    int bigger = start + 1;

    for(int i = start + 1; i < end; i++) {
      if (root < list.get(i)) {
        bigger = i;
        break;
      }
    }

    solution(start + 1, bigger);
    solution(bigger, end);
    sb.append(root).append("\n");
  }
}
