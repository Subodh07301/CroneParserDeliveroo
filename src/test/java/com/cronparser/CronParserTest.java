package test.java.com.cronparser;

import main.java.com.croneparser.parserfactory.parserconcrete.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Subodh Kumar
 * @Version:1.0
 *
 * @Descrition: This test file will test each of the cron parsing field
 */
public class CronParserTest {
    @Test
    public void testCommandInCronExpression() throws Exception {
        CommandParser cmp=new CommandParser("abc/com");
        cmp.parseCroneString();
        Assert.assertEquals("abc/com", cmp.getCommand());
    }

    @Test
    public void testMinuteInCronExpression() throws Exception {
        MinuteParser minuteParser=new MinuteParser("*/15");
        minuteParser.parseCroneString();
        Assert.assertEquals("Minute:         \t0\t15\t30\t45", minuteParser.getDescription());
    }

    @Test
    public void testHourInCronExpression() throws Exception {
        HourParser hourParser=new HourParser("1-4");
        hourParser.parseCroneString();
        Assert.assertEquals("Hour:           \t1\t2\t3\t4", hourParser.getDescription());
    }

    @Test
    public void testMonthInCronExpression() throws Exception {
        MonthParser monthParser=new MonthParser("1,4-6");
        monthParser.parseCroneString();
        Assert.assertEquals("Month:          \t1\t4\t5\t6", monthParser.getDescription());
    }

    @Test
    public void testDayOfWeekInCronExpression() throws Exception {
        DayOfWeekParser dayOfWeekParser=new DayOfWeekParser("1,4,6*");
        dayOfWeekParser.parseCroneString();
        Assert.assertEquals("Day Of Week:    \t1\t4\t6\t7", dayOfWeekParser.getDescription());
    }

    @Test
    public void testDayOfMonthInCronExpression() throws Exception {
        DayOfMonthParser dayOfMonthParser=new DayOfMonthParser("1,4*");
        dayOfMonthParser.parseCroneString();
        Assert.assertEquals("Day Of Month:   \t1\t4\t5\t6\t7\t8\t9\t10\t11\t12\t13\t14\t15\n" +
                "\t               \t16\t17\t18\t19\t20\t21\t22\t23\t24\t25\t26\t27\t28\n" +
                "\t               \t29\t30\t31", dayOfMonthParser.getDescription());
    }
}
