package isahasa.htmlmarchaller.isa;

import isahasa.htmlmarchaller.HtmlText;

public class UnderlinedAndItalicAndBoldHtmlText extends HtmlText {

    public UnderlinedAndItalicAndBoldHtmlText(String underlinedAndItalicAndBoldText) {
        super(underlinedAndItalicAndBoldText);
    }

    @Override
    public String getPlainText() {
        return "<u><i><b>" + super.getPlainText() + "</b></i></u>";
    }
}
