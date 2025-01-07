class HeapSort{
    private void heapify(int[] arr, int n, int i){
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (i != largest){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            heapify(arr, n, largest);
        }
    }

    public void sort(int[] arr){
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--){
            heapify(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);

        }
    }
}

public class Main {
    /*
    Пирамидальная сортировка
    Реализовать алгоритм пирамидальной сортировки (сортировка кучей)
     */
    public static void main(String[] args) {
        int N = 10;
        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = (int) (Math.random() * 100);

        for (int i = 0; i < N; i++)
            System.out.print(arr[i] + " ");

        System.out.println();

        HeapSort HS = new HeapSort();
        HS.sort(arr);

        for (int i = 0; i < N; i++)
            System.out.print(arr[i] + " ");
    }
}