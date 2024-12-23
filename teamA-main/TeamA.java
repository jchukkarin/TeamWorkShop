import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.time.Year;

public class TeamA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับข้อมูลจากผู้ใช้
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Christian Era (Year of Birth): ");
        int yearOfBirth = scanner.nextInt();

        System.out.print("Enter Software Testing Score: ");
        int score = scanner.nextInt();

        // คำนวณอายุ
        int currentYear = Year.now().getValue();
        int age = currentYear - yearOfBirth;

        // แปลงคะแนนเป็นเกรด
        String grade = getGrade(score);

        // เตรียมข้อความผลลัพธ์
        String output = "Name : " + name + "\n" +
                        "Age : " + age + "\n" +
                        "Software Testing Grade : " + grade;

        // เขียนผลลัพธ์ลงในไฟล์
        String filePath = "C:/Output/Textfile.txt";
        writeToFile(filePath, output);

        System.out.println("Data written to file successfully!");
    }

    // ฟังก์ชันแปลงคะแนนเป็นเกรด
    private static String getGrade(int score) {
        if (score >= 80) return "A";
        if (score >= 75) return "B+";
        if (score >= 70) return "B";
        if (score >= 65) return "C+";
        if (score >= 60) return "C";
        if (score >= 55) return "D+";
        if (score >= 50) return "D";
        return "F";
    }

    // ฟังก์ชันเขียนข้อมูลลงในไฟล์
    private static void writeToFile(String filePath, String content) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
