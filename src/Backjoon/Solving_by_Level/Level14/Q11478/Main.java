package Backjoon.Solving_by_Level.Level14.Q11478;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();

    HashSet<String> hashSet = new HashSet<>();

    int len = s.length();

    for(int i = 0; i < len; i++) {
      for(int j = i + 1; j <= len; j++) {
        hashSet.add(s.substring(i, j));
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(hashSet.size()));
    bw.flush();

    br.close();
    bw.close();
  }
}