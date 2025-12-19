public class Student {
    private String name;
    private double averageGrade;
    private char studyType;
    private char sessionPassed;
    
    //Константы
    public static final double minScholarship = 150;
    public static final double scholarship25 = minScholarship * 1.25;
    public static final double scholarship50 = minScholarship * 1.5;
    
    /**
     * @param name имя студента
     * @param averageGrade средний балл
     * @param studyType тип обучения B - Бюджет, P - Платка
     * @param sessionPassed сессия + сдал, - не сдал
     */
    public Student(String name, double averageGrade, char studyType, char sessionPassed) {
        this.name = name;
        this.averageGrade = averageGrade;
        this.studyType = studyType;
        this.sessionPassed = sessionPassed;
    }
    
    public String getName() {
        return name;
    }
    
    public double getAverageGrade() {
        return averageGrade;
    }
    
    public char getStudyType() {
        return studyType;
    }
    
    public char getSessionPassed() {
        return sessionPassed;
    }
    
    /**
     * Рассчитать стипендию студента
     * @return размер стипендии
     */
    public double calculateScholarship() {
        if (studyType == 'P') {
            return 0;
        }
        
        if (sessionPassed == '-') {
            return 0;
        }
        
        if (averageGrade < 5) {
            return 0;
        } else if (averageGrade >=5 && averageGrade <= 7) {
            return minScholarship;
        } else if (averageGrade >7 && averageGrade <= 8) {
            return scholarship25;
        } else {
            return scholarship50;
        }
    }
    
    @Override
    public String toString() {
        String type = (studyType == 'B') ? "бюджет" : "платное";
        String session = (sessionPassed == '+') ? "сдал" : "не сдал";
        return String.format("%s, балл: %.1f, %s, %s, стипендия: %.1f", 
                           name, averageGrade, type, session, calculateScholarship());
    }
}