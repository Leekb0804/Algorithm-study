package Backjoon.Solving_by_Level.Level6.Q1157;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toUpperCase();
        int[] alphabet = new int[26];
        for (int i = 0; i < input.length(); i++) {
            alphabet[input.charAt(i) - 'A']++;
        }
        int max = -1;
        char result = '?';
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] > max) {
                max = alphabet[i];
                result = (char) (i + 'A');
            } else if (alphabet[i] == max) {
                result = '?';
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(result);
        bw.flush();
        br.close();
        bw.close();
    }
}
