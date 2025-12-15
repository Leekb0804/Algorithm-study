package Backjoon.Solving_by_Level.Level21_DP.Q12865;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());	// 물품 수
    int K = Integer.parseInt(st.nextToken());	// 무게 한계치

    int[] weight = new int[N];		// 물품 무게 배열
    int[] value = new int[N];			// 물품 가치 배열

    int[] dp = new int[K + 1];		// 인덱스는 물품들의 총 무게를 의미 / 값은 해당 무게일때의 최대 가치를 의미

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      weight[i] = Integer.parseInt(st.nextToken());
      value[i] = Integer.parseInt(st.nextToken());
    }

    for(int j = 0; j < N; j++) {      // 물품 순회를 먼저  => 물품 순회를 진행하면서 dp값이 갱신됨.
      for(int i = K; i > 0; i--) {      // 왜 내림차순으로 순회하는가?   => Math.max(dp[i], dp[i - weight[j]] + value[j]) 를 진행할때, 현재 물품이 dp[i - weight[j]] 에 포함되지 않도록 하기 위해서. / 중복방지
        if (i - weight[j] >= 0) {
          dp[i] = Math.max(dp[i], dp[i - weight[j]] + value[j]);
        }
      }
    }

    System.out.println(dp[K]);
    br.close();

  }
}

/*
해결 방법 1.

무게 오름차순으로 정렬되어 입력이 들어온다면? 2차 정렬은 가치 오름차순	=> 그냥 가치 오름차순으로만 해도 될듯(중복되는 무게는
weight / value 배열을 나누지 말고

    무게를 인덱스로하는 value 배열을 생성

    int[] value = new int[K]

    value를 전부 채우기
    value[i] = (값);

--------------------------------- 안됨 : why? 같은 무게의 다른 가치의 물건들이 존재할 수 있음.

// 해결방법 2.

dp 전체를 훑으면서 값을 대입



3 6
    4 8
    5 12
    6 13

dp[0] = 0;
dp[1] = 0;
dp[2] = 0;		// 1. i값 확인 / 2.
dp[3] = 6;
dp[4] = 8;
dp[5] =


만약

1 1
    1 2
    1 3
    1 4

가 들어오면?

// 따로 weight / value 배열 없이 무게를 기준으로 오름차순 정렬된 물품들이 입력된다고 가정

dp[0] = 0;

i = 1;
dp[1] = 1;

i = 2;
// 1.  i 값 확인 dp[i] 값 Math.max(dp[i], value);

// 2.



    ---------------- 복잡해지는듯?


해결방법 3.

// 따로 weight / value 배열 없이 무게를 기준으로 오름차순 정렬된 물품들이 입력된다고 가정

해당 인덱스의 물품은 반드시 넣는다고 가정

예시 입력
3 6
    4 8
    5 12
    6 13


dp[wieght] = value;


// 중복 무게 물품의 경우?

1 1
    1 2
    1 3
    1 4

dp[weight] = value;

//////////////////////

dp[K] = Math.max(dp[K], dp[K - weight] + value);
*/




