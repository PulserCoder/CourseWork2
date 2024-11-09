package course.work.CourseWork2.services;

import course.work.CourseWork2.interfaces.QuestionService;
import course.work.CourseWork2.models.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class JavaQuestionService implements QuestionService {
    private final List<Question> questions = new ArrayList<>();

    @Override
    public List<Question> getQuestions() {
        return questions;
    }

    @Override
    public Question addQuestion(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        if (!questions.contains(newQuestion)) {
            questions.add(new Question(question, answer));
        }
        return newQuestion;
    }

    @Override
    public Question removeQuestion(String question, String answer) {
        Question back = new Question(question, answer);
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).equals(back)) {
                questions.remove(i);
                break;
            }
        }
        return back;
    }

    @Override
    public int getRandomQuestion() {
        return getRandomNumber(0, questions.size() - 1);
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
