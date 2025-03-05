package Backjoon.Solving_by_Level.Level5_String.Q2675;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] s = br.readLine().split(" ");
            int R = Integer.parseInt(s[0]);
            for (int j = 0; j < s[1].length(); j++) {
                for (int k = 0; k < R; k++) {
                    sb.append(s[1].charAt(j));
                }
            }
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
