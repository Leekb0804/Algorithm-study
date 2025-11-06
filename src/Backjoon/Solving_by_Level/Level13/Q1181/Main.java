package Backjoon.Solving_by_Level.Level13.Q1181;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    HashSet<String> set = new HashSet<>();

    for(int i = 0; i < N; i++) {
      set.add(br.readLine());
    }

    ArrayList<String> arr = new ArrayList<>(set);

    arr.sort(
        Comparator.comparing(String::length)
            .thenComparing(s -> s)
    );

    StringBuilder sb = new StringBuilder();

    for(String s : arr) {
      sb.append(s).append("\n");
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();
  }
}