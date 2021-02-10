package week15d02;

public class QuizData {

    private String question;
    private String answer;
    private int points;
    private String category;

    public QuizData(String question, String answer, int points, String category) {
        this.question = question;
        this.answer = answer;
        this.points = points;
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getPoints() {
        return points;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "QuizData{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", points=" + points +
                ", category='" + category + '\'' +
                '}';
    }
}
