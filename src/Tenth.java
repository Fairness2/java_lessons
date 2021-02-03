import myExceptions.MyArrayDataException;
import myExceptions.MyArraySizeException;

public class Tenth {
    public static void main(String[] args) {
        doTask();
    }

    private static void doTask(){
        String[][] originalArray = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "3"},
        };
        System.out.println("Оригинальынй массив:");
        printArray(originalArray);
        System.out.println();
        int sum = 0;
        try {
            sum = getSumArray(originalArray);

        }
        catch (MyArrayDataException | MyArraySizeException e){
            System.out.printf("Преобразовать массив не удалось. %n%s%n", e.getMessage());
        }

        System.out.printf("Сумма массива %s%n", sum);

        /*System.out.println();
        System.out.println("Преобразованный массив:");
        printArray(newArray);*/
    }

    private static int getSumArray(String[][] stringArray) throws MyArrayDataException, MyArraySizeException {
        if (stringArray.length != 4 || stringArray[0].length != 4){
            throw new MyArraySizeException("Массив не соответствует размеру 4x4");
        }
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].length != 4){
                throw new MyArraySizeException(String.format("Массив не соответствует размеру 4x4, строка %s", i + 1));
            }
        }

        int[][] newArray = new int[4][4];
        int sum = 0;
        for (int i = 0; i < stringArray.length; i++){
            for (int j = 0; j < stringArray[i].length; j++){
                try {
                    newArray[i][j] = Integer.parseInt(stringArray[i][j]);
                }
                catch (NumberFormatException e){
                    throw new MyArrayDataException(String.format("Ошибка преобразования элемента %s:%s", i + 1, j + 1), e);
                }
                sum += newArray[i][j];
            }
        }
        return sum;
    }

    private static void printArray(String[][] array){
        for (String[] items : array) {
            for (String item : items) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    private static void printArray(int[][] array){
        for (int[] items : array) {
            for (int item : items) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
