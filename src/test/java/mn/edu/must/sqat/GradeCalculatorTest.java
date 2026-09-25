package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class GradeCalculatorTest {
    private final GradeCalculator calculator = new GradeCalculator();

    @Test
    @DisplayName("90 оноо яг A дүн байх ёстой")
    void ninetyIsExactlyA(){
        String grade = calculator.letterGrade(90.0);
        assertEquals("A", grade);
    }

    @Test
    @DisplayName("Дүн хасах утгатай байхад алдаа өгөх")
    void negativeScore(){
        assertThrows(IllegalArgumentException.class,
                ()-> calculator.letterGrade(-15.0));
    }

    @Test
    @DisplayName("Дүн хязгааргй утгатай байхад алдаа өгөх")
    void infiniteScore(){
        assertThrows(IllegalArgumentException.class,
                ()-> calculator.letterGrade(Double.POSITIVE_INFINITY)
        );
    }

    @Test
    @DisplayName("Дүн 100-аас их байхад алдаа өгөх")
    void aboveHundredScore(){
        assertThrows(IllegalArgumentException.class,
                ()-> calculator.letterGrade(102.52)
        );
    }

    @Test
    @DisplayName("Нийт дүн бодох")
    void totalScore(){
        Grade grade = new Grade(8,35, 10,9, 25);
        Double total = calculator.totalScore(grade);
        assertEquals(87, total);
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

    @ParameterizedTest
    @CsvFileSource(
        resources = "/total_score.csv",
            numLinesToSkip = 1
    )
    @DisplayName("Нийт дүн зөв бодогдох ёстой")
    void totalScore(
            double att,
            double lab,
            double quiz1,
            double quiz2,
            double exam,
            double expectedTotal
    ){
        Grade grade = new Grade(att, lab, quiz1, quiz2, exam);
        double total = calculator.totalScore(grade);
        assertEquals(expectedTotal, total);
    }

    @ParameterizedTest
    @CsvFileSource(
            resources = "/grade_validate.csv",
            numLinesToSkip = 1
    )
    void validateGrade(
            double att, double lab, double quiz1, double quiz2, double exam, String expected
    ){
        if (expected.equals("VALID")) {
            assertDoesNotThrow(() -> new Grade(att, lab, quiz1, quiz2, exam) );
        } else { assertThrows(
                IllegalArgumentException.class, () -> new Grade(att, lab, quiz1, quiz2, exam)
        ); }
    }

}
