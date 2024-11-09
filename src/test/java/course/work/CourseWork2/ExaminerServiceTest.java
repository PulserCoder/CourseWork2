package course.work.CourseWork2;

import course.work.CourseWork2.exceptions.RequireMoreThanHave;
import course.work.CourseWork2.interfaces.ExaminerService;
import course.work.CourseWork2.interfaces.QuestionService;
import course.work.CourseWork2.models.Question;
import course.work.CourseWork2.services.ExaminerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ExaminerServiceTest {


    @Mock
    QuestionService questionService;
    @InjectMocks
    ExaminerServiceImpl examinerService;
    List<Question> questions;

    @BeforeEach
    public void setUp() {
        questions = new ArrayList<>();
        questions.add(new Question("1", "1"));
        questions.add(new Question("2", "2"));
        questions.add(new Question("3", "3"));
        when(questionService.getQuestions()).thenReturn(questions);
        when(questionService.getRandomQuestion()).thenReturn(0, 1, 2);
    }

    @Test
    public void getQuestionsException() {
        assertThrows(RequireMoreThanHave.class, () -> examinerService.getQuestions(15));
    }

    @Test
    void testGetQuestions() {
        List<Question> result = examinerService.getQuestions(2);
        assertEquals(2, result.size());
        assertTrue(result.contains(questions.get(0)));
        assertTrue(result.contains(questions.get(1)));
    }
}
