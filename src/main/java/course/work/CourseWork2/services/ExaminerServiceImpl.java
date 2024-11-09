package course.work.CourseWork2.services;

import course.work.CourseWork2.exceptions.RequireMoreThanHave;
import course.work.CourseWork2.interfaces.ExaminerService;
import course.work.CourseWork2.interfaces.QuestionService;
import course.work.CourseWork2.models.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;
    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestions(int amount) {
        List<Question> questions = questionService.getQuestions();
        if (amount <= 0 || amount > questions.size() - 1) {
            throw new RequireMoreThanHave("Такого количества нету");
        }
        List<Question> result = new ArrayList<>();
        while (result.size() < amount) {
            int randomIndex = questionService.getRandomQuestion();
            if (!result.contains(questions.get(randomIndex))) {
                result.add(questions.get(randomIndex));
            }
        }
        return result;
    }


}
