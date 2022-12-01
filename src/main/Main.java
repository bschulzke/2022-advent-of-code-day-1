package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    try {
      File myObj = new File("src/input/input.txt");
      Scanner myReader = new Scanner(myObj);
      ArrayList<String> lines = new ArrayList<>();

      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        lines.add(data);
      }

      ArrayList<Integer> totalCaloriesPerElf = new ArrayList<>();
      int currCalories = 0;

      for (String line : lines) {
        if (line.equals("\n") || line.equals("")) {
          totalCaloriesPerElf.add(currCalories);
          currCalories = 0;
        } else {
          currCalories += Integer.parseInt(line);
        }
      }

      totalCaloriesPerElf.sort(Integer::compareTo);

      int biggest = totalCaloriesPerElf.get(totalCaloriesPerElf.size() - 1);
      int secondBiggest = totalCaloriesPerElf.get(totalCaloriesPerElf.size() - 2);
      int thirdBiggest = totalCaloriesPerElf.get(totalCaloriesPerElf.size() - 3);

      System.out.println(biggest + secondBiggest + thirdBiggest);

      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

}
