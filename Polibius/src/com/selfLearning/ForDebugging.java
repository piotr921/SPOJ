package com.selfLearning;

import java.util.ArrayList;

import static com.selfLearning.Main.findCode;
import static com.selfLearning.Main.initPolibiusArray;

public class ForDebugging {

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> test = initPolibiusArray();
        System.out.print(test.toString());
        char c = 'J';
        String s = findCode(test, c);
        System.out.print("\n" + s);
    }
}
