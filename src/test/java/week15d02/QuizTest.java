package week15d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {

    Quiz quiz = new Quiz();

    @BeforeEach
    void setUp() {
        Path path = Path.of("src/main/resources/kerdesek.txt");
        quiz.readQuizDataFromFile(path);
    }

    @Test
    void readQuizDataFromFile() {
        assertEquals(57, quiz.getQuizData().size());
        assertEquals("12", quiz.getQuizData().get(56).getAnswer());
    }

    @Test
    void getQuestionsByCategory() {
        List<String> questions = quiz.getQuestionsByCategory("tortenelem");
        assertEquals(15, questions.size());
    }

    @Test
    void getQuestionsAsKeys() {
        Map<String, List<QuizData>> questionsAsKeys = quiz.getQuestionsAsKeys();
        assertEquals(5, questionsAsKeys.size());
        assertTrue(questionsAsKeys.containsKey("tortenelem"));
    }

    @Test
    void getMostPoints() {
        assertEquals("matematika 43", quiz.getMostPoints());
    }

}