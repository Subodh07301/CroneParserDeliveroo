package main.java.com.croneparser.parserfactory.parserconcrete;

import main.java.com.croneparser.cronconstant.CronParserEnum;
import main.java.com.croneparser.exceptions.InvalidCronExpression;
import main.java.com.croneparser.exceptions.NoSuitableParserException;
import main.java.com.croneparser.parserinterface.ParserInterface;
import main.java.com.croneparser.parserutil.ParsingUtil;

/**
 * @Author: Subodh Kumar
 * @Version: 1.0
 *
 * @Description: This file will parse the Day Of Month field from cron Expression
 */
public class DayOfMonthParser implements ParserInterface {
    private String description=null;

    private String expr=null;

    public DayOfMonthParser(final String expr){
        this.expr=expr;
    }

    @Override
    public void parseCroneString() throws
            NoSuitableParserException, InvalidCronExpression {
        //TO DO for validation
        description= ParsingUtil.parseCron(new StringBuilder(expr), CronParserEnum.DAY_OF_MONTH);
    }

    public String getDescription(){
        return description;
    }

    @Override
    public void printCron() {
        System.out.println(description);
    }

}
