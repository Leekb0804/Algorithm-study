package Backjoon.Solving_by_Level.Level5_String.Q5622;

import java.io.*;

public class Q5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int sum = 0;
        int[] dial = {3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10};

        for (char c : S.toCharArray()) {
            sum += dial[c - 'A'];  // 'A'부터의 인덱스로 바로 값 참조
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sum + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
