package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradeCalculatorTest {
    private final GradeCalculator calculator = new GradeCalculator();

    @Test
    @DisplayName("90 оноо яг A дүн байх ёстой")
    void ninetyIsExactlyA(){
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(90.0);
        assertEquals("A", grade);
    }
}
