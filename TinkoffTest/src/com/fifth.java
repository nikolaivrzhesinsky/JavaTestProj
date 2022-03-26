package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fifth {

    public static void main(String[] args) throws IOException {

        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));

        int count=0;
        String[] arr_A = reader.readLine().trim().split(" ");
        int n=Integer.parseInt(arr_A[0]);
        int k=Integer.parseInt(arr_A[1]);

        int[] array= new int[n];
        for(int i=0;i<n;i++){
            array[i]=i+1;
        }
        if(niceNum(array,k)){
            count++;
        }
        while(NextSet(array,n)){

            if(niceNum(array,k)){
                count++;
            }
        }
        System.out.println(count);
    }

    public static void Print(int[] array){
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println(" ");
    }

    public static  boolean NextSet(int[] a, int n){
        int j = n - 2;
        while (j != -1 && a[j] >= a[j + 1]) j--;
        if (j == -1)
            return false;
        int k = n - 1;
        while (a[j] >= a[k]) k--;
        swap(a, j, k);
        int l = j + 1, r = n - 1;
        while (l<r)
            swap(a, l++, r--);

        return true;
    }

    public static void swap(int[] a, int i, int j)
    {
        int s = a[i];
        a[i] = a[j];
        a[j] = s;
    }

    public static boolean niceNum(int[] array,int k){
        int result=0;

        for(int i=0;i<array.length;i++){
            result+=array[i]*(i+1);
        }
        if(result%k==0){
            return true;
        }
        else {
            return false;
        }
    }

}
