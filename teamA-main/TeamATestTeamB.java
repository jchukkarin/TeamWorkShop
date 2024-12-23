import static org.junit.Assert.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import org.junit.Test;

public class TeamATestTeamB {

    @Test
    public void testCalculateAge() {
        int age = TeamB.calculateAge(1995);
        int expectedAge = 2024 - 1995;
        assertEquals("The calculated age is incorrect.", expectedAge, age);
    }

    @Test
    public void testCalculateGrade() {
        String grade = TeamB.calculateGrade(85);
        assertEquals("The grade should be A for score >= 80.", "A", grade);

        grade = TeamB.calculateGrade(72);
        assertEquals("The grade should be B for score >= 70 and < 75.", "B", grade);

        grade = TeamB.calculateGrade(45);
        assertEquals("The grade should be F for score < 50.", "F", grade);
    }

    
}
