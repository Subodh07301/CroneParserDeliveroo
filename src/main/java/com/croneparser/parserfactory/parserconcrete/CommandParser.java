package main.java.com.croneparser.parserfactory.parserconcrete;

import main.java.com.croneparser.cronconstant.CronConstant;
import main.java.com.croneparser.cronconstant.CronParserEnum;
import main.java.com.croneparser.exceptions.IncorrectFormatCommandException;
import main.java.com.croneparser.parserinterface.ParserInterface;
import main.java.com.croneparser.parserutil.ValidationUtil;

/**
 * @Author: Subodh Kumar
 * @Version: 1.0
 *
 * @Description: This file will parse the command field from cron Expression
 */
public class CommandParser implements ParserInterface {
    private String expr=null;

    public CommandParser(final String expr){
        this.expr=expr;
    }

    @Override
    public void parseCroneString() throws IncorrectFormatCommandException {
        if(!ValidationUtil.validateExpression(expr)){
            throw new IncorrectFormatCommandException("The command is not correctly formed");
        }
    }

    public String getCommand() {
        return expr;
    }

    @Override
    public void printCron() {
        System.out.print(CronParserEnum.COMMAND.toString()+":");
        for(int i=0;i< CronConstant.LINE_SPACING-CronParserEnum.COMMAND.toString().length();i++){
            System.out.print(" ");
        }
        System.out.print("\t"+expr);
    }
}
