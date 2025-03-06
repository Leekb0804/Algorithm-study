package Backjoon.Solving_by_Level.Level5_String.Q2908;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(new StringBuilder(input[0]).reverse().toString());
        int B = Integer.parseInt(new StringBuilder(input[1]).reverse().toString());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        sb.append(Math.max(A, B));
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
