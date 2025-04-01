package Backjoon.Solving_by_Level.Level6.Q2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] alphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for(String word : alphabets) {
            s = s.replaceAll(word, "*");
        }
        System.out.println(s.length());
        br.close();
    }
}
