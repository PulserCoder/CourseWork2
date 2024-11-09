package course.work.CourseWork2.interfaces;

import course.work.CourseWork2.models.Question;

import java.util.List;

public interface ExaminerService {
    List<Question> getQuestions(int amount);
}
