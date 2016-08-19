package com.selfLearning;

import static com.selfLearning.Main.SECONDS_IN_DAY;

public class ForDebugging {

    static int cookiesPerDay(){
        int seconds = 250000;
        int result = 0;
        int usedTime = 0;
        while (usedTime+seconds <= SECONDS_IN_DAY-1){
            usedTime += seconds;
            result++;
        }
        return result;
    }

    static int boxesPerDay(int cookiesPerBox){
        int cookies = 250;
        int result = 0;
        int usedCookies = 0;
        while (cookies - usedCookies > 0){
            usedCookies += cookiesPerBox;
            result++;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.print("Result = " + boxesPerDay(200));
    }
}
