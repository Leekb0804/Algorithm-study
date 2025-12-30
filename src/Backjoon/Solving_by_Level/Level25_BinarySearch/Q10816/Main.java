package Backjoon.Solving_by_Level.Level25_BinarySearch.Q10816;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] cards = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      cards[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(cards);

    int M = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < M; i++) {
      int target = Integer.parseInt(st.nextToken());
      sb.append(getUpperBound(cards, target) - getLowerBound(cards, target)).append(" ");
    }

    System.out.println(sb);
    br.close();
  }

  public static int getLowerBound(int[] cards, int target) {
    int left = 0;
    int right = cards.length;

    while (left < right) {
      int mid = (left + right) >>> 1;

      if (target <= cards[mid]) {      // mid 주위로 target 값들이 여러개 나열되어 있다고 생각해보자, 우리가 찾는건 target 의 가장 낮은 인덱스다. 그러면 범위를 좁힐때 오른쪽 벽을 mid로 땡겨와야한다.
        right = mid;
      } else {
        left = mid + 1;         // else 로 분기한 경우는 cards[mid]값이 target보다 작을때이다. 같을때는 위의 if문에 걸러진다. 그러므로 mid값이 target 값이 될 수 없으니 왼쪽 벽을 mid + 1로 땡겨온다. (필요없는 범위(mid) 제거)
      }
    }

    return left;
  }

  public static int getUpperBound(int[] cards, int target) {
    int left = 0;
    int right = cards.length;

    while (left < right) {
      int mid = (left + right) >>> 1;

      if (target >= cards[mid]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return left;
  }

}




