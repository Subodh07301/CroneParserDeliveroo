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
 * @Description: This file will parse the Hour field from cron Expression
 */
public class HourParser implements ParserInterface {
    private String description=null;

    private String expr=null;

    public HourParser(final String expr){
        this.expr=expr;
    }
    @Override
    public void parseCroneString() throws NoSuitableParserException, InvalidCronExpression {
        description= ParsingUtil.parseCron(new StringBuilder(expr), CronParserEnum.HOUR);
    }

    @Override
    public void printCron() {
        System.out.println(description);
    }

    public String getDescription() {
        return description;
    }
}
