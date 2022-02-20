import java.io.*;
import java.util.*;

public class FindNotGoodNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        String[] arr_A = br.readLine().split(" ");
        int[] A = new int[N];
        for(int i_A = 0; i_A < arr_A.length; i_A++)
        {
            A[i_A] = Integer.parseInt(arr_A[i_A]);
        }
        int M = Integer.parseInt(br.readLine().trim());
        String[] arr_B = br.readLine().split(" ");
        int[] B = new int[M];
        for(int i_B = 0; i_B < arr_B.length; i_B++)
        {
            B[i_B] = Integer.parseInt(arr_B[i_B]);
        }

        int out_ = solve(N, A, M, B);
        System.out.println(out_);

        wr.close();
        br.close();
    }
    public static int solve(int N, int[] A, int M, int[] B){
// Type your code here
        int res=0;
        HashMap<Integer,Boolean> num= new HashMap<>();
        for(int i=0;i<B.length;i++){
            num.put(B[i],false);
        }
        for(int i=0;i<A.length;i++){
            if(!num.containsKey(A[i])){
                res++;
            }
        }
        return res;
    }
}