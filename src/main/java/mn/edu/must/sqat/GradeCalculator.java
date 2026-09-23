package mn.edu.must.sqat;

public record Grades(
    double att,
    double lab,
    double quiz1,
    double quiz2,
    double exam
) {}

public class GradeCalculator {

    public String letterGrade(double score) {
        return score;
    }

    public double totalScore(Grades grades) {
        return (
            grades.att() +
            grades.lab() +
            grades.quiz1() +
            grades.quiz2() +
            grades.exam()
        );
    }
}
