import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Задание
//
//        Реализуйте структуру телефонной книги с помощью HashMap.
//        Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
//        их необходимо считать, как одного человека с разными телефонами.
//        Вывод должен быть отсортирован по убыванию числа телефонов.

        HashMap<String, String> phoneBook = new HashMap<>();
        addContact(phoneBook, "Tom", "+79145423000");
        addContact(phoneBook, "Andy", "+79145423031");
        addContact(phoneBook, "Andy", "+79145423042");
        addContact(phoneBook, "Andy", "+79145423053");
        addContact(phoneBook, "Andy", "+79145423064");
        addContact(phoneBook, "Ben", "+79145423020");
        addContact(phoneBook, "Andy", "+79145423075");
        addContact(phoneBook, "Ben", "+79145423011");
        getSortList(phoneBook).forEach(n ->  System.out.println(n));
    }


    public static HashMap<String, String> addContact(HashMap<String, String> dict, String name, String phone){
        dict.compute(name, (k, v) -> v == null ? phone : v + ", " + phone);
        return dict;
    }


    public static ArrayList<Map.Entry<String, String>> getSortList(HashMap<String, String> book) {
        ArrayList<Map.Entry<String, String>> list = new ArrayList<>(book.entrySet());

        list.sort((o1, o2) -> o2.getValue().length() - o1.getValue().length());
        return list;
    }
}
