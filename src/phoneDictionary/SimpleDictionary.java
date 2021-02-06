package phoneDictionary;

import java.util.*;

public class SimpleDictionary implements PhoneDictionary{
    private final TreeMap<String, LinkedHashSet<String>> items;

    public SimpleDictionary(){
        items = new TreeMap<>();
    }

    @Override
    public void add(String surname, String phone){
        if (items.containsKey(surname)){
            items.get(surname).add(phone);
        }
        else{
            LinkedHashSet<String> phones = new LinkedHashSet<>();
            phones.add(phone);
            items.put(surname, phones);
        }
    }

    @Override
    public String get(String surname){
        if (items.containsKey(surname)){
            LinkedHashSet<String> item = items.get(surname);

            if (item.size() == 1){

            }

            StringBuilder sb = new StringBuilder();
            for (String phone: item) {
                if (sb.isEmpty()){
                    if (item.size() == 1){
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
            return sb.toString();

        }
        else{
            return String.format("%s не имеет номеров в справочнике", surname);
        }
    }


}
