package Backjoon.Solving_by_Level.Level5_String.Q11654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.charAt(0);
        StringBuilder sb = new StringBuilder();
        sb.append(N);
        //sb.append(Integer.toString(br.readLine().charAt(0))); 과 같다.
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
