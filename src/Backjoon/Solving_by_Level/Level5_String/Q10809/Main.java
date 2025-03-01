package Backjoon.Solving_by_Level.Level5_String.Q10809;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] chars = new int[26];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (chars[index] == -1) {
                chars[index] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++) {
            sb.append(chars[i]).append(" ");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
