package Backjoon.Solving_by_Level.Level26_priority_queue.Q1202;

import java.io.*;
import java.util.*;

public class Main {
  static class Jewrly {
    int weight;
    int value;

    public Jewrly (int weight, int value) {
      this.weight = weight;
      this.value = value;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    PriorityQueue<Jewrly> minJewrlyWeightHeap = new PriorityQueue<>(N, (a, b) -> {
      if (a.weight == b.weight) {
        return Integer.compare(a.value, b.value);
      }

      return Integer.compare(a.weight, b.weight);
    });

    // 보석 입력
    for(int i = 0; i  <N; i++) {
      st = new StringTokenizer(br.readLine());
      int weight = Integer.parseInt(st.nextToken());
      int value = Integer.parseInt(st.nextToken());

      minJewrlyWeightHeap.offer(new Jewrly(weight, value));
    }

    // 가방 입력
    int[] bags = new int[K];
    for(int i = 0; i < K; i++) {
      bags[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(bags);

    // 가방에 보석 넣기
    PriorityQueue<Jewrly> maxJewrlyValueHeap = new PriorityQueue<>(N, (a, b) -> {
      if (a.value == b.value) {
        return Integer.compare(b.weight, a.weight);
      }

      return Integer.compare(b.value, a.value);
    } );

    long result = 0;
    int bagIndex = 0;
    while (bagIndex < K) {
      int standard = bags[bagIndex];

      while (!(minJewrlyWeightHeap.isEmpty()) && minJewrlyWeightHeap.peek().weight <= standard) {
        maxJewrlyValueHeap.offer(minJewrlyWeightHeap.poll());
      }

      if (!maxJewrlyValueHeap.isEmpty()) {
        result += maxJewrlyValueHeap.poll().value;
      }
      bagIndex++;
    }

    System.out.println(result);
    br.close();
  }
}

