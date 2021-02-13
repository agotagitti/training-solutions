package week15d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Quiz {

    private List<QuizData> quizData = new ArrayList<>();

    public void readQuizDataFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line1;
            while ((line1 = br.readLine()) != null) {
                String line2 = br.readLine();
                String[] lineData = line2.split(" ");
                quizData.add(new QuizData(line1, lineData[0], Integer.parseInt(lineData[1]), lineData[2]));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    public List<String> getQuestionsByCategory(String category) {
        List<String> questions = new ArrayList<>();
        for (QuizData actual: quizData) {
            if (actual.getCategory().equals(category)) {
                questions.add(actual.getQuestion());
            }
        }
        return questions;
    }

    public QuizData getRandomQuizData(Random random) {
        return quizData.get(random.nextInt(quizData.size() - 1));
    }

    public Map<String, List<QuizData>> getQuestionsAsKeys() {
        Map<String, List<QuizData>> questions = new HashMap<>();
        for(QuizData actual: quizData) {
            if (!questions.containsKey(actual.getCategory())) {
                questions.put(actual.getCategory(), new ArrayList<>());
            }
            questions.get(actual.getCategory()).add(actual);
        }
        return questions;
    }

    public String getMostPoints() {
        Map<String, List<QuizData>> mapData = getQuestionsAsKeys();
        int mostPoint = 0;
        int entrySum = 0;
        String result = "";
        for (Map.Entry<String, List<QuizData>> actual: mapData.entrySet()) {
            for (QuizData actualQuizData: actual.getValue()) {
                entrySum += actualQuizData.getPoints();
            }
            if (mostPoint == 0 || mostPoint < entrySum) {
                mostPoint = entrySum;
                result = actual.getKey() + " " + mostPoint;
            }
            entrySum = 0;
        }
        return result;
    }



    public List<QuizData> getQuizData() {
        return new ArrayList<>(quizData);
    }


}
