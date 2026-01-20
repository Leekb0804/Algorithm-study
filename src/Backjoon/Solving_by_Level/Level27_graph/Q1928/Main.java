package Backjoon.Solving_by_Level.Level27_graph.Q1928;

/* 주사위 1~6 -> 1칸~6칸 이동 가능
1~6칸 이동한 것들 모두가 의미 있는 이동은 아님.
    bfs 로 접근하는데
    queue에는 사다리를 탄 이동과 뱀을 탄 이동과 최대이동(6칸)만 삽입*/

// 이 문제는 뭘 보고 bfs로 접근해야 한다고 생각할 수 있었을까?

import java.io.*;
import java.util.*;

public class Main {
  static int[] ladder = new int[101];
  static int[] snake = new int[101];
  static boolean[] visited = new boolean[101];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    Arrays.fill(ladder, 0);
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      ladder[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
    }

    Arrays.fill(snake, 0);
    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      snake[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
    }


    System.out.println(bfs());
    br.close();
  }

  public static int bfs() {
    ArrayDeque<int []> queue = new ArrayDeque<>();
    queue.offerLast(new int[] {1, 0});	// 첫번째 인덱스는 현재 위치, 두번째 인덱스는 주사위 횟수
    visited[1] = true;

    while (queue.isEmpty() == false) {
      int[] tmp = queue.pollFirst();
      int location = tmp[0];
      int diceCnt = tmp[1];


      // 주사위 6 ~ 1까지의 경우 이동
      boolean maxNumFlag = false;	// 6~1 중 사다리나 뱀을 타지않는 값 중 최댓값이 queue에 삽입 되었는지
      for(int i = 6; i >= 1; i--) {
        if (location + i > 100) {
          continue;
        }
        if (location + i == 100) {
          return diceCnt + 1;
        }

        if (visited[location + i] == true) {
          continue;
        }

        if (ladder[location + i] != 0) {
          queue.offerLast(new int[] {ladder[location+i], diceCnt + 1});
          visited[location + i] = true;
        } else if (snake[location + i] != 0) {
          queue.offerLast(new int[] {snake[location + i], diceCnt + 1});
          visited[location + i] = true;
        } else if (maxNumFlag == false) {
          queue.offerLast(new int[] {location +i, diceCnt + 1});
          maxNumFlag = true;
          visited[location + i] = true;
        }
      }

    }
    return 0;
  }
}


