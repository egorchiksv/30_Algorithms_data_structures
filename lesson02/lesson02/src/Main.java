public class Main {

    public static void bubbleSort(int[] array){
        boolean finish;
        do {
            finish = true;
            for (int i = 0; i < array.length - 1; i++){
                if (array[i] > array[i + 1]){
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    finish = false;
                }
            }
        }while (!finish);

    }

    public static void directSort(int[] array){
        for (int i = 0; i < array.length - 1; i++){
           int minPosition = i;
           for (int j = i + 1; j < array.length; j++){
               if(array[j] < array[minPosition]){
                   minPosition = j;
               }
           }
           if(i != minPosition){
               int temp = array[i];
               array[i] = array[minPosition];
               array[minPosition] = temp;
           }
        }
    }

    public static void insertSort(int[] array){
        for (int i = 0; i < array.length - 1; i++){
            for (int j = i + 1; j < array.length; j++){
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {4,2,5,8,1,9,2,3,6,8,5};
//        bubbleSort(array);
//        directSort(array);
        insertSort(array);
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}