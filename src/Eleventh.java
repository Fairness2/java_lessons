import helpers.Helpers;
import phoneDictionary.PhoneDictionary;
import phoneDictionary.SimpleDictionary;

import java.util.HashMap;

public class Eleventh {
    public static void main(String[] args) {
        doTask();
    }

    private static void doTask(){
        countWords(
                new String[]{"Один", "Два", "Три", "Четрые", "Пять", "Шесть", "Семь", "Восемь", "Девять", "Десять", "Три", "Три", "Три", "Шесть", "Восемь"}
        );
        System.out.println();
        System.out.println();
        System.out.println();
        workWithPhoneDictionary();
    }

    private static void countWords(String[] words){
        HashMap<String, Integer> wordsMap = new HashMap<>();

        for (String word: words) {
            wordsMap.merge(word, 1, Integer::sum);
        }

        System.out.println("Уникальные слвоа в массиве и их количество:");
        String[] plurWords = {"раз", "раз", "раза", "раз"};
        for (String word: wordsMap.keySet()) {
            System.out.printf("%s - %s %s%n", word, wordsMap.get(word), Helpers.pluralization(wordsMap.get(word), plurWords));
        }
    }

    private static void workWithPhoneDictionary(){
        String[][] phones = {
                {"Петров", "8 (924) 654-54-70"},
                {"Петров", "8 (924) 654-54-71"},
                {"Иванов", "8 (924) 654-54-72"},
                {"Елисеева", "8 (924) 654-54-73"},
                {"Артемьев", "8 (924) 654-54-74"},
                {"Петров", "8 (924) 654-54-75"},
                {"Елисеева", "8 (924) 654-54-76"},
        };
        PhoneDictionary dict = new SimpleDictionary();
        for (String[] phone: phones) {
            dict.add(phone[0], phone[1]);
        }

        System.out.println("Номера телефонов пользователей:");
        printPhones("Петров", dict.get("Петров"));
        printPhones("Елисеева", dict.get("Елисеева"));
        printPhones("Артемьев", dict.get("Артемьев"));
        printPhones("Несуществующий", dict.get("Несуществующий"));
    }

    private static void printPhones(String surname, String[] phones){
        StringBuilder sb = new StringBuilder();

        if (phones.length == 0) {
            System.out.printf("%s не имеет номеров в справочнике", surname);
        }

        for (String phone: phones) {
            if (sb.isEmpty()){
                if (phones.length == 1){
                    sb.append(String.format("Номер %s: %s", surname, phone));
                }
                else {
                    sb.append(String.format("Номера %s: %s", surname, phone));
                }
            }
            else {
                sb.append(String.format(", %s", phone));
            }
        }
        System.out.println(sb.toString());
    }

}
