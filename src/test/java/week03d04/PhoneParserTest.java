package week03d04;

import org.junit.jupiter.api.Test;
import week03d4.Phone;
import week03d4.PhoneParser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneParserTest {

    @Test
    void testParsePhone() {
        //Given
        PhoneParser phoneParser = new PhoneParser();
        //When
        Phone phone = phoneParser.parsePhone("12-1234567");
        //Then
        assertEquals("12", phone.getPrefix());
        assertEquals("1234567", phone.getNumber());
        assertEquals("12-1234567", phone.toString());

    }
}
