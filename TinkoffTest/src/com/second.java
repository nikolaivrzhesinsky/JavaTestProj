package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class second {

    public static void main(String[] args )throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String ab=reader.readLine();
        String ac=reader.readLine();
        String bc=reader.readLine();

        sortABC(ab,ac,bc);


    }
    public static   void sortABC (String ab, String ac, String bc){
        if(Objects.equals(ab, ">")){
            if(Objects.equals(ac, ">")){
                if(Objects.equals(bc, ">")){
                    System.out.println("cba");
                }
                else if(Objects.equals(bc, "<")){
                    System.out.println("bca");
                }
                else if (Objects.equals(bc, "=")){
                    System.out.println("bca");
                    System.out.println("cba");
                }
            }
            else if(Objects.equals(ac, "<")){

                if(Objects.equals(bc, "<")){
                    System.out.println("bac");
                }
            }
            else if(Objects.equals(ac, "=")){
                if(Objects.equals(bc, "<")){
                    System.out.println("bac");
                    System.out.println("bca");
                }
            }
        }
        else if(Objects.equals(ab, "<")){
            if(Objects.equals(ac, ">")){
                System.out.println("cab");
            }
            else if(Objects.equals(ac, "<")){
                if(Objects.equals(bc, ">")){
                    System.out.println("acb");
                }
                else if(Objects.equals(bc, "<")){
                    System.out.println("abc");
                }
                else if(Objects.equals(bc, "=")){
                    System.out.println("abc");
                    System.out.println("acb");
                }
            }
            else if(Objects.equals(ac, "=")){
                if(Objects.equals(bc, ">")){
                    System.out.println("acb");
                    System.out.println("cab");
                }
            }
        }
        else if(Objects.equals(ab, "=")){
            if(Objects.equals(ac, ">")){
                if(Objects.equals(bc, ">")){
                    System.out.println("cab");
                    System.out.println("cba");
                }
            }
            else if(Objects.equals(ac, "<")){
                if(Objects.equals(bc, "<")){
                    System.out.println("abc");
                    System.out.println("bac");
                }
            }
            else if(Objects.equals(ac, "=")){
                if(Objects.equals(bc, "=")){
                    System.out.println("abc");
                    System.out.println("acb");
                    System.out.println("bac");
                    System.out.println("bca");
                    System.out.println("cab");
                    System.out.println("cba");
                }
            }
        }

    }
}
