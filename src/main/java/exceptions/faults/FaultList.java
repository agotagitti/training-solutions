package exceptions.faults;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FaultList {

    public List<String> processLines(List <String> lines) {
        if (lines == null) {
            throw new IllegalArgumentException("Null argument");
        }
        List<String> errorReport = new ArrayList<>();
        for (String actual: lines) {
            String value = lineResult(actual);
            if (!(value.equals("NO_ERROR") || value.equals("COMMENT"))) {
                errorReport.add(value);
            }
        }
        return errorReport;
    }

    private String lineResult(String line) {
        String[] lineElements = line.split(",");
        String errorCode = "NO_ERROR";
        if (lineElements.length != 3) {
            return lineElements[0] + "," + ProcessingResult.WORD_COUNT_ERROR.getCode();
        }

        try {
            Integer.parseInt(lineElements[0]);
        }
        catch (NumberFormatException nfe) {
            return "COMMENT";
        }

        try {
            Double.parseDouble(lineElements[1]);
        }
        catch (NumberFormatException nfe) {
            errorCode = lineElements[0] + "," + ProcessingResult.VALUE_ERROR.getCode();
        }

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.");
            dateFormat.parse(lineElements[2]);
        }
        catch (ParseException pe) {
            if (errorCode.equals("NO_ERROR")) {
                errorCode = lineElements[0] + "," + ProcessingResult.DATE_ERROR.getCode();
            } else {
                errorCode = lineElements[0] + "," + ProcessingResult.VALUE_AND_DATE_ERROR.getCode();
            }
        }

        return errorCode;
    }


}
