 

import org.junit.Assert;
import org.junit.Test;

/**
 * @author git-leon
 * @version 1.0.0
 * @date 5/19/21 5:21 PM
 */
public class FuelControlsTest {

    /**
     * algorithm for testing implementation of `ControlChecker.getFuelControls`
     *
     * @param fuelLevel fuel level during this test case
     * @param expected  expected output from this test case
     */
    private void testFuelControls(Double fuelLevel, String expected) {
        // given
        ControlChecker controlChecker = new ControlChecker();

        // when
        String actual = controlChecker.getFuelControls(fuelLevel);

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFuelControlsBurnFuel() {
        for (Double fuelLevel : new Double[]{0.79, 0.5, 0.1, Double.MAX_VALUE}) {
            testFuelControls(fuelLevel, "burn fuel");
        }
    }

    @Test
    public void testFuelControlsRefuel() {
        for (Double fuelLevel : new Double[]{0.079, 0.05, 0.001, Double.MIN_VALUE}) {
            testFuelControls(fuelLevel, "refuel");
        }
    }

}
