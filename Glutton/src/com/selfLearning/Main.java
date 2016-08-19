package com.selfLearning;

import java.util.Scanner;

public class Main {

    static final int SECONDS_IN_DAY = 86400;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfTestSuits = Integer.parseInt(in.nextLine());
        int cookiesInBox;
        int competitors;
        String testSuiteParams;
        int[] results = new int[numberOfTestSuits];

        for(int i=0; i<numberOfTestSuits; i++){
            testSuiteParams = in.nextLine();
            String[] tmp = testSuiteParams.split(" ");
            competitors = Integer.parseInt(tmp[0]);
            if(1 <= competitors && competitors <= 10000){
                cookiesInBox = Integer.parseInt(tmp[1]);
                if(1 <= cookiesInBox && cookiesInBox <= 1000000000){
                    Glutton[] g = new Glutton[competitors];

                    for(int j=0; j<competitors; j++){
                        g[j] = new Glutton(in, cookiesInBox);
                        results[i] += g[j].getBoxes();
                    }
                } else{
                    System.out.print(0);
                }
            } else{
                System.out.print(0);
            }
        }

        for (int i=0; i<numberOfTestSuits; i++){
            System.out.println(results[i]);
        }
    }
}
