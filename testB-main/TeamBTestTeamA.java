import org.junit.Test;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;

public class TeamBTestTeamA {

    // ทดสอบฟังก์ชัน getGrade (private method)
    @Test
    public void testGetGrade() throws Exception {
        // ใช้ Reflection เพื่อเข้าถึงฟังก์ชัน private
        Method getGradeMethod = TeamA.class.getDeclaredMethod("getGrade", int.class);
        getGradeMethod.setAccessible(true); // เปิดการเข้าถึงฟังก์ชัน private

        // ทดสอบค่าที่คืนมาจากฟังก์ชัน
        assertEquals("A", getGradeMethod.invoke(null, 85));  // คะแนน 85 ควรได้ A
        assertEquals("B+", getGradeMethod.invoke(null, 78)); // คะแนน 78 ควรได้ B+
        assertEquals("B", getGradeMethod.invoke(null, 70));  // คะแนน 70 ควรได้ B
        assertEquals("C+", getGradeMethod.invoke(null, 67)); // คะแนน 67 ควรได้ C+
        assertEquals("C", getGradeMethod.invoke(null, 60));  // คะแนน 60 ควรได้ C
        assertEquals("D+", getGradeMethod.invoke(null, 55)); // คะแนน 55 ควรได้ D+
        assertEquals("D", getGradeMethod.invoke(null, 50));  // คะแนน 50 ควรได้ D
        assertEquals("F", getGradeMethod.invoke(null, 45));  // คะแนน 45 ควรได้ F
    }

    // ทดสอบฟังก์ชัน writeToFile (private method)
    @Test
    public void testWriteToFile() throws Exception {
        // ใช้ Reflection เพื่อเข้าถึงฟังก์ชัน private
        Method writeToFileMethod = TeamA.class.getDeclaredMethod("writeToFile", String.class, String.class);
        writeToFileMethod.setAccessible(true); // เปิดการเข้าถึงฟังก์ชัน private

        String testFilePath = "test_output.txt"; // กำหนดเส้นทางไฟล์ชั่วคราวสำหรับทดสอบ
        String content = "This is a test content.";

        // เรียกใช้ฟังก์ชัน writeToFile ผ่าน Reflection
        writeToFileMethod.invoke(null, testFilePath, content);

        // ตรวจสอบว่าไฟล์ถูกสร้างขึ้นและข้อมูลถูกต้อง
        File file = new File(testFilePath);
        assertTrue("File should exist", file.exists()); // ตรวจสอบว่าไฟล์ถูกสร้าง

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String fileContent = reader.readLine();
            assertEquals("Content in file should match", content, fileContent); // ตรวจสอบข้อมูลในไฟล์
        } catch (IOException e) {
            fail("IOException occurred: " + e.getMessage());
        } finally {
            // ลบไฟล์หลังทดสอบเสร็จ
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
