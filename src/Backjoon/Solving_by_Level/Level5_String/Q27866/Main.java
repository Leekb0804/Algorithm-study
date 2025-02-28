package Backjoon.Solving_by_Level.Level5_String.Q27866;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        char ch = str.charAt(N - 1);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(ch);
        bw.flush();
        br.close();
        bw.close();
    }
}
