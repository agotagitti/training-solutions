package controlselection.month;

public class DayInMonth {

        public int daysInMonth(int year, String month) {
            int numberOfDays = 0;
            switch (month.toLowerCase()) {
                case "január":
                case "március":
                case "május":
                case "július":
                case "augusztus":
                case "október":
                case "december":
                    numberOfDays = 31;
                    break;
                case "április":
                case "június":
                case "szeptember":
                case "november":
                    numberOfDays = 30;
                    break;
                case "február":
                    if ((year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0)) {
                        numberOfDays = 29;
                    } else {
                        numberOfDays = 28;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid month: " + month);
            }
            return numberOfDays;
        }
}
