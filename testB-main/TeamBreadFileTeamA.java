import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TeamBreadFileTeamA {
    public static void main(String[] args) {
        String filePath = "C:/Output/Textfile.txt";

        try {
            // อ่านข้อมูลจากไฟล์
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            // ดึงข้อมูลแต่ละบรรทัด
            String name = scanner.nextLine().split(": ")[1];
            int age = Integer.parseInt(scanner.nextLine().split(": ")[1]);
            String grade = scanner.nextLine().split(": ")[1];

            // แปลงอายุเป็นปีพุทธศักราช
            int buddhistEra = 2024 + 543 - age;

            // แปลงเกรดเป็นอันดับ
            String rank = getRank(grade);

            // แสดงผลลัพธ์บน CMD
            System.out.println("Name : " + name);
            System.out.println("Buddhist Era : " + buddhistEra);
            System.out.println("Software Testing Rank : " + rank);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            e.printStackTrace();
        }
    }

    // ฟังก์ชันแปลงเกรดเป็นอันดับ
    private static String getRank(String grade) {
        switch (grade) {
            case "A": return "High Distinction";
            case "B+": return "Distinction";
            case "B": return "Good";
            case "C+": return "Normal";
            case "C": return "Good";
            case "D+": return "Normal";
            case "D": return "Normal";
            default: return "Failed";
        }
    }
}
