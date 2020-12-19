package interfacedefaultmethods.print;

public class Printer {

    public String print(Printable book) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < book.getLength(); i++) {
            if (!book.getColor(i).equals(Printable.BLACK)) {
                sb.append("[").append(book.getColor(i)).append("]");
            }
            sb.append(book.getPage(i)).append("\n");
        }
        return sb.toString();
    }

}
