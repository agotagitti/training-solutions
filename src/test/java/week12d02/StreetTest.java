package week12d02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StreetTest {

    @Test
    void sellSite() {
        Street street = new Street();
        assertEquals(2, street.sellSite(new Site(0, 10, Fence.NO_FENCE)));
        assertEquals(1, street.sellSite(new Site(1, 10, Fence.PERFECT)));
        assertEquals(4, street.sellSite(new Site(0, 10, Fence.NEED_UPGRADE)));
        assertEquals(3, street.sellSite(new Site(1, 10, Fence.NO_FENCE)));
        assertEquals(6, street.sellSite(new Site(0, 10, Fence.PERFECT)));

    }

    @Test
    void soldSiteFence() {
        Street street = new Street();
        street.sellSite(new Site(0, 10, Fence.NO_FENCE));
        street.sellSite(new Site(1, 10, Fence.PERFECT));
        street.sellSite(new Site(0, 10, Fence.NEED_UPGRADE));
        street.sellSite(new Site(1, 10, Fence.NO_FENCE));
        street.sellSite(new Site(0, 10, Fence.PERFECT));

        assertEquals("[2, 1, 2]", Arrays.toString(street.soldSiteFence()));

    }
}