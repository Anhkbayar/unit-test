package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradeCalculatorTest {
    private final GradeCalculator calculator = new GradeCalculator();

    @Test
    @DisplayName("90 оноо яг A дүн байх ёстой")
    void ninetyIsExactlyA(){
        String grade = calculator.letterGrade(90.0);
        assertEquals("A", grade);
    }

    @ParameterizedTest
    @CsvFileSource(
            resources = "/grades.csv",
            numLinesToSkip = 1
    )
    @DisplayName("Оноо зөв үсгэн дүн рүү хөрвөх ёстой")
    void gradeTest(double score, String expected){
        assertEquals(expected, calculator.letterGrade(score));
    }

}
