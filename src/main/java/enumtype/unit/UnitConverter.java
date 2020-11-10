package enumtype.unit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UnitConverter {

    public BigDecimal convert(BigDecimal length, LengthUnit source, LengthUnit target) {
        double bigDecimal = length.doubleValue();
        bigDecimal *= source.getUnitInMM();
        bigDecimal /= target.getUnitInMM();
        bigDecimal = Math.round(bigDecimal * Math.pow(10, 4)) / Math.pow(10, 4);
        return BigDecimal.valueOf(bigDecimal);
    }
}
