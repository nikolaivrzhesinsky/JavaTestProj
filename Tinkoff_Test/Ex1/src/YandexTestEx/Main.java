package YandexTestEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        String input;
        String[]strInput=new String[2];
        int a = 0,b = 0;

        try(BufferedReader reader= new BufferedReader(new InputStreamReader(System.in))){

            input= reader.readLine();
            strInput=input.split(" ");
            a=Integer.parseInt(strInput[0]);
            b=Integer.parseInt(strInput[1]);

        }
        catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        System.out.println(a+b);
    }
}
