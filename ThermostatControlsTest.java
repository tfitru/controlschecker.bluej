 

import org.junit.Assert;
import org.junit.Test;

/**
 * @author git-leon
 * @version 1.0.0
 * @date 5/19/21 5:22 PM
 */
public class ThermostatControlsTest {

    /**
     * algorithm for testing implementation of `ControlChecker.getThermostatControls`
     *
     * @param insideTemperature temperature of inside climate during this test case
     * @param expected          expected output from this test case
     */
    private void testThermostatControls(Integer insideTemperature, String expected) {
        // given
        ControlChecker controlChecker = new ControlChecker();

        // when
        String actual = controlChecker.getThermostatControls(insideTemperature);

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testThermostatControlsLessHeat() {
        for (Integer insideTemperature : new Integer[]{71, 90, 5000, Integer.MAX_VALUE}) {
            testThermostatControls(insideTemperature, "less heat!");
        }
    }

    @Test
    public void testThermostatControlsMoreHeat() {
        for (Integer insideTemperature : new Integer[]{69, 50, -5000, Integer.MIN_VALUE}) {
            testThermostatControls(insideTemperature, "more heat!");
        }
    }
}
