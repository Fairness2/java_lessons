import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Fourth {
    public static void main(String[] args) {
        playGame();
    }

    private static void playGame(){
        char[][] matrix = generateMatrix();
        showMatrix(matrix);
        doGameLoop(matrix);

    }

    private static void doGameLoop(char[][] matrix){
        while (true){
            doUserTurn(matrix);
            showMatrix(matrix);
            if(checkGameFinish(matrix, getUserSymbol())){
                break;
            }
            doAITurn(matrix);
            showMatrix(matrix);
            if(checkGameFinish(matrix, getAISymbol())){
                break;
            }
        }
    }

    private static void showMatrix(char[][] matrix){
        for (char[] row: matrix){
            for (char item: row){
                System.out.print(item);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static char getUserSymbol(){
        return 'X';
    }

    private static char getAISymbol(){
        return 'O';
    }

    private static char getNeutralSymbol(){
        return '-';
    }

    private static int getLength(){
        return 5;
    }

    private static char[][] generateMatrix(){
        int len = getLength();
        char[][] matrix = new char[len][len];
        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++){
                matrix[i][j] = getNeutralSymbol();
            }
        }
        return matrix;
    }

    private static int getInputInt(String message){
        System.out.println(message);
        boolean success = false;
        Scanner scanner = new Scanner(System.in);
        int res = 0;
        do {
            try {
                res = scanner.nextInt();
                if (res >= 1 && res <= getLength()){
                    success = true;
                }
                else{
                    System.out.println("Write right number");
                }
            }
            catch (InputMismatchException ignored){
                System.out.println("Write right number");
            }
        }while (!success);
        return res;
    }

    private static boolean checkAvailableCell(int x, int y, char[][] matrix){
        return matrix[y][x] == getNeutralSymbol();
    }

    private static void doUserTurn(char[][] matrix){
        System.out.println("Введите координаты ячейки");
        while (true){
            int x = getInputInt(String.format("Введите ячейку по горизонтали (X) [1-%s]...", getLength())) - 1;
            int y = getInputInt(String.format("Введите ячейку по вертикали (Y) [1-%s]...", getLength())) - 1;
            if (checkAvailableCell(x, y, matrix)){
                matrix[y][x] = getUserSymbol();
                break;
            }
            else {
                System.out.println("Ячейка занята, введите другую");
            }
        }
    }

    private static boolean blockUserTurn(char[][] matrix){
        Random rand = new Random();
        int[] winOptions = getWinOptions(matrix, getUserSymbol());

        for (int i = 0; i < winOptions.length; i++){ //Блокируем ходы пользователя у которых остался один шаг
            if (winOptions[i] == getLength() - 1){
                if (doBlockUserTurn(matrix, i)){
                    return true;
                }
            }
        }
        for (int i = 0; i < winOptions.length; i++){ //Блокируем ходы пользователя у которых осталось два шага с вероятностью 50%
            if (winOptions[i] == getLength() - 2 && rand.nextBoolean()){
                if (doBlockUserTurn(matrix, i)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean doBlockUserTurn(char[][] matrix, int i){
        if (i == 0){ //Проверяем главную диагоняль
            for (int j = 0; j < matrix.length; j++){ //Ищем свободную ячейку
                if (checkAvailableCell(j, j, matrix)){
                    matrix[j][j] = getAISymbol();
                    return true;
                }
            }
        }
        else if (i == 1){ //Проверяем обратную диагоняль
            for (int j = 0; j < matrix.length; j++){//Ищем свободную ячейку
                if (checkAvailableCell(j, matrix.length - j - 1, matrix)){
                    matrix[j][matrix.length - j - 1] = getAISymbol();
                    return true;
                }
            }
        }
        else if (i < 2 + matrix.length){ //Строки
            for (int j = 0; j < matrix[i - 2].length; j++){//Ищем свободную ячейку
                if (checkAvailableCell(j,i - 2, matrix)){
                    matrix[i - 2][j] = getAISymbol();
                    return true;
                }
            }
        }
        else{
            for (int j = 0; j < matrix.length; j++){ //Столбцы
                if (checkAvailableCell(i - 2 - matrix.length, j, matrix)){//Ищем свободную ячейку
                    matrix[j][i - 2 - matrix.length] = getAISymbol();
                    return true;
                }
            }
        }
        return false;
    }

    private static void doAITurn(char[][] matrix){
        if (blockUserTurn(matrix)){ //Блокировка пользовательского хода
            return;
        }

        Random rand = new Random();
        while (true){
            int x = rand.nextInt(getLength());
            int y = rand.nextInt(getLength());
            if (checkAvailableCell(x, y, matrix)){
                matrix[y][x] = getAISymbol();
                break;
            }
        }
    }

    private static boolean checkAvailableCell(char[][] matrix){
        for (char[] row: matrix){
            for (char item: row){
                if (item == getNeutralSymbol()){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkGameFinish(char[][] matrix, char symbol){

        if (checkWinSituation(matrix, symbol)){
            System.out.printf("Победил %s %n", symbol == getUserSymbol() ? "пользователь" : "компьютер");
            return true;
        }

        if (!checkAvailableCell(matrix)){
            System.out.println("Не осталось свободных ячеек. Ничья");
            return true;
        }
        return false;
    }

    private static boolean checkWinSituation(char[][] matrix, char symbol){
        int[] winOptions = getWinOptions(matrix, symbol);

        return Arrays.stream(winOptions).anyMatch(x -> x == matrix.length);
    }

    private static int[] getWinOptions(char[][] matrix, char symbol){
        int[] winOptions = new int[(matrix.length * 2) + 2];
        for (int i = 0; i < matrix.length; i++){
            if (matrix[i][i] == symbol){
                winOptions[0] ++;
            }
            if (matrix[i][matrix.length - i - 1] == symbol){
                winOptions[1] ++;
            }
            for (int j = 0; j < matrix.length; j++){
                if (matrix[i][j] == symbol){
                    winOptions[i + 2] ++;
                }
                if (matrix[j][i] == symbol){
                    winOptions[i + 2 + matrix.length] ++;
                }
            }
        }
        return winOptions;
    }
}
