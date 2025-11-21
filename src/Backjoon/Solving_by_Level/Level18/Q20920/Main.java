package Backjoon.Solving_by_Level.Level18.Q20920;

import java.io.*;
import java.util.*;

public class Main {
  public static class Word implements Comparable<Word> {
    int calledCount;
    int length;
    String alphabet;

    public Word (String alphabet) {
      this.alphabet = alphabet;
      this.length = alphabet.length();
      this.calledCount = 1;
    }

    @Override
    public boolean equals(Object o) {
      // 1) 주소 비교: 완전히 동일한 객체(참조)라면 true (성능 최적화)
      if (this == o) return true;

      // 2) 타입 확인: null이거나 클래스 타입이 다르면 false
      if (o == null || getClass() != o.getClass()) return false;

      if (this.alphabet.equals(((Word)o).alphabet)) {
        return true;
      }
      return false;
    }

    @Override
    public int hashCode() {
      return alphabet.hashCode();
    }

    @Override
    public int compareTo(Word other) {
      if (this.calledCount != other.calledCount) {
        return Integer.compare(other.calledCount, this.calledCount);
      }

      if (this.length != other.length) {
        return Integer.compare(other.length, this.length);
      }

      return this.alphabet.compareTo(other.alphabet);
    }
  }

  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    HashMap<String, Word> hashMap= new HashMap<>();
    List<Word> wordList = new ArrayList<>();

    for(int i = 0; i < N; i++) {
      String str = br.readLine();
      if (str.length() >= M) {
        if (hashMap.containsKey(str)) {
          hashMap.get(str).calledCount++;
        } else {
          Word word = new Word(str);
          hashMap.put(str, word);
          wordList.add(word);
        }
      }
    }

    wordList.sort(null);
    StringBuilder sb = new StringBuilder();
    for(Word word : wordList) {
      sb.append(word.alphabet).append("\n");
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();
  }
}