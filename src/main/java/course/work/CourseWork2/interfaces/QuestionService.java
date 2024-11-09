package course.work.CourseWork2.interfaces;

import course.work.CourseWork2.models.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestions();
    Question addQuestion(String question, String answer);
    Question removeQuestion(String question, String answer);
    int getRandomQuestion();
}
