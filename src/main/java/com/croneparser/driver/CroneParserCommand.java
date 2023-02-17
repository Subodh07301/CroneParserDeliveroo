package main.java.com.croneparser.driver;

import main.java.com.croneparser.parserfactory.builder.CronParsingBuilder;

/**
 * @Author:Subodh Kumar
 * @Version:1.0
 *
 * @Description: This is driver program to test the Cron Expression "
 */
public class CroneParserCommand {
    public static void main(String[] args) {
        try {
            //Parse the cron expression
            CronParsingBuilder.parseCron("*/15 0 1,15 * 1-5 /usr/bin/find");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}