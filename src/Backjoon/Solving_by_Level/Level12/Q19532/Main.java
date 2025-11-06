package Backjoon.Solving_by_Level.Level12.Q19532;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int d = sc.nextInt();
    int e = sc.nextInt();
    int f = sc.nextInt();

    // 크래머 공식(또는 연립방정식 풀이)을 이용
    // 분모 (ae - bd)는 0이 아님이 보장됨 (유일한 해 존재)
    int denominator = a * e - b * d;

    // x = (ce - bf) / (ae - bd)
    int x = (c * e - b * f) / denominator;

    // y = (af - cd) / (ae - bd)
    int y = (a * f - c * d) / denominator;

    System.out.println(x + " " + y);

    sc.close();
  }
}
