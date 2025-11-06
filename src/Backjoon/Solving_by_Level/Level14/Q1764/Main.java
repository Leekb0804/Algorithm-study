package Backjoon.Solving_by_Level.Level14.Q1764;

import java.io.*;
import java.util.*;

public class Main {
  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    HashSet<String> hashSet = new HashSet<>();
    for(int i = 0; i < N; i++) {
      String name = br.readLine();

      hashSet.add(name);
    }

    ArrayList<String> list = new ArrayList<>();

    for(int i = 0; i < M; i++) {
      String name = br.readLine();

      if (hashSet.contains(name)) {
        list.add(name);
      }
    }

    list.sort(Comparator.naturalOrder());

    StringBuilder sb = new StringBuilder();
    sb.append(list.size()).append("\n");

    for(String s : list) {
      sb.append(s).append("\n");
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();
  }
}
