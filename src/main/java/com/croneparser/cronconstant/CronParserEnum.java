package main.java.com.croneparser.cronconstant;

/**
 * @Author: Subodh Kumar
 * @Version: 1.0
 *
 * @Description: This file contain the enum value for different cron expression field
 */
public enum CronParserEnum {
    MINUTE(){
        @Override
        public String toString() {
            return "Minute";
        }
    },
    HOUR(){
        @Override
        public String toString() {
            return "Hour";
        }
    },
    DAY_OF_MONTH(){
        @Override
        public String toString() {
            return "Day Of Month";
        }
    },
    MONTH(){
        @Override
        public String toString() {
            return "Month";
        }
    },
    DAY_OF_WEEK(){
        @Override
        public String toString() {
            return "Day Of Week";
        }
    },
    COMMAND(){
        @Override
        public String toString() {
            return "Command";
        }
    }
}
