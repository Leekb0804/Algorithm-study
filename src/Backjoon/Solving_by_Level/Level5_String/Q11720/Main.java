package Backjoon.Solving_by_Level.Level5_String.Q11720;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int sum = 0;
        for (int i = 0; i<N; i++){
            //sum += Integer.parseInt(String.valueOf(input.charAt(i)));
            sum += input.charAt(i) - '0';
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sum+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
