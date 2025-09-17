package Backjoon.Solving_by_Level.Level7_Math.Q11005;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    // 내가 생각한 로직
    /*int tmp_N = N / B;
    int tmp_B = 1;
    while (tmp_N > 0) {
      tmp_N = tmp_N / B;

      tmp_B *= B;
    }

    while (tmp_B > 0) {
      int tmp = N / tmp_B;

      if (tmp < 10) {
        char c = (char) ('0' + tmp);
        bw.append(c);
      } else {
        char c = (char) ('A' + tmp - 10);
        bw.append(c);
      }

      N %= tmp_B;
      tmp_B /= B;
    }

    bw.flush();
     */

    solve(N, B);

  }

  // gemini 가 추천한 로직
  public static void solve(int N, int B) throws IOException {
    if (N == 0) {
      return;
    }

    solve(N / B, B);
    int remainder = N % B;
    if (remainder < 10) {
      System.out.print(remainder);
    } else {
      System.out.print((char)('A' + remainder - 10));
    }
  }
}
