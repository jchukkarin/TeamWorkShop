
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class TeamB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับข้อมูลจากผู้ใช้
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter year of birth (CE): ");
        int birthYear = scanner.nextInt();

        System.out.print("Enter your score in Software Testing: ");
        int testingScore = scanner.nextInt();

        // คำนวณอายุ
        int age = calculateAge(birthYear);

        // คำนวณเกรดจากคะแนน
        String grade = calculateGrade(testingScore);

        // สร้างผลลัพธ์สำหรับบันทึกลงไฟล์
        String result = String.format("Name : %s\nAge : %d\nSoftware Testing Grade : %s", userName, age, grade);

        // เขียนผลลัพธ์ลงไฟล์
        String outputPath = "C:/Output/Textfile.txt";
        saveToFile(outputPath, result);

        System.out.println("The data has been successfully saved to the file.");
    }

    // คำนวณอายุจากปีเกิด
    public static int calculateAge(int birthYear) {
        int currentYear = LocalDate.now().getYear();
        return currentYear - birthYear;
    }

    // แปลงคะแนนเป็นเกรด
    public static String calculateGrade(int score) {
        if (score >= 80) return "A";
        else if (score >= 75) return "B+";
        else if (score >= 70) return "B";
        else if (score >= 65) return "C+";
        else if (score >= 60) return "C";
        else if (score >= 55) return "D+";
        else if (score >= 50) return "D";
        else return "F";
    }

    // บันทึกข้อความลงในไฟล์
    public static void saveToFile(String filePath, String content) {
        File file = new File(filePath);
        file.getParentFile().mkdirs(); // สร้างโฟลเดอร์หากไม่มี
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Error: Unable to save the data to the file.");
            e.printStackTrace();
        }
    }
}