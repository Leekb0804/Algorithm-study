package Backjoon.Solving_by_Level.Level13.Q18870;

/*일단 입력받고

    HashSet 으로 옮기고 (중복제거)

    ArrayList 로 옮기고 정렬

    인덱스 0부터 끝까지 탐색하며 value, index 값을 map에 저장?

    hashMap? 을 사용

    기존 입력받은 배열을 순회하며 값을 키로 받아 hashmap에서 value값 추출*/

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] originalArr = new int[N];
    HashSet<Integer> hashSet = new HashSet<>();

    for(int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      originalArr[i] = num;
      hashSet.add(num);
    }

    ArrayList<Integer> arrList = new ArrayList<>(hashSet);

    Collections.sort(arrList);

    HashMap<Integer, Integer> hashMap = new HashMap<>();

    int arrListLength = arrList.size();
    for(int i = 0; i < arrListLength; i++) {
      hashMap.put(arrList.get(i), i);
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < N; i++) {
      int result = hashMap.get(originalArr[i]);
      sb.append(result).append(" ");
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();
  }
}

// 메모리 공간을 절약하는 풀이
/*
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] originalArr = new int[N];
    int[] sortedArr = new int[N]; // 정렬 및 중복 제거용 배열

    for (int i = 0; i < N; i++) {
        int num = Integer.parseInt(st.nextToken());
        originalArr[i] = num;
        sortedArr[i] = num;
    }

    // 1. 정렬 (N log N)
    Arrays.sort(sortedArr);

    // 2. 정렬된 배열을 순회하며 HashMap 생성 (중복 제거 포함)
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    int rank = 0; // 좌표 압축 결과 (순위)

    for (int value : sortedArr) {
        // 맵에 아직 이 값이 등록되지 않았다면 (중복이 아니라면)
        if (!hashMap.containsKey(value)) {
            hashMap.put(value, rank);
            rank++; // 다음 순위를 1 증가
        }
    }

    // 3. 원본 배열을 순회하며 결과 출력 (N)
    StringBuilder sb = new StringBuilder();
    for (int originalValue : originalArr) {
        int result = hashMap.get(originalValue);
        sb.append(result).append(" ");
    }

    // ... (BufferedWriter로 출력)
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();
}
 */