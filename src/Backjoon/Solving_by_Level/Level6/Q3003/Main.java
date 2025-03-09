package Backjoon.Solving_by_Level.Level6.Q3003;

import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(1 - Integer.parseInt(input[0])).append(" ");
        sb.append(1 - Integer.parseInt(input[1])).append(" ");
        sb.append(2 - Integer.parseInt(input[2])).append(" ");
        sb.append(2 - Integer.parseInt(input[3])).append(" ");
        sb.append(2 - Integer.parseInt(input[4])).append(" ");
        sb.append(8 - Integer.parseInt(input[5]));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
