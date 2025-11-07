import java.util.Scanner;

public class StudentResult {
    
    // Method to calculate grade point from total mark
    static double gradePoint(double total) {
        if (total >= 80) return 4.0;
        else if (total >= 75) return 3.75;
        else if (total >= 70) return 3.5;
        else if (total >= 65) return 3.25;
        else if (total >= 60) return 3.0;
        else if (total >= 55) return 2.75;
        else if (total >= 50) return 2.5;
        else if (total >= 45) return 2.25;
        else if (total >= 40) return 2.0;
        else return 0.0;
    }

    // Method to get letter grade
    static String letterGrade(double gp) {
        if (gp == 4.0) return "A+";
        else if (gp >= 3.75) return "A";
        else if (gp >= 3.5) return "A-";
        else if (gp >= 3.25) return "B+";
        else if (gp >= 3.0) return "B";
        else if (gp >= 2.75) return "B-";
        else if (gp >= 2.5) return "C+";
        else if (gp >= 2.25) return "C";
        else if (gp >= 2.0) return "D";
        else return "F";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Student ID: ");
        String studentID = sc.nextLine();

        System.out.print("No. of Courses: ");
        int n = sc.nextInt();

        double totalCredit = 0, earnedCredit = 0, weightedGP = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println("\nC" + i + ":");

            System.out.print("Credit (Max 3): ");
            double credit = sc.nextDouble();

            System.out.print("CT (Max 30): ");
            double ct = sc.nextDouble();

            System.out.print("AT (Max 10): ");
            double at = sc.nextDouble();

            System.out.print("FE (Max 60): ");
            double fe = sc.nextDouble();

            double totalMark = ct + at + fe;
            double percentage = (totalMark / 100) * 100;
            double gp = gradePoint(percentage);

            totalCredit += credit;
            weightedGP += gp * credit;

            if (gp > 0) earnedCredit += credit;
        }

        double cgpa = weightedGP / totalCredit;
        String grade = letterGrade(cgpa);

        System.out.println("\n-----------------------------");
        System.out.println("Student ID: " + studentID);
        System.out.println("Credit Taken: " + totalCredit);
        System.out.println("Credit Earned: " + earnedCredit);
        System.out.printf("CGPA: %.2f%n", cgpa);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}


