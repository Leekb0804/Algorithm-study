package Backjoon.Solving_by_Level.Level20_BackTracking.Q14888;

/*
import java.io.*;
import java.util.*;

public class Main {
  public static int N;
  public static int[] nums;			// 숫자 저장 배열
  public static int charCalsSize = 0;
  public static char[] charCals;		// 연산자 저장 배열
  public static boolean[] isCalUsed;	// 연산자 사용되었는지 체크하는 배열

  public static Integer max = null;	// 최댓값
  public static Integer min = null;	// 최솟값


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    nums = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    int[] cal = new int[4];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < 4; i++) {
      cal[i] = Integer.parseInt(st.nextToken());
      charCalsSize += cal[i];
    }

    charCals = new char[charCalsSize];
    isCalUsed = new boolean[charCalsSize];

    // charCals 배열 초기화
    int index = 0;
    for(int i = 0; i < 4; i++) {
      for(int j = 0; j < cal[i]; j++) {
        if (i == 0) {
          charCals[index] = '+';
        }

        if (i == 1) {
          charCals[index] = '-';
        }

        if (i == 2) {
          charCals[index] = '*';
        }

        if (i == 3) {
          charCals[index] = '/';
        }

        index++;
      }
    }

    // isCalUsed 초기화
    Arrays.fill(isCalUsed, false);

    calculate(1, nums[0]);

    System.out.println(max);
    System.out.println(min);

    br.close();
  }

  public static void calculate(int numIndex, int result) {
    if (numIndex == N) {
      if (max == null) {
        max = result;
      } else {
        max = Math.max(max, result);
      }

      if (min == null) {
        min = result;
      } else {
        min = Math.min(min, result);
      }
    }

    for(int i = 0; i < charCalsSize; i++) {
      if (isCalUsed[i] == true) {
        continue;
      }

      isCalUsed[i] = true;
      if (charCals[i] == '+') {
        calculate(numIndex + 1, result + nums[numIndex]);
      } else if (charCals[i] == '-') {
        calculate(numIndex + 1, result - nums[numIndex]);
      } else if (charCals[i] == '*') {
        calculate(numIndex + 1, result * nums[numIndex]);
      } else {
        calculate(numIndex + 1, result / nums[numIndex]);
      }
      isCalUsed[i] = false;
    }
  }
}*/

import java.io.*;
import java.util.*;

public class Main {
  public static int N;
  public static int[] nums;

  public static int max = Integer.MIN_VALUE;
  public static int min = Integer.MAX_VALUE;

  public static void calculate(int numIndex, int add, int sub, int mul, int div, int result) {
    if (numIndex == N) {
      max = Math.max(max, result);
      min = Math.min(min, result);
    }

    if (add > 0) {
      calculate(numIndex + 1, add - 1, sub, mul, div, result + nums[numIndex]);
    }
    if (sub > 0) {
      calculate(numIndex + 1, add, sub - 1, mul, div, result - nums[numIndex]);
    }
    if (mul > 0) {
      calculate(numIndex + 1, add, sub, mul - 1, div, result * nums[numIndex]);
    }
    if (div > 0) {
      calculate(numIndex + 1, add, sub, mul, div - 1, result / nums[numIndex]);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    nums = new int[N];
    for(int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }


    st = new StringTokenizer(br.readLine());
    int add = Integer.parseInt(st.nextToken());
    int sub = Integer.parseInt(st.nextToken());
    int mul = Integer.parseInt(st.nextToken());
    int div = Integer.parseInt(st.nextToken());

    calculate(1, add, sub, mul, div, nums[0]);

    System.out.println(max);
    System.out.println(min);
  }
}
