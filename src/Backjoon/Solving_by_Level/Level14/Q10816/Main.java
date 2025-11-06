package Backjoon.Solving_by_Level.Level14.Q10816;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for(int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());

      if (hashMap.containsKey(num)) {
        int cnt = hashMap.get(num) + 1;
        hashMap.put(num, cnt);
      } else {
        hashMap.put(num, 1);
      }

      //
      /*
      int cnt = hashMap.getOrDefault(num, 0);
      hashMap.put(num, cnt);
       */
    }

    int M = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < M; i++) {
      int num = Integer.parseInt(st.nextToken());

      if (hashMap.containsKey(num)) {
        sb.append(hashMap.get(num)).append(" ");
      } else {
        sb.append(0).append(" ");
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();
  }
}