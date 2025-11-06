package Backjoon.Solving_by_Level.Level14.Q1269;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    HashSet<Integer> hashSet = new HashSet<>();
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < A; i++) {
      int num = Integer.parseInt(st.nextToken());
      hashSet.add(num);
    }

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < B; i++) {
      int num = Integer.parseInt(st.nextToken());

      if (hashSet.contains(num)) {
        hashSet.remove(num);
      } else {
        hashSet.add(num);
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(hashSet.size()));
    bw.flush();

    br.close();
    bw.close();
  }
}