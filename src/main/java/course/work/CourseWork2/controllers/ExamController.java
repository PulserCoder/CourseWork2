package course.work.CourseWork2.controllers;

import course.work.CourseWork2.interfaces.ExaminerService;
import course.work.CourseWork2.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam/get")
public class ExamController {
    private final ExaminerService examinerService;

    @Autowired
    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("{amount}")
    public List<Question> getQuestions(@PathVariable() int amount){
        return examinerService.getQuestions(amount);
    }


}
