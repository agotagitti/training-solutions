package exceptionmulticatch.converter;

public class AnswerStat {

    private BinaryStringConverter converter;

    public AnswerStat(BinaryStringConverter converter) {
        this.converter = converter;
    }

    public boolean[] convert (String string) {
        try {
            return converter.binaryStringToBooleanArray(string);
        }
        catch (NullPointerException | IllegalArgumentException ex) {
            throw new InvalidBinaryStringException(ex.getMessage(), ex);
        }
    }

    public int answerTruePercent(String answers) {
        boolean[] poll = converter.binaryStringToBooleanArray(answers);
        int countTrue = 0;
        for (boolean actual: poll) {
            if (actual) {
                countTrue++;
            }
        }
        return countTrue * 100 / poll.length;
    }

}
