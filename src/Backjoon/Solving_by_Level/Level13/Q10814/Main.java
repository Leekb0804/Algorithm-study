package Backjoon.Solving_by_Level.Level13.Q10814;

import java.io.*;
import java.util.*;

public class Main {
  public static class User implements Comparable<User> {

    int age;
    String name;

    public User (int age, String name) {
      this.age = age;
      this.name = name;
    }

    @Override
    public int compareTo (User other) {
      return Integer.compare(this.age, other.age);
    }
  }

  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st;
    ArrayList<User> users = new ArrayList<>();
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int age = Integer.parseInt(st.nextToken());
      String name = st.nextToken();
      User newUser = new User(age, name);
      users.add(newUser);
    }


    Collections.sort(users);

    StringBuilder sb = new StringBuilder();
    for(User user : users) {
      sb.append(user.age).append(" ").append(user.name).append("\n");
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();

    br.close();
    bw.close();
  }
}
