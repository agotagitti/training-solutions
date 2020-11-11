package typeconversion.whichtype;


import java.util.ArrayList;
import java.util.List;

public class WhichType {

    public List<Type> whichType(String s) {
        List<Type> longEnough = new ArrayList<>();
        long sInLong = Long.parseLong(s);
        for (Type enumList: Type.values()) {
            if ((enumList.getMinValue() <= sInLong) && (sInLong <= enumList.getMaxValue())) {
                longEnough.add(enumList);
            }
        }
        return longEnough;
    }
}
