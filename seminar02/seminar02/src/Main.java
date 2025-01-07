import java.util.Date;

public class Main {
    /*
    Задача 1 - Реализуем простой алгоритм сортировки
    На вход поступает целое цисло N из отрезка [1;1000] и массив из N целых чисел
    Необходимо написать один из простых алгоритмов сортировки массива:
    пузырьковую, вставками или выбором
     */

    public static void BubbleSort(int[] Array){
        boolean needSort = true;
        do {
            needSort = false;
            for (int i = 0; i < Array.length - 1; i++){
                if (Array[i] > Array[i + 1]){
                    int temp = Array[i];
                    Array[i] = Array[i + 1];
                    Array[i + 1] = temp;

                    needSort = true;
                }
            }
        }while (needSort);
    }

    /*
    Задача 2 - Реализуем быструю сортировку
    На вход поступает целое цисло N из отрезка [1;1000] и массив из N целых чисел
    Необходимо написать алгоритм быстрой сортировки массива.
     */

    public static void QuickSort(int[] Array){
        QuickSort(Array, 0, Array.length - 1);

    }

    private static void QuickSort(int[] Array, int left, int right){
        int i = left;
        int j = right;
        int pivot = Array[(left + right) / 2];

        do{
            while (Array[i] < pivot){
                i++;
            }
            while (Array[j] > pivot){
                j--;
            }
            if (i <= j){
                if (i < j){
                    int temp = Array[i];
                    Array[i] = Array[j];
                    Array[j] = temp;
                }
                i++;
                j--;
            }
        }while (i <= j);

        if (left < j){
            QuickSort(Array, left, j);
        }

        if (i <= right){
            QuickSort(Array, i, right);
        }
    }

    /*
    Задача 3 - Сравнение производительности сортировок
    Сравните время работы алгоритмов из задач 1 и 2ж
    Для сравнения в языке java есть класс Date с методом getTime().
     */

    /*
    Задача 4 - Реализуем алгоритм бинарного поиска
    Дано число N и упорядоченный массив из N целых чисел.
    Для числа K нужно найти позицию в массиве, на которой находится значение K.
     */
    public static Integer BinarySearch(int[] Array, int value){
        int left = 0, right = Array.length - 1;
        while (right - left > 1){
            int mid = (left + right) / 2;
            if (Array[mid] < value)
                left = mid;
            else
                right = mid;
        }
        if (Array[left] == value)
            return left;
        if (Array[right] == value)
            return right;

        return null;
    }

    public static void main(String[] args) {
        int N = 20000;
        int[] Array1 = new int[N];
//        int[] Array2 = new int[N];
        for (int i = 0; i < N; i++){
            Array1[i] = (int) (Math.random() * 100);
//            Array2[i] = Array1[i];
//            System.out.printf("%d ", Array[i]);
        }
//        System.out.println();
//        BubbleSort(Array);

//        Date start = new Date();
//        BubbleSort(Array1);
//        Date end = new Date();
//        long time1 = end.getTime() - start.getTime();

//        start = new Date();
        QuickSort(Array1);
//        end = new Date();
//        long time2 = end.getTime() - start.getTime();

//        System.out.printf("time1 = %d, time2 = %d%n", time1, time2);

//        for (int i = 0; i < N; i++){
//            System.out.printf("%d ", Array[i]);
//        }

        System.out.println(BinarySearch(Array1, 42));
    }


}