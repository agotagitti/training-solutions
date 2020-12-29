package isahasa.htmlmarchaller.isa;

import isahasa.htmlmarchaller.HtmlText;

public class UnderlinedHtmlText extends HtmlText {

    public UnderlinedHtmlText(String underlinedText) {
        super(underlinedText);
    }

    @Override
    public String getPlainText() {
        return "<u>" + super.getPlainText() + "</u>";
    }

}
