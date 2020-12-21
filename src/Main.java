public class Main {

    public static void main(String[] args){
        /*
         * Задание 2
         */
        byte byteValue = 2;
        System.out.println("byte значение: " + byteValue);
        short shortValue = 356;
        System.out.println("short значение: " + shortValue);
        int intValue = 2142143;
        System.out.println("int значение: " + intValue);
        long longValue = 4124324321L;
        System.out.println("long значение: " + longValue);
        float floatValue = 5.01F;
        System.out.println("float значение: " + floatValue);
        double doubleValue = 6.43;
        System.out.println("double значение: " + doubleValue);
        boolean booleanValue = true;
        System.out.println("Логическое значение: " + booleanValue);
        char charValue = 'V';
        System.out.println("char значение: " + charValue);
        String stringValue = "Это строка";
        System.out.println("String значение: " + stringValue);

        /*
         * Задание 3
         */
        float af = 1f;
        float bf = 45f;
        float cf = 10f;
        float df = 2f;
        float calculatedValue = getCalculatedValue(af, bf, cf, df);
        System.out.println("вычесленное значение " + af + " * (" + bf + " + (" + cf +" / "+ df +")) = " + calculatedValue);

        /*
         * Задание 4
         */
        int a = 8;
        int b = 6;
        boolean result = isSumBiggerTenLessTwenty(a, b);
        System.out.println("Сумма " + a + " + " + b + " больше 10 и меньше 20? " + result);

        /*
         * Задание 5
         */
        int a4 = 0;
        printIsValuePositive(a4);

        /*
         * Задание 7
         */
        String name = "Том";
        printHello(name);

        /*
         * Задание 8
         */
        int year = 2020;
        boolean leapYear = isLeapYear(year);
        System.out.println("Год " + year + " високосный? " + leapYear);
    }

    /*
     * Задание 3
     */
    private static float getCalculatedValue(float a, float b, float c, float d){
        if (d == 0)
            return 0;
        return a * (b + (c / d));
    }

    /*
     * Задание 4
     */
    private static boolean isSumBiggerTenLessTwenty(int a, int b){
        int sum = a + b;
        return sum > 10 && sum <= 20;
    }

    /*
     * Задание 5
     */
    private static void printIsValuePositive(int a){
        if (!isValuePositive(a)){
            System.out.println("Число " + a + " положительное или равно нулю");
        }
        else {
            System.out.println("Число " + a + " отрицательное");
        }
    }

    /*
     * Задание 6
     */
    private static boolean isValuePositive(int a){
        return a < 0;
    }

    /*
     * Задание 7
     */
    private static void printHello(String name){
        System.out.println("Привет, " + name + "!");
    }

    /*
     * Задание 8
     */
    private static boolean isLeapYear(int year){
        return (year % 400) == 0 || ((year % 100) != 0 && (year % 4) == 0);
    }

}
