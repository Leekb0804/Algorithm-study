package Backjoon.Solving_by_Level.Level11.Q24313;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    int c = Integer.parseInt(br.readLine());

    int n = Integer.parseInt(br.readLine());


    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    if (a <= c && a * n + b <= c * n) {
      bw.write("1");
    } else {
      bw.write("0");
    }

    bw.flush();
    br.close();
    bw.close();
  }
}