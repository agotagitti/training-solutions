package isahasa.htmlmarchaller.isa;

import isahasa.htmlmarchaller.HtmlText;

public class BoldHtmlText extends HtmlText {

    public BoldHtmlText(String boldText) {
        super(boldText);
    }

    @Override
    public String getPlainText() {
        return "<b>" + super.getPlainText() + "</b>";
    }
}
