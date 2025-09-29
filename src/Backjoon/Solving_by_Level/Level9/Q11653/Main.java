package Backjoon.Solving_by_Level.Level9.Q11653;

import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {

    // 1. try-with-resources 로 자원을 안전하게 관리
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

      int N = Integer.parseInt(br.readLine());

      // 2. 시간 복잡도 개선: i * i <= N (즉, i <= √N) 까지만 반복
      for (int i = 2; i * i <= N; i++) {
        while (N % i == 0) {
          bw.write(i + "\n");
          N /= i;
        }
      }

      // 3. 루프가 끝난 후 N이 1보다 크면, 남은 N은 그 자체가 소인수
      if (N > 1) {
        bw.write(N + "\n");
      }
      // 4. close()가 자동으로 flush()를 호출하므로 flush()는 생략 가능
    }
  }
}