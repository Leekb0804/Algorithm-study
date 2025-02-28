package Backjoon.Solving_by_Level.Level4_1D_Array.Q1546;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        double[] arr = new double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        double max = Arrays.stream(arr).max().getAsDouble();
        double sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = arr[i] / max * 100;
            sum += arr[i];
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.format("%f", sum / N));
        bw.flush();
        br.close();
        bw.close();

        /*
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        sb.append(sum / N);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();*/
    }
}
