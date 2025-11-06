package Backjoon.Solving_by_Level.Level14.Q14425;

import java.io.*;
import java.util.*;

public class Main {
  public static void main (String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    HashSet<String> hashSet = new HashSet<>();
    for(int i = 0; i < N; i++) {
      hashSet.add(br.readLine());
    }

    int cnt = 0;
    for(int i = 0; i < M; i++) {
      if (hashSet.contains(br.readLine())) {
        cnt++;
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(cnt));
    bw.flush();

    br.close();
    bw.close();
  }
}