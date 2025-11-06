package Backjoon.Solving_by_Level.Level13.Q1427;

// 시도 1

import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    int len = s.length();

    ArrayList<Integer> arr = new ArrayList<>();

    for(int i = 0; i < len; i++) {
      arr.add(s.charAt(i) - '0');
    }

    arr.sort(Comparator.reverseOrder());
    //arr.sort(Comparator.naturalOrder());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; i++) {
      sb.append(String.valueOf(arr.get(i)));
    }
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();

  }
}



// 시도 2
/*
import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();

    char[] arr = s.toCharArray();

    Arrays.sort(arr);

    StringBuilder sb = new StringBuilder();
    int len = arr.length;
    for(int i = 0; i < len; i++) {
      sb.append(arr[len - 1 - i]);
    }


    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();

  }
}*/

// 시도 3
/*
import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();

    char[] arr = s.toCharArray();
    int[] num = new int[10];

    int arrLen = arr.length;
    for(int i = 0; i < arrLen; i++) {
      num[arr[i] - '0']++;
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 9; i >= 0; i--) {
      for(int j = 0; j < num[i]; j++) {
        sb.append(i);
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();

  }
}
*/
