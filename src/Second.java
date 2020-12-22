public class Second {

    public static void main(String[] args){
        doFirstTask();
        doSecondTask();
        doThirdTask();
        doFourthTask();
        doFifthTask();
        doSixthTask();
        doSeventhTask();
    }

    /*
     * Задание 1
     */
    static private void doFirstTask(){
        System.out.println("Задание 1");
        int[] arr = { 1, 0, 1, 1, 1, 0, 0, 0, 1, 0 };

        for (int i = 0; i < arr.length; i++){
            arr[i] = arr[i] == 1 ? 0 : 1;
        }
        printArray(arr);
    }

    /*
     * Задание 2
     */
    static private void doSecondTask(){
        System.out.println("Задание 2");
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++){
            if (i == 0) continue;
            arr[i] = arr[i - 1] + 3;
        }
        printArray(arr);
    }

    /*
     * Задание 3
     */
    static private void doThirdTask(){
        System.out.println("Задание 3");
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < 6)
                arr[i] = arr[i] * 2;
        }
        printArray(arr);
    }

    /*
     * Задание 4
     */
    static private void doFourthTask(){
        System.out.println("Задание 4");
        int len = 7;
        int[][] arr = new int[len][len];
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (j == i || j == (len - i - 1))
                    arr[i][j] = 1;
            }
        }
        for (int[] el : arr) {
            printArray(el);
        }
    }

    /*
     * Задание 5
     */
    static private void doFifthTask(){
        System.out.println("Задание 5");
        int[] arr = new int[10];
        generateRandomArray(arr, 100);
        printArray(arr);
        int min = arr[0];
        int max = arr[0];
        for (int el : arr) {
            if (min > el)
                min = el;
            if (max < el)
                max = el;
        }
        System.out.println("Минимальное значение: " + min);
        System.out.println("максимальное значение: " + max);
    }

    /*
     * Задание 6
     */
    static private void doSixthTask(){
        System.out.println("Задание 6");
        int[] arr = new int[10];
        generateRandomArray(arr, 100);
        printArray(arr);
        boolean arrHasBalancePoint = checkBalance(arr);
        System.out.println("В масиве есть место, где правая и левая части равны? " + arrHasBalancePoint);
        int[] arr1 = {2, 2, 2, 1, 2, 2, 10, 1};
        printArray(arr1);
        arrHasBalancePoint = checkBalance(arr1);
        System.out.println("В масиве есть место, где правая и левая части равны? " + arrHasBalancePoint);
    }

    /*
     * Задание 7
     */
    static private void doSeventhTask(){
        System.out.println("Задание 7");
        int len = 10;
        int[] arr = new int[len];
        generateRandomArray(arr, 100);
        printArray(arr);
        int n = (int)(Math.random() * (len * 2) - len);
        System.out.println("Сдвинуть массив на " + n);
        moveArrayElement(arr, n);
        System.out.println("Сдвинутый массив");
        printArray(arr);
    }


    static private void printArray(int[] arr){
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static private void generateRandomArray(int[] arr, int max){
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random() * max);
        }
    }

    static private boolean checkBalance(int[] arr){
        boolean res = false;
        for (int i = 0; i < arr.length; i++){
            int sumRight = 0;
            int sumLeft = 0;
            for (int r = i; r < arr.length; r++){
                sumRight += arr[r];
            }
            for (int l = i - 1; l >= 0; l--){
                sumLeft += arr[l];
            }
            if (sumLeft == sumRight){
                res = true;
                break;
            }
        }
        return res;
    }

    static private void moveArrayElement(int[] arr, int n){
        for (int l = 0; l < Math.abs(n); l++) { //Сдвигаем на одну позицию столько раз, на сколько позиций нам нужно сдвинуть

            int i = n > 0 ? arr.length - 2 : 0; // Выбираем изначальную точку отчёта, если положительный сдвиг, то начинаем с конца массива минус сдвиг, если отрицательынй с начала

            while ((n > 0 && i >= 0) || (n <= 0 && i < arr.length - 1)) { // Продолжаем пока не дойдём до начала массива, если сдвиг положительный, или до конца минус сдвиг

                int currentElement = arr[i];
                int changeNumber = n > 0 ? i + 1 : i - 1;

                //Првоеряем выходит ли индекс за границы массива
                if (changeNumber >= arr.length) {
                    changeNumber = changeNumber - arr.length;
                }
                else if (changeNumber < 0) {
                    changeNumber = arr.length + changeNumber;
                }

                int changeElement = arr[changeNumber];

                //Меняем значения
                arr[changeNumber] = currentElement;
                arr[i] = changeElement;

                if (n > 0) // сдвигаем точку отчёта влево, если положительный сдвиг, и вправо, если отрицательный
                    i--;
                else
                    i++;
            }
        }
    }
}
