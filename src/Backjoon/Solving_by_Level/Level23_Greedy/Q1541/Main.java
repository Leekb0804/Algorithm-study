  package Backjoon.Solving_by_Level.Level23_Greedy.Q1541;

  import java.io.*;
  import java.util.*;

  public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String s = br.readLine();

      int tmp = 0;
      int result = 0;

      boolean check = false;

      char previousState = '0';

      for(int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        if ('0' <= c && c <= '9') {
          tmp *= 10;
          tmp += c - '0';
        } else {
          if (previousState == '0') {
            result += tmp;
          } else if (previousState == '+' && check == false) {
            result += tmp;
          } else {
            result -= tmp;
            check = true;
          }
          previousState = c;
          tmp = 0;
        }
      }

      if (previousState == '0') {
        result += tmp;
      } else if (previousState == '+' && check == false) {
        result += tmp;
      } else {
        result -= tmp;
      }

      System.out.println(result);
      br.close();
    }
  }