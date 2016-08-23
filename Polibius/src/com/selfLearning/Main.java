package com.selfLearning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static final int LETTER_A = 65;
    public static final int LETTER_Z = 90;
    public static final int LETTER_I = 73;
    public static final int LETTER_J = 74;
    public static final int SPACE = 32;

    /*
     * Initializes Polibus Array without letter 'J'
     */
    public static ArrayList<ArrayList<Integer>> initPolibiusArray(){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i = LETTER_A; i <= LETTER_Z;){
            ArrayList<Integer> row = new ArrayList<>();
            int rowSize = 5;
            for(int j=0; j<rowSize; j++){
                if(i != LETTER_J){
                    row.add(i);
                } else{
                    rowSize = 6;
                }
                i++;
            }
            result.add(row);
        }
        return result;
    }

    /*
     * Finds place of input letter in polibius array
     */
    public static String findCode(ArrayList<ArrayList<Integer>> polibius, int letter){
        String result = "";
        Iterator<ArrayList<Integer>> rowIter = polibius.iterator();
        int rowIndex = 1;
        while (rowIter.hasNext()){
            int colIndex = 1;
            ArrayList<Integer> row = rowIter.next();
            Iterator<Integer> colIter = row.iterator();
            while (colIter.hasNext()){
                if(letter == colIter.next()){
                    result += rowIndex;
                    result += colIndex;
                    result += " ";
                    break;
                }
                colIndex++;
            }
            rowIndex++;
        }
        return  result;
    }

    public static String convert(ArrayList<ArrayList<Integer>> polibius, String input){
        String result = "";
        char[] letters = input.toCharArray();
        for(int i=0; i<letters.length; i++){
            switch (letters[i]){
                case SPACE:
                    break;

                case LETTER_J:
                    result += findCode(polibius, LETTER_I);
                    break;

                default:
                    result += findCode(polibius, letters[i]);
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfTests = Integer.valueOf(in.nextLine());
        String[] results = new String[numberOfTests];
        String toHash;
        ArrayList<ArrayList<Integer>> polibiusArray = initPolibiusArray();
        for(int i=0; i<numberOfTests; i++){
            toHash = in.nextLine().toUpperCase();
            results[i] = convert(polibiusArray, toHash);
        }

        for(String i:results){
            System.out.println(i);
        }
    }
}
