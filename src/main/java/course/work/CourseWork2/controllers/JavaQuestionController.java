package course.work.CourseWork2.controllers;

import course.work.CourseWork2.interfaces.QuestionService;
import course.work.CourseWork2.models.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("add")
    public Question add(@RequestParam("question") String question,
                        @RequestParam("answer") String answer) {
        return questionService.addQuestion(question, answer);
    }

    @GetMapping("remove")
    public Question remove(@RequestParam("question") String question,
                           @RequestParam("answer") String answer) {
        return questionService.removeQuestion(question, answer);
    }

    @GetMapping("")
    public List<Question> getQuestions() {
        return questionService.getQuestions();
    }
}
