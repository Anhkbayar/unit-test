package mn.edu.must.sqat;

public record Grade(
        double att,
        double lab,
        double quiz1,
        double quiz2,
        double exam
) {
    public Grade{
        validate("Attendance", att, 10);
        validate("Lab", lab, 40);
        validate("Quiz 1", quiz1, 10);
        validate("Quiz 2", quiz2, 10);
        validate("Exam", exam, 30);
    }

    public double total(){
        return att+lab+quiz1+quiz2+exam;
    }

    private static void validate(String name, double score, double max){
        if(Double.isNaN(score) || Double.isInfinite(score)){
            throw new IllegalArgumentException(name+ "must be a valid number");
        }

        if(score < 0 || score> max){
            throw new IllegalArgumentException(name + "must be between and "+max);
        }
    }
}
