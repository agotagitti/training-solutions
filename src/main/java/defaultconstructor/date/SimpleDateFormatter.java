package defaultconstructor.date;

public class SimpleDateFormatter {

    private CountryCode defaultCode;

    public SimpleDateFormatter() {
        this.defaultCode = CountryCode.HU;
    }

    public String formatDateString(SimpleDate simpleDate) {
        return formatDateStringByCountryCode(defaultCode, simpleDate);
    }

    public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate simpleDate) {
        String formatted = "";
        if (countryCode == CountryCode.HU) {
            formatted = simpleDate.getYear() + "-" + simpleDate.getMonth() + "-" + simpleDate.getDay();
        } else if (countryCode == CountryCode.EN) {
            formatted = simpleDate.getDay() + "-" + simpleDate.getMonth() + "-" + simpleDate.getYear();
        } else {
            formatted = simpleDate.getMonth() + "-" + simpleDate.getDay() + "-" + simpleDate.getYear();
        }
        return  formatted;
    }

}
