package main.java.com.croneparser.parserinterface;

import main.java.com.croneparser.exceptions.IncorrectFormatCommandException;
import main.java.com.croneparser.exceptions.InvalidCronExpression;
import main.java.com.croneparser.exceptions.NoSuitableParserException;

/**
 * @Author: Subodh Kumar
 * @Version: 1.0
 *
 * @Description:  This interface will provide method for crone parsing
 */
public interface ParserInterface {
    //Parse cron string to get all the extracted data
    public void parseCroneString() throws IncorrectFormatCommandException, NoSuitableParserException, InvalidCronExpression;

    //Print Extracted Data
    public void printCron();
}
