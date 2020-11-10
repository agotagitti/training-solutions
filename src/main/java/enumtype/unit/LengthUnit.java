package enumtype.unit;

import java.util.ArrayList;
import java.util.List;

public enum LengthUnit {

    MILLIMETER(true, 1),
    CENTIMETER(true, 10),
    METER(true, 1000),
    YARD(false, 914.4),
    FOOT(false, 304.8),
    INCH(false, 25.4);

    private final boolean isSIUnit;
    private final double unitInMM;

    LengthUnit(boolean isSIUnit, double unitInMM) {
        this.isSIUnit = isSIUnit;
        this.unitInMM = unitInMM;
    }

    public boolean isSIUnit() {
        return isSIUnit;
    }

    public double getUnitInMM() {
        return unitInMM;
    }

    public static List<LengthUnit> siUnits() {
        List<LengthUnit> siUnits = new ArrayList<>();
        for (LengthUnit unit: LengthUnit.values()) {
            if (unit.isSIUnit()) {
                siUnits.add(unit);
            }
        }
        return siUnits;
    }
}
