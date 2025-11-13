package Backjoon.Solving_by_Level.Level16.Q4949;

import java.io.*;
import java.util.*;

public class Main{
  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    Deque<Character> stack = new ArrayDeque<>();
    boolean check;
    StringBuilder sb = new StringBuilder();
    while (!(s.equals("."))) {
      check = true;
      for(int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        if (c == '[' || c == '(') {
          stack.offerFirst(c);
        }

        if (c == ']') {
          if ( stack.isEmpty() || stack.peekFirst() != '[') {
            check = false;
            break;
          } else {
            stack.pollFirst();
          }
        }

        if (c == ')') {
          if ( stack.isEmpty() || stack.peekFirst() != '(') {
            check = false;
            break;
          } else {
            stack.pollFirst();
          }
        }
      }
      if (! (stack.isEmpty()) ) {
        check = false;
      }

      if (check) {
        sb.append("yes").append("\n");
      } else {
        sb.append("no").append("\n");
      }

      stack.clear();
      s = br.readLine();
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();
  }
}