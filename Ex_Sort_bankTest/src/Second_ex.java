import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Second_ex {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        int n=8;
        int[] array= new int[n];

        System.out.println("Введите 8 элементов");
        for(int i=0;i<n;i++){
            array[i]=Integer.parseInt(reader.readLine());
        }
        array= quickSort(array,0, array.length-1);

    }
    public static int[] quickSort(int[] source, int left, int right){
        int leftMarker= left;
        int rightMarker= right;

        int pivot = source[(leftMarker + rightMarker) / 2];
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (source[leftMarker] < pivot) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (source[rightMarker] > pivot) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < right) {
            quickSort(source, leftMarker, right);
        }
        if (left < rightMarker) {
            quickSort(source, left, rightMarker);
        }
        return source;
    }
}
