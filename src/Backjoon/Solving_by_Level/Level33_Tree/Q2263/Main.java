package Backjoon.Solving_by_Level.Level33_Tree.Q2263;

import java.io.*;
import java.util.*;

public class Main {
  static int[] inOrder;
  static int[] postOrder;
  static int[] inOrderIndex;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    inOrder = new int[n];
    postOrder = new int[n];
    inOrderIndex = new int[n + 1];

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());
      inOrder[i] = num;
      inOrderIndex[num] = i;
    }

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());
      postOrder[i] = num;
    }

    solution(0, n - 1, 0, n - 1);

    System.out.println(sb);
    br.close();
  }

  static void solution(int inOrderStart, int inOrderEnd, int postOrderStart, int postOrderEnd) {
    if (inOrderStart > inOrderEnd) {
      return;
    }

    if (postOrderStart > postOrderEnd) {
      return;
    }

    int root = postOrder[postOrderEnd];
    sb.append(root).append(" ");

    int rootIndex = inOrderIndex[root];
    int leftCnt = rootIndex - inOrderStart;


    solution(inOrderStart, rootIndex - 1, postOrderStart, postOrderStart + leftCnt - 1);

    solution(rootIndex + 1, inOrderEnd, postOrderStart + leftCnt, postOrderEnd - 1);
  }

}
