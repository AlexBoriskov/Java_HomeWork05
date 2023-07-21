import java.util.*;

public class phone_book {
/*Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут повторяющиеся имена
с разными телефонами, их необходимо считать, как одного человека с разными телефонами. 
Вывод должен быть отсортирован по убыванию числа телефонов.*/ 
public static void main(String[] args) {
    boolean examination = true;
    Map <Object, List<Object>> phone_numbers = new HashMap<>();
    Scanner iScanner = new Scanner(System.in);
    String choose;

    while (examination) {
        System.out.println();
        System.out.println("ТЕЛЕФОННАЯ КНИГА");
        System.out.println();
        System.out.println("1. Просмотр телефонной книги");
        System.out.println("2. Добавление нового контакта");
        System.out.println("3. Удаление контакта");
        System.out.println("4. Поиск контакта по имени");
        System.out.println("5. Выход");

        System.out.println();
        System.out.println("Введите команду:");
        choose = iScanner.nextLine();

        switch (choose){
            case "1": {
                List<Map.Entry<Object, List<Object>>> all_contact = new ArrayList<>(phone_numbers.entrySet());
                Collections.sort(all_contact, new Comparator<Map.Entry<Object,List<Object>>>(){
                    public int compare (Map.Entry<Object, List<Object>> contact1, Map.Entry<Object, List<Object>> contact2){
                    return Integer.compare(contact2.getValue().size(), contact1.getValue().size());
                }
            });        

                for (Map.Entry<Object,List<Object>> el: all_contact){
                    Object key = el.getKey();
                    List <Object> values = el.getValue();
                    System.out.println(key + ": " + values);
                }
                break;
            }
            case "2": {
                System.out.println("Введите имя контакта");
                Object name = iScanner.nextLine();
                System.out.println("Введите телефон контакта");
                Object phone = iScanner.nextLine();
                if (phone_numbers.containsKey(name)){
                    List <Object> values = phone_numbers.get(name);
                    values.add(phone);
                }
                else {
                    List <Object> values = new ArrayList<>();
                    values.add(phone);
                    phone_numbers.put(name,values);
                }
                break;
            }
            case "3": {
                System.out.println("Введите имя для удаления");
                Object name = iScanner.nextLine();
                phone_numbers.remove(name);
                break;
            }
            case "4": {
                System.out.println("Введите имя для поиска");
                Object name = iScanner.nextLine();
                if (phone_numbers.containsKey(name)) System.out.println(phone_numbers.get(name));
                else System.out.println("Нет такого контакта!");
                break;
            }
            case "5": {
                examination = false;
                System.out.println("До свидание!");
                break;
            }

        }
    }
    iScanner.close();
}
}
