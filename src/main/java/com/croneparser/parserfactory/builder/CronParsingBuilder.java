package main.java.com.croneparser.parserfactory.builder;

import main.java.com.croneparser.cronconstant.CronParserEnum;
import main.java.com.croneparser.exceptions.IncorrectFormatCommandException;
import main.java.com.croneparser.exceptions.InvalidCronExpression;
import main.java.com.croneparser.exceptions.NoSuitableParserException;
import main.java.com.croneparser.parserfactory.CroneParserFactory;
import main.java.com.croneparser.parserinterface.ParserInterface;
import main.java.com.croneparser.parserutil.ValidationUtil;

/**
 * @Author:Subodh Kumar
 * @Version:1.0
 *
 * @Description: This is Cron Parser builder class which will contain the logic for fetching
 * and parsing the different field of expression and segregate the result as part of cronParser
 */
public class CronParsingBuilder {
    //Declare the cron Command
    private static String cronCommand[]=null;

    //Declare the parser array
    private static ParserInterface[] parserInterfaces =null;

    /*
    Fetch all the related parser for all the cron expression field
     */
    private static void fetchParser() throws NoSuitableParserException, IncorrectFormatCommandException {
        if(!ValidationUtil.validateCron(cronCommand)){
            throw new IncorrectFormatCommandException("The cron command is not formatted correctly");
        }

        int cron_parser_index=0;
        for(CronParserEnum cronParserEnum:CronParserEnum.values()){
            parserInterfaces[cron_parser_index]= CroneParserFactory.getInstance(cronParserEnum,cronCommand[cron_parser_index]);
            cron_parser_index++;
        }
    }

    /*
     Parse all cron expression with different parser
     */
    private static void cronParser() throws NoSuitableParserException, IncorrectFormatCommandException, InvalidCronExpression {
        if(!ValidationUtil.validateParser(parserInterfaces)){
            throw new NoSuitableParserException("Suitable parser error");
        }

        for(int cron_parser_index=0;cron_parser_index<parserInterfaces.length;cron_parser_index++){
            parserInterfaces[cron_parser_index].parseCroneString();
        }
    }

    /*
    Parse and segregate the content
     */
    public static void parseCron(final String cronCommands) throws NoSuitableParserException {
        try{
            cronCommand=cronCommands.split(" ");
            parserInterfaces=new ParserInterface[cronCommand.length];
            fetchParser();
            cronParser();
            for(int cron_parser_index=0;cron_parser_index<parserInterfaces.length;cron_parser_index++){
                parserInterfaces[cron_parser_index].printCron();
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }

}
