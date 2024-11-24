import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        ArrayList<Integer> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Student Grade Tracker!");
        System.out.println("Enter student grades (type -1 to finish):");

        while (true) {
            int grade = scanner.nextInt();
            if (grade == -1) break;
            if (grade >= 0 && grade <= 100) {
                grades.add(grade);
            } else {
                System.out.println("Invalid grade. Please enter a value between 0 and 100.");
            }
        }

        if (grades.isEmpty()) {
            System.out.println("No grades entered.");
        } else {
            int highest = grades.stream().max(Integer::compare).orElse(0);
            int lowest = grades.stream().min(Integer::compare).orElse(0);
            double average = grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);

            System.out.println("Grade Summary:");
            System.out.println("Highest Grade: " + highest);
            System.out.println("Lowest Grade: " + lowest);
            System.out.printf("Average Grade: %.2f%n", average);
        }

        scanner.close();
    }
}
