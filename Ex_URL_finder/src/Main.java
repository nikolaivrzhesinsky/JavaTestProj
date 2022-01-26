import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Парсер реквестов
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();

        int indexOfAskPoint= url.lastIndexOf('?');
        String subStr= url.substring(indexOfAskPoint+1);
//        System.out.println(subStr);

        String[] urlArray=subStr.split("&");
//        for(String str: urlArray){
//            System.out.println(str);
//        }

        for(String str: urlArray){
            int indexDraw= str.lastIndexOf('=');
            if(indexDraw!=-1){
                System.out.print(str.substring(0,indexDraw)+" ");
            }
            else{
                System.out.print(str+" ");
            }
        }
        System.out.println();

        String objStr="obj";
        for(String str: urlArray){
            int indexDraw= str.lastIndexOf('=');
            if(indexDraw!=-1) {
                String tempObj= str.substring(0,indexDraw);
                if(tempObj.equals(objStr)) {

                    try {
                        String Str = str.substring(indexDraw + 1);
                        double doubleStr = Double.parseDouble(Str);
                        alert(doubleStr);
                    } catch (NumberFormatException e) {
                        alert(str.substring(indexDraw));
                    }
                }
            }

        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}

