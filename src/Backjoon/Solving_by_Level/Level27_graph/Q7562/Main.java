package Backjoon.Solving_by_Level.Level27_graph.Q7562;

import java.io.*;
import java.util.*;

public class Main {
  static StringBuilder sb = new StringBuilder();
  static int[][] visited;
  static int[] rowMove = {2, 1, -1, -2, -2, -1, 1, 2};
  static int[] columnMove = {1, 2,  2, 1, -1, -2, -2, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    StringTokenizer st;
    while (T-- > 0) {
      int I = Integer.parseInt(br.readLine());

      visited = new int[I][I];

      st = new StringTokenizer(br.readLine());
      int startRow = Integer.parseInt(st.nextToken());
      int startColumn = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      int endRow = Integer.parseInt(st.nextToken());
      int endColumn = Integer.parseInt(st.nextToken());


      if (startRow == endRow && startColumn == endColumn) {
        sb.append(0).append("\n");
        continue;
      }

      bfs(I, startRow, startColumn, endRow, endColumn);
      sb.append(visited[endRow][endColumn]).append("\n");
    }

    System.out.print(sb);
    br.close();
  }

  static void bfs(int I, int startRow, int startColumn, int endRow, int endColumn) {
    ArrayDeque<Integer> queue = new ArrayDeque<>();

    queue.offerLast(startRow);
    queue.offerLast(startColumn);
    visited[startRow][startColumn] = 0;

    while (queue.isEmpty() == false) {
      int tmpRow = queue.pollFirst();
      int tmpColumn = queue.pollFirst();

      for(int i = 0; i < 8; i++) {
        int nextRow = tmpRow + rowMove[i];
        int nextColumn = tmpColumn + columnMove[i];

        if (nextRow == endRow && nextColumn == endColumn) {
          visited[nextRow][nextColumn] = visited[tmpRow][tmpColumn] + 1;
          return;
        }

        if (0 <= nextRow && nextRow < I && 0 <= nextColumn && nextColumn < I && visited[nextRow][nextColumn] == 0) {
          queue.offerLast(nextRow);
          queue.offerLast(nextColumn);
          visited[nextRow][nextColumn] = visited[tmpRow][tmpColumn] + 1;
        }
      }
    }
  }

}
