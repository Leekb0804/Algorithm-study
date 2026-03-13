package Backjoon.Solving_by_Level.Level33_Tree.Q1991;

import java.io.*;
import java.util.*;

public class Main {
  static ArrayList<Character>[] list;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    list = new ArrayList[N + 1];
    for(int i = 0; i < list.length; i++) {
      list[i] = new ArrayList<>();
    }

    for(int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      char indexChar = (st.nextToken()).charAt(0);
      char leftChar = ((st.nextToken()).charAt(0));
      char rightChar = (st.nextToken()).charAt(0);

      // System.out.println("index: " + indexChar + " left: " + leftChar + " right: " + rightChar);

      int index = indexChar - 'A' + 1;

      list[index].add(leftChar);
      list[index].add(rightChar);
    }

    // pre
    pre(1);
    sb.append("\n");

    // middle
    middle(1);
    sb.append("\n");

    // post
    post(1);

    System.out.println(sb);
    br.close();
  }

  static void pre(int index) {
    sb.append((char)('A' + index - 1));

    for(char next : list[index]) {
      if (next != '.') {
        pre(next - 'A' + 1);
      }
    }
  }

  static void middle(int index) {
    char left = list[index].get(0);
    char right = list[index].get(1);

    if (left!= '.') {
      middle(left - 'A' + 1);
    }

    sb.append((char)('A' + index - 1));

    if (right != '.') {
      middle(right - 'A' + 1);
    }

  }

  static void post(int index) {

    for(char next : list[index]) {
      if (next != '.') {
        post(next - 'A' + 1);
      }
    }

    sb.append((char)('A' + index - 1));
  }
}