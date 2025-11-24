package Backjoon.Solving_by_Level.Level19.Q24060;

import java.io.*;
import java.util.*;

public class Main {

  public static int saveCnt = 0;
  public static int K = 0;
  public static int result = -1;
  public static int[] arr;
  public static int[] tmp;

  public static void mergeSort(int p, int r) {
    if (p < r) {
      int q = (p + r) / 2;
      mergeSort(p, q);
      mergeSort(q + 1, r);
      merge(p, q, r);
    }
  }

  public static void merge(int p, int q, int r) {
    int i = p;
    int j = q + 1;
    int t = 0;

    while (i <= q && j <= r) {
      if (arr[i] <= arr[j]) {
        tmp[t] = arr[i];
        t++;
        i++;
      } else {
        tmp[t] = arr[j];
        t++;
        j++;
      }
    }

    while (i <= q) {
      tmp[t] = arr[i];
      t++;
      i++;
    }

    while (j <= r) {
      tmp[t] = arr[j];
      t++;
      j++;
    }

    i = p;
    t = 0;

    while (i <= r) {
      saveCnt++;
      arr[i] = tmp[t];
      if (saveCnt == K) {
        result = arr[i];
      }
      i++;
      t++;
    }
  }

  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    arr = new int[N];
    tmp = new int[N];
    for(int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    mergeSort(0, N - 1);

    System.out.println(result);

    br.close();
  }
}