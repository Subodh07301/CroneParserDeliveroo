package main.java.com.croneparser.parserutil;

import main.java.com.croneparser.parserinterface.ParserInterface;

/**
 * @Author:Subodh Kumar
 * Version:1.0
 *
 * @Description: This file contains the logic for validation like to validate cron command
 * cron parser,expression format
 */
public class ValidationUtil {
    public static boolean validateCron(String cronCommand[]){
        if(cronCommand==null||cronCommand.length!=6){
            return false;
        }
        return true;
    }

    public static boolean validateParser(ParserInterface parserInterface[]){
        if(parserInterface==null||parserInterface.length!=6){
            return false;
        }
        for(int i=0;i<parserInterface.length;i++){
            if(parserInterface[i]==null){
                return false;
            }
        }

        return true;
    }

    public static boolean validateExpression(final String expr){
        return (expr!=null && !expr.equals("") && expr.length()>0);
    }
}
