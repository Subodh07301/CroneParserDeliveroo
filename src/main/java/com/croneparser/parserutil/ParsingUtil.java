package main.java.com.croneparser.parserutil;

import main.java.com.croneparser.cronconstant.CronConstant;
import main.java.com.croneparser.cronconstant.CronParserEnum;
import main.java.com.croneparser.exceptions.InvalidCronExpression;
import main.java.com.croneparser.exceptions.NoSuitableParserException;

import java.util.Stack;

import static main.java.com.croneparser.parserutil.ValidationUtil.validateExpression;

/**
 * @Author: Subodh Kumar
 * @Version: 1.0
 *
 * @Description: This Util class will contain the logic to parse the expression and also categorize
 * on the basis of cronParser type
 */
public class ParsingUtil {
    public static String parseCron(StringBuilder expr,
                                       CronParserEnum cronParserEnum)
            throws InvalidCronExpression, NoSuitableParserException {

        //Validate the expression
        if(!validateExpression(String.valueOf(expr))){
            throw new InvalidCronExpression("CronExpression is not valid");
        }

        //Declare the cron description
        String description="";

        //Declare the operand stack which will contain the extracted data
        Stack<Integer> operand=new Stack<>();

        //Loop to the expression and extract data
        while(expr!=null&&expr.length()>=1){

            //Get The number from cron expression
            String num=getNumericValue(expr);

            if(!num.equals("")){
                operand.add(Integer.valueOf(num));
                continue;
            }

            //Fetch special char from expression
            char opr=getOperator(expr);
            switch (opr){
                case '*':
                    expandAsteric(operand,cronParserEnum);
                    break;
                case '/':
                    num=getNumericValue(expr);
                    if(!num.equals("")){
                        Stack<Integer> st=new Stack<>();
                        for (int j=0;j<operand.size();j+=Integer.valueOf(num)){
                            st.push(operand.get(j));
                        }
                        operand=st;
                    }
                    break;
                case '-':
                    num=getNumericValue(expr);
                    if(!num.equals("")){
                        for(int i=operand.pop();i<=Integer.valueOf(num);i++){
                            operand.add(i);
                        }
                    }
                    break;
                case ',':
                    num=getNumericValue(expr);
                    if(!num.equals("")){
                        operand.add(Integer.valueOf(num));
                    }
                    break;
                default:
                    throw new InvalidCronExpression("The cron expression is not valid");
            }
        }

        //Format the description in the column format
        return formatInColumn(operand,cronParserEnum);
    }

    /*
    Format the description to fit in the defined no of column
     */
    private static String formatInColumn(Stack<Integer> operand,
                                         CronParserEnum cronParserEnum){
        String operandString=cronParserEnum.toString()+":";
        for(int i=0;i<CronConstant.LINE_SPACING-cronParserEnum.toString().length();i++){
            operandString=operandString+" ";
        }

        for(int i=0;i<operand.size();i++){
            if(i>0&&(i%CronConstant.MAX_COLLUMN)==0){
                operandString=operandString+"\n\t";
                for(int j=0;j<CronConstant.LINE_SPACING;j++){
                    operandString=operandString+" ";
                }
            }
            operandString=operandString+"\t"+operand.get(i);
        }
        return operandString;
    }

    //Expand * for different type of cronPrser
    private static void expandAsteric(Stack<Integer> operand,
                                      CronParserEnum cronParserEnum)
            throws NoSuitableParserException {
       //Get Maximum value to expand with
        int maxValue=0;
        int startValue=0;
        switch (cronParserEnum){
            case HOUR:
                maxValue= CronConstant.MAX_HOUR;
                break;
            case MINUTE:
                maxValue= CronConstant.MAX_MINUTE;
                break;
            case DAY_OF_MONTH:
                startValue=1;
                maxValue= CronConstant.MAX_DAY_OF_MONTH+1;
                break;
            case DAY_OF_WEEK:
                startValue=1;
                maxValue= CronConstant.MAX_DAY_OF_WEEK+1;
                break;
            case MONTH:
                startValue=1;
                maxValue= CronConstant.MAX_MONTH+1;
                break;
            default:
                throw new NoSuitableParserException("There is no such cron parser is available");
        }

        if(!operand.isEmpty()){
            startValue=operand.pop();
        }

        //Expand the value and add to operand stack
        for(int i=startValue;i<maxValue;i++){
            operand.push(i);
        }
    }


    //Form Numeric Value from Expression
    private static String getNumericValue(StringBuilder expr){
        if(expr==null||expr.length()<1||expr.charAt(0)<'0'||expr.charAt(0)>'9'){
            return "";
        }
        return ""+expr.charAt(0)+getNumericValue(expr.deleteCharAt(0));
    }

    //Get Operator from Expression like "*, -, /, ,"
    private static char getOperator(StringBuilder expr){
        if(expr==null||expr.length()<1){
            return ' ';
        }
        char opr=expr.charAt(0);
        expr.deleteCharAt(0);
        return opr;
    }

}
