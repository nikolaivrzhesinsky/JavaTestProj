


public class ShakerSort {
    public static void main(String[] args) {
        int[] array = {3, 1, 5, 8, 1, 0, 6, 4, 6, 7};
        int left = 0; // левая граница
        int right = array.length - 1; // правая граница

        do
        {
            //Сдвигаем к концу массива "тяжелые элементы"
            for (int i = left; i < right; i++)
            {
                if(array[i] > array[i+1])
                {
                    array[i] ^= array[i+1];
                    array[i+1] ^= array[i];
                    array[i] ^= array[i+1];
                }
            }
            right--; // уменьшаем правую границу
            //Сдвигаем к началу массива "легкие элементы"
            for (int i = right; i > left ; i--)
            {
                if(array[i] < array[i-1])
                {
                    array[i] ^= array[i-1];
                    array[i-1] ^= array[i];
                    array[i] ^= array[i-1];
                }
            }
            left++; // увеличиваем левую границу
        } while (left <= right);

        for (int i : array) System.out.print(i + " ");
    }
}
