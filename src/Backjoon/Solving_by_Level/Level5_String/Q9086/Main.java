package Backjoon.Solving_by_Level.Level5_String.Q9086;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(s);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            s = br.readLine();
            sb.append(s.charAt(0)).append(s.charAt(s.length() - 1)).append('\n');
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
