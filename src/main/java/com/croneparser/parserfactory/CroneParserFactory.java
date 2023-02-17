package main.java.com.croneparser.parserfactory;

import main.java.com.croneparser.cronconstant.CronParserEnum;
import main.java.com.croneparser.exceptions.IncorrectFormatCommandException;
import main.java.com.croneparser.exceptions.NoSuitableParserException;
import main.java.com.croneparser.parserfactory.parserconcrete.*;
import main.java.com.croneparser.parserinterface.ParserInterface;
import main.java.com.croneparser.parserutil.ValidationUtil;

/**
 * @Author:Subodh Kumar
 * @Version:1.0
 *
 * @Description: CroneParserFactory will provide the Instance of ConcreteParser
 *
 */
public class CroneParserFactory {
    //Will store the parser command
    public static ParserInterface getInstance(CronParserEnum cronParserEnum,
                                              final String expr) throws NoSuitableParserException {
        //Instance for concrete parser
        ParserInterface parserInterface=null;

        //Special char to check with the parsing logic
        switch (cronParserEnum){
            case MINUTE:
                parserInterface=new MinuteParser(expr);
                break;
            case HOUR:
                parserInterface=new HourParser(expr);
                break;
            case DAY_OF_MONTH:
                parserInterface=new DayOfMonthParser(expr);
                break;
            case MONTH:
                parserInterface=new MonthParser(expr);
                break;
            case DAY_OF_WEEK:
                parserInterface=new DayOfWeekParser(expr);
                break;
            case COMMAND:
                parserInterface=new CommandParser(expr);
                break;
            default:
                throw new NoSuitableParserException("Invalid command");
        }
        return parserInterface;
    }
}
