public class QuizMain {
    
    public static void main(String[] args) {
        String[] correctAnswers = {
            "A", "B", "C", "D", "A",
            "B", "C", "D", "A", "B"
        };
        String[] studentAnswers = {
            "A", "B", "A", "D", "B",
            "B", "D", "D", "A", "C"
        };
        
        int score = Quiz.calculateScore(correctAnswers, studentAnswers);
        System.out.println("Total Score: " + score + " out of " + correctAnswers.length);
    }
}
