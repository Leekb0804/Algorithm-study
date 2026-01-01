package Backjoon.Solving_by_Level.Level25_BinarySearch.Q2110;

import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int K;
  static int[] homes;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    homes = new int[N];

    for(int i = 0; i < N; i++) {
      homes[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(homes);

    System.out.println(solution());
    br.close();
  }

  public static int solution( ) {
    int low = 1;
    int high = homes[N - 1] - homes[0];
    int answer = 0;

    while (low < high) {
      int mid = (low + high) >>> 1;		// 기준 간격 (이 간격보다는 크거나 같게 떨어져 있다고 생각)

      //System.out.println("mid = " + mid);

      // mid만큼의 간격으로 떨어져 있으면 K개의 공유기를 세울 수 있냐?
      if (check(mid)) {		// 있다.
        low = mid + 1;			// mid를 늘려봐
        answer = mid;
      } else {	// 없다.
        high = mid;		// mid를 줄여봐
      }
    }

    if (check(high)) {
      answer = high;
    }

    //return low;
    return answer;
  }

  public static boolean check (int interval) {

    int cnt = 1;
    int i = 1;
    int past = homes[0];
    while (i < N) {
      if (homes[i] - past >= interval) {
        cnt++;
        past = homes[i];
      }

      if (cnt >= K) {
        break;
      }

      i++;
    }

    //System.out.println("interval = " + interval + " cnt = " + cnt);

    if (cnt >= K) {
      return true;
    } else {
      return false;
    }
  }
}


