package Backjoon.Solving_by_Level.Level28_Topological_Sort.Q2252;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    // 해당 정점에 진입하는 정점들을 저장
    ArrayList<Integer>[] degrees = new ArrayList[N + 1];
    for(int i = 0; i <= N; i++) {
      degrees[i] = new ArrayList<>();
    }

    // 해당 노드의 진입차수
    int[] indegreeCnt = new int[N + 1];

    // 방문   // 없어도 됨.
    boolean[] visited = new boolean[N + 1];

    // 값 저장
    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      degrees[start].add(end);
      indegreeCnt[end]++;
    }

    // 위상 정렬
    ArrayDeque<Integer> queue = new ArrayDeque<>();

    // 진입차수가 0인 정점을 큐에 넣기
    for(int i =1; i <= N; i++) {
      if (indegreeCnt[i] == 0) {
        queue.offerLast(i);
        visited[i] = true;
      }
    }

    StringBuilder sb = new StringBuilder();

    // 정점 출력 횟수 (N번 출력을 했는지)
    int cnt = 0;
    while (queue.isEmpty() == false) {
      int num = queue.pollFirst();

      sb.append(num).append(" ");
      cnt++;

      for(int tmp : degrees[num]) {
        indegreeCnt[tmp]--;
        if (indegreeCnt[tmp] == 0 && visited[tmp] == false) {   // 방문 체크 안해도 됨. 알아서 걸러짐
          queue.offerLast(tmp);
          visited[tmp] = true;
        }
      }
    }


    if (cnt != N) {
      System.out.println("-1");		// 문제에는 이런 경우가 없는듯?
    } else {
      System.out.println(sb);
    }

    br.close();
  }
}