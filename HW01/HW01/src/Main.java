/*
Реализовать алгоритм пирамидальной сортировки (сортировка кучей)
 */
class HeapSort {
    public void sort(int[] Array) {
        // Построение кучи (перегруппируем массив)
        for (int i = Array.length / 2 - 1; i >= 0; i--)
            heapify(Array, Array.length, i);

        // Один за другим извелекаем элементы из кучи
        for (int i = Array.length - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = Array[0];
            Array[0] = Array[i];
            Array[i] = temp;

            //Вызываем процедуру heapify на умеьшенной куче
            heapify(Array, i, 0);
        }
    }
    private void heapify(int[] Array, int n, int i){
        int largest = i; // инициализируем наибольший элемент как корень
        int left = 2 * i + 1; // левый индекс
        int right = 2 * i + 2; // правый индекс

        // Если левый элемент больше корня
        if(left < n && Array[left] > Array[largest])
            largest = left;

        // Если правый элемент больше, чем самый большой элемент на данный момент
        if (right < n && Array[right] > Array[largest])
            largest = right;
        // Если самый бльшой элемент не корень
        if (largest != i){
            int temp = Array[i];
            Array[i] = Array[largest];
            Array[largest] = temp;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(Array, n, largest);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        int n = 50;
        int[] Array = new int[n];

        for (int i = 0; i < n; i++)
            Array[i] = (int) (Math.random() * 1000);

        for (int i = 0; i < Array.length; i++)
            System.out.print(Array[i] + " ");
        System.out.println();
        HeapSort hs = new HeapSort();
        hs.sort(Array);

        for (int i = 0; i < Array.length; i++)
            System.out.print(Array[i] + " ");
    }
}
