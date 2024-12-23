import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TeamA {
    public static void main(String[] args) {
        try {
            // กำหนดที่อยู่ไฟล์
            File outputFolder = new File("C:\\Output");
            File inputFile = new File(outputFolder, "Textfile.txt");  // ไฟล์ข้อมูลต้นทาง

            // สร้างโฟลเดอร์ Output หากไม่มี
            if (!outputFolder.exists()) {
                outputFolder.mkdirs();
                System.out.println("สร้างโฟลเดอร์ Output ขึ้นมาใหม่");
            }

            // สร้างไฟล์ Textfile.txt ใหม่ หากไม่มีอยู่
            if (!inputFile.exists()) {
                inputFile.createNewFile();
                System.out.println("สร้างไฟล์ Textfile.txt ขึ้นใหม่");
            }

            // สร้าง Scanner เพื่อรับข้อมูลจากผู้ใช้
            Scanner scanner = new Scanner(System.in);
            PrintWriter writer = new PrintWriter(inputFile);

            // อ่านข้อมูลจากผู้ใช้
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            System.out.print("Enter year of birth (CE): ");
            int birthYear = scanner.nextInt();
            
            System.out.print("Enter your score in Software Testing: ");
            int score = scanner.nextInt();

            // คำนวณอายุ
            int currentYear = 2024;
            int age = currentYear - birthYear;

            // คำนวณเกรด
            String grade = calculateGrade(score);

            // แสดงผลในคอนโซล
            System.out.println("\nOutput Textfile.txt");
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Software Testing Score: " + grade);

            // บันทึกข้อมูลลงในไฟล์
            writer.println("Name : " + name);
            writer.println("Christian Era : " + birthYear);
            writer.println("Software Testing Score : " + score);
            writer.println();  // เพิ่มบรรทัดว่าง

            // ปิดไฟล์และ scanner
            writer.close();
            scanner.close();

            System.out.println("\nThe data has been successfully saved to the file.");

        } catch (FileNotFoundException e) {
            System.out.println("ไม่พบไฟล์: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("เกิดข้อผิดพลาด: " + e.getMessage());
        }
    }

    // เมธอดสำหรับคำนวณเกรดตามคะแนน
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
