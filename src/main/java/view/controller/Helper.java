package view.controller;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by wangxue on 2017/3/9.
 */
public class Helper {

    public static InputState checkInputState(String input){

        input = input.trim();

        //若六位数字则为股票代码
        if(input.length() == 6){
            boolean isNum = true;
            for(int i = 0 ; i < 6 ; i ++ ){
                if( input.charAt(i) >'9' || input.charAt(i) < '0'){
                    isNum = false;
                    break;
                }
            }

            if(isNum == true){
                return InputState.NUM;
            }

        }

        return InputState.NAME;

    }

    public static Date localDateToDate(LocalDate localDate){

        String temp = localDate.toString();
        Date date = new Date(temp);
        return date;

    }

}
