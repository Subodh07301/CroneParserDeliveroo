package main.java.com.croneparser.exceptions;

/**
 * @Author:Subodh Kumar
 * @Version: 1.0
 *
 * @Description: This Exception will be thrown when the cron command is not proper
 */
public class IncorrectFormatCommandException extends Exception{
    public IncorrectFormatCommandException(String inCorrectFormatedCommand){
        super(inCorrectFormatedCommand);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public void printStackTrace() {
        System.out.println(super.getMessage());
    }
}
