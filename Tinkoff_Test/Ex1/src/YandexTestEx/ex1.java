package YandexTestEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ex1 {
    public static void main(String[] args) {

        String A, B;
        char[] charB = new char[0];
        char[] charA = new char[0];
        char[] charRes;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            A = reader.readLine();
            B = reader.readLine();

            charA = A.toCharArray();
            charB = B.toCharArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        charRes = new char[charB.length];

        Map<Character,Integer> mapA= new HashMap<>();

        for(int i=0; i<charA.length;i++){
            if(charA[i]==charB[i]){
                charRes[i]='P';
            }
            else if (mapA.containsKey(charA[i])){
                mapA.put(charA[i],mapA.get(charA[i])+1);
            }
            else{
                mapA.put(charA[i],1);
            }
        }

        for(int i=0;i<charB.length;i++){
            if(charRes[i]!='P') {
                if (mapA.containsKey(charB[i])) {
                    if (mapA.get(charB[i]) > 0) {
                        charRes[i] = 'S';
                        mapA.put(charB[i], mapA.get(charB[i]) - 1);
                    }
                    else {
                        charRes[i] = 'I';
                    }
                } else {
                    charRes[i] = 'I';
                }
            }
        }

        for (char t : charRes) {
            System.out.print(t);
        }

    }


}





