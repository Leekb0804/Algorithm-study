package Backjoon.Solving_by_Level.Level6.Q10988;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int left = 0;
        int right = input.length() - 1;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                bw.write("0");
                bw.flush();
                return;
            }
            left++;
            right--;
        }
        bw.write("1");
        bw.flush();
    }
}
