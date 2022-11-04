package ex5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main_ex5 {

    static String num1;
    static String[] numArrString;
    static int[]numArrInt=new int[2];
    static ArrayList<String>listLibrary= new ArrayList<>();
    static ArrayList<String>arrWords= new ArrayList<>();
    static String[] LibraryToArr;
    static String[] sortArrLibrary;

    public static void main(String[] args) {

        addList();
        try(BufferedReader reader= new BufferedReader(new InputStreamReader(System.in))){

            num1= (reader.readLine());
            numArrString=num1.split(" ");
            numArrInt[0]=Integer.parseInt(numArrString[0]);
            numArrInt[1]=Integer.parseInt(numArrString[1]);

           for(int i=0; i<numArrInt[0];i++){
               listLibrary.add(reader.readLine());
           }

           for (int j=0;j<numArrInt[1];j++){
               arrWords.add(reader.readLine());
           }

           LibraryToArr= new String[listLibrary.size()];
           listLibrary.toArray(LibraryToArr);
           sortArrLibrary=Arrays.copyOf(LibraryToArr,LibraryToArr.length);
           Arrays.sort(sortArrLibrary);
        }
        catch (IOException e ){
            System.out.println(e.getMessage());
        }

        getPrefixPos(LibraryToArr,sortArrLibrary,arrWords);

    }

    public static void getPrefixPos(String[]LibraryToArr,
                                    String[]sortArrLibrary,ArrayList<String>arrWords){

        String[]arrWordsToArr = new String[arrWords.size()];
        arrWords.toArray(arrWordsToArr);
        String[] tempWord;

        for(int i=0;i<arrWordsToArr.length;i++){

            tempWord= arrWordsToArr[i].split(" ");
            int order= Integer.parseInt(tempWord[0]);
            String word=tempWord[1];
            int index = 0;
            int posInLibrary=0;
            int position=-1;
            String lastIndex=null;

            while (index!=order) {

                if(sortArrLibrary[posInLibrary].startsWith(word)){
                    index++;
                    lastIndex=sortArrLibrary[posInLibrary];
                }
                posInLibrary++;
                if(posInLibrary== sortArrLibrary.length){
                    break;
                }
            }

            if(index!=order){
                System.out.println(position);
            }
            else{
                for(int j=0;j< LibraryToArr.length;j++){

                    if(Objects.equals(LibraryToArr[j], lastIndex)){
                        position=j;
                        System.out.println(position+1);
                    }
                }
            }
        }
    }

    static void foo(){

        System.out.println("1111");
    }

    static void foo(int a){

        System.out.println("2222");
    }

    static void addList(){

        List<Integer> list= new ArrayList<>(10);
        for(int i=0;i<11;i++){
            list.add(i);
        }

    }
}
