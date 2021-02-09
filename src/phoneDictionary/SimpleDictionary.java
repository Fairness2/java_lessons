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
    public String[] get(String surname){
        if (items.containsKey(surname)){
            LinkedHashSet<String> item = items.get(surname);

            return item.toArray(new String[item.size()]);
        }
        else{
            return new String[0];
        }
    }


}
