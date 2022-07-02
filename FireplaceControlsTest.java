 

import org.junit.Assert;
import org.junit.Test;

/**
 * @author git-leon
 * @version 1.0.0
 * @date 5/19/21 5:19 PM
 */
public class FireplaceControlsTest {
    /**
     * algorithm for testing implementation of `ControlChecker.getFireplaceControls`
     *
     * @param insideTemperature  temperature of inside climate during this test case
     * @param outsideTemperature temperature of outside climate during this test case
     * @param expected           expected output from this test case
     */

    private void testFireplaceControls(int insideTemperature, int outsideTemperature, String expected) {
        // given
        ControlChecker controlChecker = new ControlChecker();

        // when
        String actual = controlChecker.getFireplaceControls(insideTemperature, outsideTemperature);

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFirePlaceStartFire() {
        for (Integer outsideTemperature : new Integer[]{-10, 20, 40, 49, Integer.MIN_VALUE}) {
            testFireplaceControls(outsideTemperature, outsideTemperature, "start fireplace!");
        }
    }

    @Test
    public void testFirePlaceStopFire() {
        for (Integer insideTemperature : new Integer[]{60, 100, 300, Integer.MAX_VALUE}) {
            testFireplaceControls(insideTemperature, insideTemperature, "stop fireplace!");
        }
    }
}
