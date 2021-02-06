package phoneDictionary;

import java.util.ArrayList;
import java.util.Arrays;

public class DictionaryItem implements Comparable { //Не понадобилось
    private final String surname;
    private final ArrayList<String> phones;

    public DictionaryItem(String surname, String phone){
        this(surname, new String[]{phone});
    }

    public DictionaryItem(String surname, String[] phones){
        this.surname = surname;
        this.phones = new ArrayList<>(Arrays.asList(phones));
    }

    public String getSurname() {
        return surname;
    }

    public String[] getPhones() {
        return (String[])phones.toArray();
    }

    public void addPhone(String phone){
        phones.add(phone);
    }

    @Override
    public int hashCode(){
        return surname.hashCode();
    }

    @Override
    public int compareTo (Object o){
        return surname.compareTo(((DictionaryItem) o ).getSurname());
    }


}
