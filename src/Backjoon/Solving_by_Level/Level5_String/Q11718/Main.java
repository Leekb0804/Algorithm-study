package Backjoon.Solving_by_Level.Level5_String.Q11718;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        while (input != null) {
            sb.append(input).append("\n");
            input = br.readLine();
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}