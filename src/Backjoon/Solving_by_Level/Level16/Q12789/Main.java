package Backjoon.Solving_by_Level.Level16.Q12789;

import java.io.*;
import java.util.*;

public class Main {
  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    Deque<Integer> inputQueue = new ArrayDeque<>();
    Deque<Integer> tmp_stack = new ArrayDeque<>();

    for(int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      inputQueue.offerLast(num);
    }

    int result = 0;
    while (result < N) {
      if (!(inputQueue.isEmpty()) && result + 1 == inputQueue.peekFirst()) {
        result = inputQueue.pollFirst();
      } else if (!(tmp_stack.isEmpty()) && result + 1 == tmp_stack.peekFirst()) {
        result = tmp_stack.pollFirst();
      } else {
        if (inputQueue.isEmpty()) {
          break;
        }
        int tmp = inputQueue.pollFirst();
        tmp_stack.offerFirst(tmp);
      }
    }


    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    if (result == N) {
      bw.write("Nice");
    } else {
      bw.write("Sad");
    }
    bw.flush();

    br.close();
    bw.close();
  }
}
