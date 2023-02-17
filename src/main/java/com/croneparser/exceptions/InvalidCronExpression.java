package main.java.com.croneparser.exceptions;

/**
 * @Author:Subodh Kumar
 * @Version:1.0
 *
 * @Description: This exception is specified for invalid Cron Expression
 */
public class InvalidCronExpression extends Exception{
    public InvalidCronExpression(String errorMsg){
        super(errorMsg);
    }

    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public void printStackTrace(){
       super.printStackTrace();
    }
}
