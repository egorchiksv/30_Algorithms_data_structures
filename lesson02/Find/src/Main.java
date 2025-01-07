public class Main {

    public static int find(int[] array, int value){
        for(int i = 0; i < array.length; i++){
            if(array[i] == value){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int value){
        return binarySearch(array, value, 0, array.length - 1);
    }

    public static int binarySearch(int[] array, int value, int min, int max){
        int midpoint;
        if(max < min){
            return -1;
        } else {
            midpoint = (max - min) / 2 + min;
        }

        if (array[midpoint] < value){
            return binarySearch(array, value, midpoint + 1, max);
        } else {
            if (array[midpoint] > value){
                return binarySearch(array, value, min, midpoint - 1);
            }else {
                return midpoint;
            }
        }
    }

    public static void quickSort(int[] array, int startPosition, int endPosition){
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(startPosition + endPosition) / 2];
        do {
            while (array[leftPosition] < pivot){
                leftPosition++;
            }
            while (array[rightPosition] > pivot){
                rightPosition--;
            }
            if(leftPosition <= rightPosition){
                if(leftPosition < rightPosition) {
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;
            }
        } while (leftPosition <= rightPosition);

        if(leftPosition < endPosition){
            quickSort(array, leftPosition, endPosition);
        }
        if (startPosition < rightPosition) {
            quickSort(array, startPosition, rightPosition);
        }
        for (int i = 0; i <= array.length; i++){
            System.out.println(array[i]);
        }

    }

    private static void heapify(int[] array, int heapSize, int rootIndex){
        int largest = rootIndex; // инициализируем наибольший элемент как корень
        int leftChild = 2 * rootIndex + 1;// левый = 2 * rootIndex + 1
        int rightChild = 2 * rootIndex + 2;// правый = 2 * rootIndex + 2

        //Если левый дочерний элемент больше корня
        if(leftChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;
        //Если самый большой элемент не корень
        if(largest != rootIndex){
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            //Рекурсивно преобразуем в довоичную кучу затроунтое поддерево
            heapify(array, heapSize, largest);
        }

    }

    public static void  sort(int[] array){
        //Построение кучи (перегруппируем массив)
        for (int i = array.length / 2 - 1; i >= 0; i--)
            heapify(array, array.length, i);

        //Один за другим извлекаем элементы из кучи
        for (int i = array.length - 1; i >= 0; i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            //Вызываем процедуру heapify на уменьшенной кучи
            heapify(array, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{9,2,7,4,5,6,3,8,1};
//        System.out.println(find(array, 5));
//        System.out.println(binarySearch(array, 91));
//        quickSort(array, 0, 8);

    }
}