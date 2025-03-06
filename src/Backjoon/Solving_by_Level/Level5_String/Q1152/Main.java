package Backjoon.Solving_by_Level.Level5_String.Q1152;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        StringBuilder sb = new StringBuilder();
        if (input.isEmpty()) {
            sb.append('0');
        } else {
            sb.append(input.split(" ").length);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
