import java.util.ArrayList;
import java.util.Scanner;

public class WorkoutTracker {
  // creates a class called WorkoutTracker which is used as a user interface where
  // users input their workout data.
  static ArrayList<Exercise> exercises = new ArrayList<Exercise>();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to Lyfter!");
    System.out.println("What's your workout?");
    System.out.println("1. Add Exercise");// Allows user to add an Exercise
    System.out.println("2. View Exercise");// Allows user to view an Exercise
    System.out.println("3. One Rep Max Calculator");
    // Allows user to calculate their ORM by inputting their lift weight & amount of
    // reps
    System.out.println("4. Exit");// Allows user to exit the application
    boolean exit = false;
    while (!exit) {
      System.out.print("Enter your choice (1-4): ");
      int choice = scanner.nextInt();
      // Adds functionality to user interface selection
      switch (choice) {
        case 1:
          addExercise();
          break;
        case 2:
          viewExercise();
          break;
        case 3:
          calculateOneRepMax();
          break;
        case 4:
          exit = true;
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
    scanner.close();
  }

  // Adds functionality to addExercise providing a sequence of requested inputs.
  public static void addExercise() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter exercise:");
    String name = scanner.nextLine();
    System.out.println("Enter weight lifted (in pounds):");
    int weight = scanner.nextInt();
    System.out.println("Enter the number of reps:");
    int reps = scanner.nextInt();
    Exercise exercise = new Exercise(name, weight, reps);
    exercises.add(exercise);
    System.out.println("Exercise added successfully. Let's get gains!");
    // Shows user their exercise was added successfully
  }

  public static void viewExercise() {
    if (exercises.size() == 0) {
      System.out.println("Sorry, no exercises were found.");
    } else {
      System.out.println("Your Exercise List:");
      System.out.println("___________________");
      for (int i = 0; i < exercises.size(); i++) {
        Exercise exercise = exercises.get(i);
        System.out.println((i + 1) + ". " + exercise.getName() + " - " + exercise.getWeight() + " lbs, "
            + exercise.getReps() + " reps");
      }
    }
  }

  public static void calculateOneRepMax() {
    if (exercises.size() == 0) {
      System.out.println("No exercises found.");
    } else {
      System.out.println("One Rep Max:");
      System.out.println("____________");
      for (int i = 0; i < exercises.size(); i++) {
        Exercise exercise = exercises.get(i);
        // Calculates one rep max using multiplication
        int oneRepMax = (int) (exercise.getWeight() * exercise.getReps() * 0.67);
        System.out.println((i + 1) + ". " + exercise.getName() + " - " + oneRepMax + " lbs");
      }
    }
  }
}

class Exercise {
  private String name;
  private int weight;
  private int reps;

  public Exercise(String name, int weight, int reps) {
    this.name = name;
    this.weight = weight;
    this.reps = reps;
  }

  public String getName() {
    return name;
  }

  public int getWeight() {
    return weight;
  }

  public int getReps() {
    return reps;
  }
}
