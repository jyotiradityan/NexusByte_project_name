import java.util.ArrayList;
import java.util.List;

public class Exam {
    private String title;
    private List<Question> questions;

    public Exam(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }
}