package Backjoon.Solving_by_Level.Level6.Q25206;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input;
    double result = 0;
    double sum = 0;
    int count = 0;
    for(int i = 0; i < 20; i++){
      input = br.readLine().split(" ");
      if (input[2].equals("P")) {
        continue;
      }
      sum += Double.parseDouble(input[1]) * score(input[2]);
      count += Double.parseDouble(input[1]);
    }
    System.out.printf("%.6f", sum / count);
  }

  static public double score(String score) {
    switch(score) {
      case "A+":
        return 4.5;
      case "A0":
        return 4.0;
      case "B+":
        return 3.5;
        case "B0":
          return 3.0;
          case "C+":
            return 2.5;
            case "C0":
              return 2.0;
              case "D+":
                return 1.5;
                case "D0":
                  return 1.0;
      case "F":
        return 0.0;
        default:
          return 0.0;
    }
  }
}
