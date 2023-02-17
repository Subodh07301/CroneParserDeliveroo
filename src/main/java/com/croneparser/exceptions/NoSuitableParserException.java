package main.java.com.croneparser.exceptions;

/**
 * @Author:Subodh Kumar
 * @Version:1.0
 *
 * @Description:This exception is specified when there is no suitable parser is there
 */
public class NoSuitableParserException extends Exception{
    public NoSuitableParserException(String errorMsg){
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
