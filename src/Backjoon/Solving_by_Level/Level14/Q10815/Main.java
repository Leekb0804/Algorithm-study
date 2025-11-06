package Backjoon.Solving_by_Level.Level14.Q10815;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    HashSet<Integer> hashSet = new HashSet<>();
    for(int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      hashSet.add(num);
    }

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < M; i++) {
      int num = Integer.parseInt(st.nextToken());
      if (hashSet.contains(num)) {
        sb.append("1 ");
      } else {
        sb.append("0 ");
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());

    br.close();
    bw.close();
  }
}