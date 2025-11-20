package Backjoon.Solving_by_Level.Level18.Q25192;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    HashSet<String> names = new HashSet<>();
    int cnt = 0;
    
    for(int i = 0; i < N; i++) {
      String input = br.readLine();
      if (input.equals("ENTER")) {
        cnt += names.size();
        names.clear();
      } else {
        names.add(input);
      }
    }

    cnt += names.size();

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(cnt));
    bw.flush();

    br.close();
    bw.close();
  }
}