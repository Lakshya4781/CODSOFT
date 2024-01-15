import java.util.Scanner;

public class StudentGradeCalcualtor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter marks obtained in each subject (out of 100):");
        int subjects = 0;
        int totalMarks = 0;

        while (true) {
            System.out.print("Subject " + (subjects + 1) + ": ");
            int marks = scanner.nextInt();

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks. Please enter marks in the range 0-100.");
                continue;
            }
            totalMarks += marks;
            subjects++;

            // Ask if the user wants to input marks for another subject
            System.out.print("Do you want to enter marks for another subject? (yes/no): ");
            String choice = scanner.next().toLowerCase();
            if (!choice.equals("yes")) {
                break;
            }
        }

        double averagePercentage = (double) totalMarks / subjects;

        char grade = calculateGrade(averagePercentage);
   
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

    }
    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}

