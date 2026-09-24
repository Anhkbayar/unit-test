package mn.edu.must.sqat;

public class GradeCalculator {
    private static final double A_MIN = 90;
    private static final double B_MIN = 80;
    private static final double C_MIN = 70;
    private static final double D_MIN = 60;

    public String letterGrade(double score){
        if(Double.isNaN(score) || Double.isInfinite(score) || score < 0 || score > 100){
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
        return switch((int)score / 10){
            case 10,9 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            case 6 -> "D";
            default -> "F";
        };
    }

    public double totalScore(Grade grade){
        return grade.total();
    }
}
