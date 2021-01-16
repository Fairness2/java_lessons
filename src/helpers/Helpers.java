package helpers;

public class Helpers {

    public static String[] distanceWords = {"метров", "метр", "метра", "метров"};

    public static String pluralization(int count, String[] words){
        return pluralization(count, words, "ru");
    }

    public static String pluralization(int count, String[] words, String locale){
        int realCount = Math.abs(count);
        if (realCount == 0){
            return words[0];
        }
        if (!locale.equals("ru")){
            return realCount < 2 ? words[1] : words[2];
        }

        boolean endOnOne = realCount % 10.0 == 1;
        boolean teen = realCount > 10 && realCount < 20;
        if (endOnOne && !teen){
            return words[1];
        }
        if (!teen && realCount % 10.0 >= 2 && realCount % 10.0 <= 4){
            return words[2];
        }
        return realCount < 4 ? words[2] : words[3];
    }
}
