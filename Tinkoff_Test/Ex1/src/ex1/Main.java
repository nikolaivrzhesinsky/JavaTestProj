package ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static String input1 ;
    static String input2 ;
    static int yMin=Integer.MAX_VALUE;
    static int yMax=Integer.MIN_VALUE;
    static int xMin=Integer.MAX_VALUE;
    static int xMax=Integer.MIN_VALUE;

    public static void main(String[] args) {

        List<String> numbers = new ArrayList(Arrays.asList("first", "second", "third"));
        for (String number : numbers) {
            if ("third".equals(number)) {
                numbers.add("fourth");
            }
        }
        System.out.println(numbers.size());



        int a= Integer.MAX_VALUE;
        int b= Integer.MAX_VALUE;
        System.out.println(a+b);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            input1 = (reader.readLine());
            input2 = (reader.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        parseInput(input1);
        parseInput(input2);

        System.out.println(getSquare(xMin, xMax, yMin, yMax));


    }

    public static void parseInput(String input){


        String[] inputArrStr=input.split(" ");
        int[] inputArrInt= new int[inputArrStr.length];

        for(int i=0;i<inputArrInt.length;i++){
            inputArrInt[i]=Integer.parseInt(inputArrStr[i]);

            if(i%2==0){
                if(yMin>inputArrInt[i]){
                    yMin=inputArrInt[i];
                }
                if(yMax<inputArrInt[i]){
                    yMax=inputArrInt[i];
                }
            }
            else {
                if(xMin>inputArrInt[i]){
                    xMin=inputArrInt[i];
                }
                if(xMax<inputArrInt[i]){
                    xMax=inputArrInt[i];
                }
            }
        }
    }

    public static  int getSquare(int xMin, int xMax, int yMin, int yMax){

        int square;
        int sumY=yMax-yMin;
        int sumX=xMax-xMin;

        if(sumY>=sumX){
            square=sumY*sumY;
        }
        else {
            square=sumX*sumX;
        }

        return  square;
    }
}
