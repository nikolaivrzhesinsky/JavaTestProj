import java.io.*;
import java.util.*;


public class FindNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);


        int A_size = Integer.parseInt(br.readLine().trim());
        String[] arr_A = br.readLine().trim().split(" ");
        int[] A = new int[A_size];

        for (int i_A = 0; i_A < arr_A.length; i_A++) {
            A[i_A] = Integer.parseInt(arr_A[i_A]);
        }

        int K_Array_size = Integer.parseInt(br.readLine().trim());
        int[] K_Array = new int[K_Array_size];
        for (int i_K_Array = 0; i_K_Array < K_Array_size; i_K_Array++) {
            K_Array[i_K_Array] = Integer.parseInt(br.readLine().trim());
        }
        int[] out_ = process_queries(A, K_Array, A_size, K_Array_size);
        for (int i_out_ = 0; i_out_ < out_.length; i_out_++) {
            wr.println(out_[i_out_]);
        }

        wr.close();
        br.close();
    }

    static int[] process_queries(int[] A, int[] K_Array, int N, int K) {
// Write your code here
        Arrays.sort(A);
        int[] res= new int[K];

        for(int i=0;i<K;i++){
            int low=0;
            int high=A.length-1;
            boolean flag=true;
            while (low<=high) {
                int middle = low + (high - low) / 2;

                if (K_Array[i] < A[middle]) {
                    high = middle - 1;
                }
                else if (K_Array[i] > A[middle]) {
                    low = middle + 1;
                }
                else if(K_Array[i]==A[middle]){
                    res[i]=middle;
                    flag=false;
                    break;
                }
            }
            if(flag){
                if(K_Array[i]>A[low]){
                    res[i]=low+1;
                }
                else{
                    res[i]=low;
                }
            }
        }
        return res;
    }
}