package enumtype.unit;

import java.math.BigDecimal;

public class UnitConverterMain {

    public static void main(String[] args) {
        UnitConverter unitConverter = new UnitConverter();

        System.out.println(unitConverter.convert(BigDecimal.valueOf(12345.6), LengthUnit.CENTIMETER, LengthUnit.FOOT ));

        System.out.println(LengthUnit.siUnits());

    }
}
