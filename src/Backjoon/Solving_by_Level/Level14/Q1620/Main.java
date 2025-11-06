package Backjoon.Solving_by_Level.Level14.Q1620;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    String[] arr = new String[N + 1];
    HashMap<String, Integer> hashMap = new HashMap<>();
    for(int i = 1; i <= N; i++) {
      String pokemon = br.readLine();
      arr[i] = pokemon;
      hashMap.put(pokemon, i);
    }

    StringBuilder sb= new StringBuilder();
    for(int i = 0; i < M; i++) {
      String s = br.readLine();

      /*try {
        int num = Integer.parseInt(s);
        sb.append(arr[num]).append("\n");
      } catch (NumberFormatException e) {
        sb.append(hashMap.get(s)).append("\n");
      }*/

      if (Character.isDigit(s.charAt(0))) {
        sb.append(arr[Integer.parseInt(s)]).append("\n");
      } else {
        sb.append(hashMap.get(s)).append("\n");
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();
  }
}
