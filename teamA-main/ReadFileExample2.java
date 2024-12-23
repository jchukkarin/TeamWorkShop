import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;

public class ReadFileExample2 {
    public static void main(String[] args) {
        try {
            // ระบุไฟล์
            File file = new File("C:\\Output\\Textfile.txt");
            Scanner scanner = new Scanner(file);

            int currentYear = Calendar.getInstance().get(Calendar.YEAR);

            // อ่านข้อมูลจากไฟล์
            while (scanner.hasNextLine()) {
                String name = null;
                int birthYear = 0;
                int score = 0;

                // อ่าน 3 บรรทัดที่เป็นชุดข้อมูล
                for (int i = 0; i < 3; i++) {
                    if (scanner.hasNextLine()) {
                        String line = scanner.nextLine().trim();

                        // แยกข้อมูลตามคำสำคัญ
                        if (line.startsWith("Name")) {
                            name = line.split(" : ")[1].trim();
                        } else if (line.startsWith("Chistian Era")) {
                            birthYear = Integer.parseInt(line.split(" : ")[1].trim());
                        } else if (line.startsWith("Software Testing Score")) {
                            score = Integer.parseInt(line.split(" : ")[1].trim());
                        }
                    }
                }

                // ข้ามบรรทัดว่าง
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }

                // คำนวณอายุและแปลงคะแนนเป็นเกรด
                int age = currentYear - birthYear;
                String grade = calculateGrade(score);

                // แสดงผล
                System.out.printf("Name: %s, Age: %d, Software Testing Score: %s%n", name, age, grade);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("ไม่พบไฟล์: " + e.getMessage());
        }
    }

    public static String calculateGrade(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
