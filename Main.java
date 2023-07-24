import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create an exam
        Exam exam = createExam();

        // Take the exam
        takeExam(exam);
    }

    private static Exam createExam() {
        Exam exam = new Exam("Java Programming Exam");

        // Sample questions and options
        String[] options1 = {"A. Java", "B. Python", "C. C++", "D. JavaScript"};
        String[] options2 = {"A. True", "B. False"};
        String[] options3 = {"A. Class", "B. Object", "C. Method", "D. Variable"};

        Question question1 = new Question("Which programming language is used for Android development?", options1, 0);
        Question question2 = new Question("Java is an interpreted language. (True/False)", options2, 1);
        Question question3 = new Question("In object-oriented programming, an instance of a class is called a/an:", options3, 1);

        exam.addQuestion(question1);
        exam.addQuestion(question2);
        exam.addQuestion(question3);

        return exam;
    }

    private static void takeExam(Exam exam) {
        Scanner scanner = new Scanner(System.in);
        int totalQuestions = exam.getQuestions().size();
        int score = 0;

        System.out.println("Welcome to the " + exam.getTitle());
        System.out.println("You have " + totalQuestions + " questions. Good luck!\n");

        for (int i = 0; i < totalQuestions; i++) {
            Question question = exam.getQuestions().get(i);

            System.out.println("Q" + (i + 1) + ". " + question.getQuestionText());
            String[] options = question.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println(options[j]);
            }

            System.out.print("Your answer (A/B/C/D): ");
            String userAnswer = scanner.nextLine().toUpperCase();

            int correctOptionIndex = question.getCorrectOptionIndex();
            if (userAnswer.equals(Character.toString((char) ('A' + correctOptionIndex)))) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + options[correctOptionIndex] + "\n");
            }
        }

        System.out.println("Your score: " + score + "/" + totalQuestions);
        scanner.close();
    }
}