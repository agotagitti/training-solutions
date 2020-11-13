package controliteration.pi;

public class PiGenerator {

    private static final String POEM = "Nem a régi s durva közelítés, Mi szótól szóig így kijön " +
            "Betűiket számlálva. Ludolph eredménye már, Ha itt végezzük húsz jegyen. " +
            "De rendre kijő még tíz pontosan, Azt is bízvást ígérhetem.";

    private static final String LETTERS ="aábcdeéfghiíjklmnoóöőpqrstuúüűvwxyz";

    public String getPi() {
        int counter = 0;
        String pi = "";
        for (int i = 0; i < POEM.length(); i++) {
            if (LETTERS.contains(Character.toString(POEM.charAt(i)).toLowerCase())) {
                counter++;
            } else if (counter != 0) {
                pi = pi.concat(Integer.toString(counter));
                counter = 0;
            }
            if (pi.length() == 1) {
                pi = pi.concat(".");
            }
        }
        return pi;
    }
}
