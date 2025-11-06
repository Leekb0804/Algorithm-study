package Backjoon.Solving_by_Level.Level14.Q7785;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st;
    HashSet<String> hashSet = new HashSet<>();
    HashMap<String, Boolean> hashMap = new HashMap<>();
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      String name = st.nextToken();
      String log = st.nextToken();

      if (log.equals("enter")) {
        hashSet.add(name);
      } else {
        hashSet.remove(name);
      }
    }


    List<String> arr = new ArrayList<>(hashSet);

    arr.sort(Comparator.reverseOrder());

    StringBuilder sb = new StringBuilder();
    for (String s : arr) {
      sb.append(s).append("\n");
    }

    BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();

  }
}