package course.work.CourseWork2;
import course.work.CourseWork2.models.Question;
import course.work.CourseWork2.services.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private JavaQuestionService javaQuestionService;

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();
    }

    @Test
    void testGetQuestions() {
        List<Question> questions = javaQuestionService.getQuestions();
        assertTrue(questions.isEmpty());
        javaQuestionService.addQuestion("1", "2");
        assertEquals(1, questions.size());
    }

    @Test
    void testAddQuestion() {
        Question newQuestion = javaQuestionService.addQuestion("1", "1");
        List<Question> questions = javaQuestionService.getQuestions();
        assertEquals(1, questions.size());
        assertTrue(questions.contains(newQuestion));
    }

    @Test
    void testRemoveQuestion() {
        javaQuestionService.addQuestion("1", "2");
        Question removedQuestion = javaQuestionService.removeQuestion("1", "2");
        List<Question> questions = javaQuestionService.getQuestions();
        assertEquals(0, questions.size());
        assertEquals("1", removedQuestion.getQuestion());
    }

    @Test
    void testGetRandomQuestion() {
        javaQuestionService.addQuestion("1", "1");
        javaQuestionService.addQuestion("2", "2");
        int randomIndex = javaQuestionService.getRandomQuestion();
        assertTrue(randomIndex >= 0 && randomIndex < 2);
    }

    @Test
    void testGetRandomNumber() {
        int randomNumber = javaQuestionService.getRandomNumber(0, 10);
        assertTrue(randomNumber >= 0 && randomNumber < 10);
    }
}
