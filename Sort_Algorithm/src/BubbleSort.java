


public class BubbleSort {

    public static int[] array={5,1,4,2,8};

    public static void main(String[] args) {

       bubblesort(array);
        for (int i : array) {
            System.out.print(i+" ");
        }
    }

    static int[] bubblesort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++){
            for (int j = i+1; j < arr.length; j++){
                if (arr[i] > arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
        return arr;
    }


}
