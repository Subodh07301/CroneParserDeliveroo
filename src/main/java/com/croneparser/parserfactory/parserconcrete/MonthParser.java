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
 * @Description: This file will parse the Month field from cron Expression
 */
public class MonthParser implements ParserInterface {
    private String desciption=null;

    private String expr=null;

    public MonthParser(final String expr){
        this.expr=expr;
    }

    @Override
    public void parseCroneString() throws NoSuitableParserException, InvalidCronExpression {
        desciption= ParsingUtil.parseCron(new StringBuilder(expr), CronParserEnum.MONTH);
    }

    @Override
    public void printCron() {
        System.out.println(desciption);
    }

    public String getDescription() {
        return desciption;
    }
}
