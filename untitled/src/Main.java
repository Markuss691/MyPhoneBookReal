import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

//    ЭКЗАМЕН. ПРАКТИЧЕСКОЕ ЗАДАНИЕ.
//    Название программы: Телефонная книга
//    Техническое задание:
//        + Контакт должен содержать: имя, фамилию, телефонный номер******
//        + Для работы с контактами у пользователя должны быть следующие возможности:
//        + добавление контакта в телефонную книгу ****************
//    + просмотр данных каждого контакта в отдельности********************
//        + удаление контакта из телефонной книги (с подтверждением данного действия)***************
//    + редактирование всех данных контакта*************************
//        + сортировка списка контактов (A-Z и Z-A по имени)**********
//    + поиск контактов по номеру, имени и фамилии ********************
//    + при поиске допускается использование символов ? и */**************************
//    + запрос вида M?ke должен находить контакт Mike ***********************
//    + запрос вида Joh* должен находить контакты вида John и Johnson ************************
//    + Вывод списка контактов***************
//    + Сохранение контактов в файл***********
//    + Загрузка контактов из файла при запуске программы***************

    public static void startMenu(){

        System.out.println("""
                    
                    1 - Добавить контакт
                    2 - Удалить контакт
                    3 - Изменить контакт
                    4 - Просмотр данных контакта
                    5 - Поиск контакта
                    6 - Сортировка контактов
                    7 - Список контактов
                    8 - Вызов контакта   
                    0 - Выход
                    """);
    }
    public static void addContact() throws Exception {
        try {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя     : ");
        String name = scanner.next();
        System.out.print("Введите фамилию : ");
        String surname = scanner.next();
        System.out.print("Введите номер   : ");
        String number = scanner.next();
        System.out.print("Введите возраст : ");
        int age = scanner.nextInt();
//        String name = "name";
//
//        String surname = "surname";
//        String number =  "number";
//        int age = 12;
        Contact contact = new Contact(name, surname, number, age);
        PhoneBook.addContact(contact);
        } catch (Exception ex){
            System.out.println("Введено некорректное значение");
        }
    }

    public static void sortContacts() throws Exception {

        Scanner scannerS = new Scanner(System.in);

        System.out.println("Направление сортировки");
        System.out.println("""                   
                    1 - Возрастание
                    2 - Убывание                    
                    """);
        scannerS = new Scanner(System.in);
        ArrayList<Integer> ValueValid = new ArrayList<Integer>();
        ValueValid.add(1);
        ValueValid.add(2);
        try {
        int sortDirection = scannerS.nextInt();
            if(inputValueValidation.compareInt(ValueValid,sortDirection)==true) {
                PhoneBook.sortContacts(sortDirection);
            }
        } catch (Exception ex){
            System.out.println("Введено некорректное значение");
        }
    }

    public static void searchContacts() throws Exception {

        Scanner scannerS = new Scanner(System.in);

        System.out.println("Укажите поле для поиска");
        System.out.println("""                   
                    1 - Имя
                    2 - Фамилия
                    3 - Номер                    
                    """);
        scannerS = new Scanner(System.in);
        ArrayList<Integer> ValueValid = new ArrayList<Integer>();
        ValueValid.add(1);
        ValueValid.add(2);
        ValueValid.add(3);

        try {
            int searchField = scannerS.nextInt();

//            if(inputValueValidation.compareInt(ValueValid,searchField)==false){
//                throw new Exception();
//            }
            if(inputValueValidation.compareInt(ValueValid,searchField)==true) {

                System.out.println("Укажите значение для поиска");
                System.out.println("Допускается использование символов ? и *");
                String value = scannerS.next();
                PhoneBook.searchContacts(searchField, value);
            }
        } catch (Exception ex){
            System.out.println("Введено некорректное значение");
        }

    }

    public static void main(String[] args) throws Exception {


        PhoneBook phoneBook = new PhoneBook();
        PhoneBook.startupActions();
        //startMenu();
        inputValueValidation inputValueValid = new inputValueValidation();

        ArrayList<Integer> ValueValid = new ArrayList<Integer>();
        for (int i = 0; i < menuOperations.values().length; i++) {
            ValueValid.add(i);
        }
        while(true){
            startMenu();
            System.out.println("Выберите команду :");
            Scanner scanner = new Scanner(System.in);
            int select = 1;
            try {
                select = scanner.nextInt();
            }catch (Exception e) {
                System.out.println("Введено нечисловое значение");
                continue;
            }


            if(inputValueValidation.compareInt(ValueValid,select)==false){
                continue;
            }

            if (menuOperations.getEnumByCode(select) == menuOperations.add){

                addContact();
            } else if (menuOperations.getEnumByCode(select) == menuOperations.del){

                PhoneBook.delContact();
            } else if (menuOperations.getEnumByCode(select) == menuOperations.edit){

                PhoneBook.editContact();
            }else if (menuOperations.getEnumByCode(select) == menuOperations.view){

                PhoneBook.viewContact();
            } else if (menuOperations.getEnumByCode(select) == menuOperations.sort){

                sortContacts();}
            else if (menuOperations.getEnumByCode(select) == menuOperations.search){

                searchContacts();
            } else if (menuOperations.getEnumByCode(select) == menuOperations.list){

                PhoneBook.listContacts(false);

            } else if (menuOperations.getEnumByCode(select) == menuOperations.call){

                PhoneBook.CallContact();

            } else if (menuOperations.getEnumByCode(select) == menuOperations.exit){

                PhoneBook.exitProgram();
                break;
            }
            //break;
        }

    }
}