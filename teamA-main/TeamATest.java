import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDate;

public class TeamATest {

     // Unit test สำหรับฟังก์ชัน calculateAge
     @Test
     public void testCalculateAge() {
         int currentYear = LocalDate.now().getYear();
 
         // ทดสอบกับปีเกิดที่คาดว่าจะได้อายุ 30
         assertEquals(30, TeamA.calculateAge(currentYear - 30));
 
         // ทดสอบกับปีเกิดที่คาดว่าจะได้อายุ 40
         assertEquals(40, TeamA.calculateAge(currentYear - 40));
 
         // ทดสอบกับปีเกิดที่คาดว่าจะได้อายุ 20
         assertEquals(20, TeamA.calculateAge(currentYear - 20));
     }
 
     // Unit test สำหรับฟังก์ชัน calculateGrade
     @Test
     public void testCalculateGrade() {
         // ทดสอบเกรด A
         assertEquals("A", TeamA.calculateGrade(80));
 
         // ทดสอบเกรด B+
         assertEquals("B+", TeamA.calculateGrade(75));
 
         // ทดสอบเกรด B
         assertEquals("B", TeamA.calculateGrade(70));
 
         // ทดสอบเกรด C+
         assertEquals("C+", TeamA.calculateGrade(65));
 
         // ทดสอบเกรด C
         assertEquals("C", TeamA.calculateGrade(60));
 
         // ทดสอบเกรด D+
         assertEquals("D+", TeamA.calculateGrade(55));
 
         // ทดสอบเกรด D
         assertEquals("D", TeamA.calculateGrade(50));
 
         // ทดสอบเกรด F
         assertEquals("F", TeamA.calculateGrade(45));
     }
 }
