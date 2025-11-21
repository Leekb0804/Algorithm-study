package Backjoon.Solving_by_Level.Level18.Q2108;

import java.io.*;
import java.util.*;

public class Main {
  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    List<Integer> arr = new ArrayList<>();
    int sum = 0;

    HashMap<Integer, Integer> hashMap = new HashMap<>();
    int maxCnt = 0;

    for(int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      arr.add(num);
      sum += num;

      if (hashMap.containsKey(num)) {
        hashMap.put(num, hashMap.get(num) + 1);
      } else {
        hashMap.put(num, 1);
      }

      if (maxCnt < hashMap.get(num)) {
        maxCnt = hashMap.get(num);
      }
    }

    arr.sort(null);

    Set<Integer> maxCntSet = new HashSet<>();
    for(int i = 0; i < arr.size(); i++) {
      if (hashMap.get(arr.get(i)) == maxCnt) {
        maxCntSet.add(arr.get(i));
      }
    }
    List<Integer> maxCntList = new ArrayList<>(maxCntSet);
    maxCntList.sort(null);

    StringBuilder sb = new StringBuilder();

    long average = Math.round((double)sum / N);
    int mid = arr.get(N / 2);
    int mostCalled;
    if (maxCntList.size() > 1) {
      mostCalled = maxCntList.get(1);
    } else {
      mostCalled = maxCntList.get(0);
    }
    int range = arr.get(N - 1) - arr.get(0);

    sb.append(average).append("\n").append(mid).append("\n").append(mostCalled).append("\n").append(range).append("\n");

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();
  }
}