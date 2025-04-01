package Backjoon.Solving_by_Level.Level6.Q1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(s);
        String[] input = new String[N];
        for(int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }
        int count = N;
        boolean[] alphabetTable = new boolean[26];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 26; j++) {
                alphabetTable[j] = false;
            }
            for(int j = 0; j < input[i].length(); j++) {
                if (j == 0) {
                    alphabetTable[input[i].charAt(j) - 'a'] = true;
                } else {
                    if (input[i].charAt(j - 1) != input[i].charAt(j)) {
                        if (alphabetTable[input[i].charAt(j) - 'a'] == false) {
                            alphabetTable[input[i].charAt(j) - 'a'] = true;
                        } else {
                            count--;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}

// gpt 코드 (set을 사용하는 것이 굉장히 인상적)
/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;

public class GroupWordChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int groupWordCount = 0;

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (isGroupWord(word)) {
                groupWordCount++;
            }
        }

        System.out.println(groupWordCount);
    }

    private static boolean isGroupWord(String word) {
        HashSet<Character> seen = new HashSet<>();
        char prev = ' '; // 이전 문자 초기화

        for (int j = 0; j < word.length(); j++) {
            char current = word.charAt(j);

            if (current != prev) {
                if (seen.contains(current)) {
                    return false; // 이전에 나온 적 있는 문자면 그룹 단어 아님
                }
                seen.add(current); // 새로운 문자 등록
                prev = current;   // 이전 문자 갱신
            }
        }
        return true;
    }
}
*/

