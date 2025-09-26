package Backjoon.Solving_by_Level.Level9.Q9506;

import static java.lang.Math.sqrt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    while (true) {
      int n = Integer.parseInt(br.readLine());
      if (n == -1) {
        break;
      }

      List<Integer> list = new ArrayList<>();
      int sum = 0;
      for (int i = 1; i < n; i++) {
        if (n % i == 0) {
          list.add(i);
          sum += i;
        }
      }

      if (sum == n) {
        sb.append(n).append(" = ");
        for (int i = 0; i < list.size(); i++) {
          if (i != 0) {
            sb.append(" + ");
          }
          sb.append(list.get(i));
        }
        sb.append("\n");
      } else {
        sb.append(n).append(" is NOT perfect.\n");
      }
    }

    bw.write(sb.toString());

    br.close();
    bw.close();
  }

}
