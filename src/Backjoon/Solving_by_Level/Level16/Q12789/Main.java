package Backjoon.Solving_by_Level.Level16.Q12789;

import java.io.*;
import java.util.*;

public class Main {
  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    Deque<Integer> stack = new ArrayDeque<>();

    int resultTop = 0;
    boolean check = true;
    for(int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      if (resultTop + 1 == num) {
        resultTop = num;
      } else if (!(stack.isEmpty()) && stack.peekFirst() == resultTop + 1) {
        resultTop = stack.pollFirst();
      } else {
        if ( !(stack.isEmpty()) && stack.peekFirst() < num ) {
          System.out.println("resultTop = " + resultTop + ", num = " + num + ", stack.peekFirst() = " + stack.peekFirst());

          check = false;
          break;
        }
        stack.offerFirst(num);
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    if (check) {
      bw.write("Nice");
    } else {
      bw.write("Sad");
    }
    bw.flush();

    br.close();
    bw.close();
  }
}
