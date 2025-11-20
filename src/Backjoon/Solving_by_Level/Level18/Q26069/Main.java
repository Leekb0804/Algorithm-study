package Backjoon.Solving_by_Level.Level18.Q26069;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    HashSet<String> chooms = new HashSet<>();
    chooms.add("ChongChong");

    StringTokenizer st;
    for(int i = 0; i< N; i++) {
      st = new StringTokenizer(br.readLine());

      String person1 = st.nextToken();
      String person2 = st.nextToken();

      if (chooms.contains(person1)) {
        chooms.add(person2);
      }

      if (chooms.contains(person2)) {
        chooms.add(person1);
      }
    }

    System.out.println(String.valueOf(chooms.size()));

    br.close();
  }
}