package Backjoon.Solving_by_Level.Level21_DP.Q9251;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str1 = br.readLine();
    String str2 = br.readLine();

    int[][] dp = new int[str1.length() + 1][str2.length() + 1];

    for(int i = 0; i < str1.length(); i++) {
      dp[i][0] = 0;
    }

    for(int i = 0; i < str2.length(); i++) {
      dp[0][i] = 0;
    }

    // 순서대로 해당 인덱스까지의 LCS 를 구하기
    // i == 1 이고 j == 3 이라면
    // ACAYKP
    // CAPCAK
    // 입력이 들어왔을때
    // A 와 CAP 를 비교하기
    for(int i = 1; i <= str1.length(); i++) {
      for(int j = 1; j <= str2.length(); j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {   // 같은 글자를 발견하면 해당 글자가 str1, str2 모두 추가되지 않았을때 보다 무조건 1만큼 LCS가 늘어남.
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {        // 그렇지 않은 경우 LCS는 변화없음.
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);    // 다른 글자의 경우 str1에서 i번째 글자가 없는 경우와 str2에서 j번째 글자가 없는 경우, 둘중 큰 LCS 따라간다.
        }
      }
    }

    System.out.println(dp[str1.length()][str2.length()]);
    br.close();
  }
}