
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TeamA {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Output\\Textfile.txt");
            Scanner scanner = new Scanner(file);

            int currentYear = 2024;

            while (scanner.hasNextLine()) {
                String name = "";
                int birthYear = 0;
                int score = 0;

         
                String line = scanner.nextLine().trim();
                if (line.startsWith("Name")) {
                    name = line.split(" : ")[1].trim();
                }
                line = scanner.nextLine().trim();
                if (line.startsWith("Chistian Era")) {
                    birthYear = Integer.parseInt(line.split(" : ")[1].trim());
                }
                line = scanner.nextLine().trim();
                if (line.startsWith("Software Testing Score")) {
                    score = Integer.parseInt(line.split(" : ")[1].trim());
                }

 
                int age = currentYear - birthYear;
                String grade = calculateGrade(score);

  
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Software Testing Score: " + grade);
                
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("ไม่พบไฟล์: " + e.getMessage());
        }
    }

    public static String calculateGrade(int score) {
        if (score >= 80) return "A";
        if (score >= 75) return "B+";
        if (score >= 70) return "B";
        if (score >= 65) return "C+";
        if (score >= 60) return "C";
        if (score >= 55) return "D+";
        if (score >= 50) return "D";
        return "F";
    }
}
