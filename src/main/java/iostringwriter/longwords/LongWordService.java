package iostringwriter.longwords;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class LongWordService {

    public void writeWords(Writer writer, List<String> words) {
        PrintWriter pw = new PrintWriter(writer);
        for (String actual: words) {
            pw.print(actual);
            pw.print(", ");
            pw.println(actual.length());
        }
    }

    public String writeWithStringWriter(List<String> words) {
        StringWriter sw = new StringWriter();
        try (sw) {
            writeWords(sw, words);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write");
        }
        return sw.toString();
    }
}
