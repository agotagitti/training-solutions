package week03d4;

import week03d4.Phone;

public class PhoneParser {

    public Phone parsePhone(String s) {
        //30-1234567
        String prefix = s.substring(0, 2);
        String number = s.substring(3);
        Phone phone = new Phone(prefix, number);

        return phone;
    }

//    public static void main(String[] args) {
//
//        PhoneParser phoneParser = new PhoneParser();
//
//        Phone phone = phoneParser.parsePhone("12-1234567");
//
//        System.out.println(phone.getPrefix());
//        System.out.println(phone.getNumber());
//        System.out.println(phone);
//    }
}
