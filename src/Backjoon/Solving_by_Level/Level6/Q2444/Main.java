package Backjoon.Solving_by_Level.Level6.Q2444;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N - i - 1; j++) {
                sb.append(" ");
            }
            for(int j = 0; j < 2 * i + 1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        for(int i = N - 2; i >= 0; i--) {
            for(int j = 0; j < N - i - 1; j++) {
                sb.append(" ");
            }
            for(int j = 0; j < 2 * i + 1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
