package com.selfLearning;


import java.util.Scanner;

import static com.selfLearning.Main.SECONDS_IN_DAY;

public class Glutton {
    // seconds to eat one cookie
    private int seconds;

    // number of cookies eat in one day
    private int cookies;

    // number of boxes to eat during one day
    private int boxes;

    public int getSeconds(){
        return this.seconds;
    }

    public int getBoxes(){
        return this.boxes;
    }

    public int getCookies(){
        return this.cookies;
    }

    public Glutton(){
        this.seconds = 0;
        this.cookies = 0;
        this.boxes = 0;
    }

    public Glutton(Scanner in, int cookiesPerBox){
        this.seconds = Integer.parseInt(in.nextLine());
        if(1 <= this.seconds && this.seconds <= 100000){
            this.cookies = cookiesPerDay();
            this.boxes = boxesPerDay(cookiesPerBox);
        } else{
            this.cookies = 0;
            this.boxes = 0;
        }
    }

    public String toString(){
        return "Eats one cookie in " + String.valueOf(seconds) + " seconds.";
    }

    /*
     * Returns number of cookies eat in one day
     */
    private int cookiesPerDay(){
        int result = 0;
        int usedTime = 0;
        while (usedTime+this.seconds <= SECONDS_IN_DAY){
            usedTime += this.seconds;
            result++;
        }
        return result;
    }

    /*
     * Return number of boxes eat in one day
     */
    private int boxesPerDay(int cookiesPerBox){
        int result = 0;
        int usedCookies = 0;
        while (this.cookies - usedCookies > 0){
            usedCookies += cookiesPerBox;
            result++;
        }
        return result;
    }
}
