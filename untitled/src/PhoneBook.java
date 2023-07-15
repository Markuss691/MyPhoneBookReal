import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {

   // private List<Contact> contacts;
   public static List<Contact> contacts;

    {
        //contacts = new ArrayList<>();
       // readFile("listOfPersons.txt");
        //contacts.add(new Contact("Farid","Abdullayev","+994519999902",27));
    }
    public static void startupActions(){

        contacts = new ArrayList<>();
        fillingContactListFromFile("listOfPersons.txt", contacts);


    }


    public static void CallContact(){
        listContacts(true);
        Contact CurrentContact = getCurrentContact();
        int min = 1;
        int max = 3;
        int fD = new Random().nextInt(max - min) + min;
        if(fD == 1){
            System.out.println("Нет денег на счете");
        } else if (fD == 2) {
            System.out.println("Абонент вне зоны доступа");
        } else if (fD == 3) {
            System.out.println("Абонент не алё");
        }
    }


    public static void searchContacts(int searchField, String value){
        //+ запрос вида M?ke должен находить контакт Mike
//    + запрос вида Joh* должен находить контакты вида John и Johnson
        String classField = "";
        boolean contactFound = false;
        value = value.toLowerCase();

        String pattern = formPattern(value);
        Pattern r = Pattern.compile(pattern);

        for (Contact contact : contacts) {

            if(searchField == 1){
                classField = contact.getName();
            } else if (searchField == 2) {
                classField = contact.getSurname();
            } else if (searchField == 3) {
                classField = contact.getNumber();
            }

            if (value.indexOf("?") !=-1 || value.indexOf("*") !=-1){


                Matcher m = r.matcher(classField.toLowerCase());
                if (m.find( )) {
                    System.out.println("Найден контакт: " + contact);
                    contactFound = true;
//                    System.out.println("Found value: " + m.group(0) );
//                    System.out.println("Found value: " + m.group(1) );
//                    System.out.println("Found value: " + m.group(2) );
                }else {
                 //   System.out.println("Не совпало");
                }

            }
            else if(classField.equals(value)){
               System.out.println("Найден контакт: " + contact);
                contactFound = true;
           }else {
                //System.out.println("Контакты не найдены");
            }

        }
        if(contactFound == false){
            System.out.println("Контакты не найдены");
        }
    }

    public static String  formPattern(String value){
        if (value.indexOf("?") ==-1 && value.indexOf("*") ==-1){
            return "";
        }
        String patternValue = "";
        for (int i = 0; i < value.length(); i++) {
            if(value.charAt(i)=='?'){
                patternValue += "[A-я]";
            } else if (value.charAt(i)=='*') {
                patternValue += ".{0,}";
                //^начало строки $ конец строки
            }else {
                patternValue +=value.charAt(i);
             //   patternValue +="\\D";
            }

        }
       // String[] parts;
        if (value.indexOf("*") !=-1){
//            value = value.replace('*', '/');
//            parts = value.split("/");
//            if(parts.length>)
            patternValue = "^"+patternValue+"$";
        }
        return patternValue;
    }

    public static void  sortContacts(int sortDirection){

        if(sortDirection==1) {
            Collections.sort(contacts, new ComparatorByCondition());
        }else {
            Collections.sort(contacts, new ComparatorByConditionDesc());
        }

    }

    public static void viewContact(){

        listContacts(true);
        Contact CurrentContact = getCurrentContact();
        System.out.print("Имя :" + CurrentContact.getName()+ ", ");
        System.out.print("Фамилия :" + CurrentContact.getSurname()+ ", ");
        System.out.print("Номер :" + CurrentContact.getNumber()+ ", ");
        System.out.println("Возраст :" + CurrentContact.getAge()+ ".");

    }
    public static Contact getCurrentContact(){
        System.out.println("Укажите номер контакта");
        Scanner sc = new Scanner(System.in);
        int contactPos = sc.nextInt();
        return contacts.get(contactPos-1);
    }

    public static void editContact(){

        listContacts(true);
        Contact CurrentContact = getCurrentContact();
        System.out.println("Значение какого поля хотите поменять?");
        System.out.println("""                   
                    1 - Имя
                    2 - Фамилия
                    3 - Номер                    
                    """);
        Scanner scannerS = new Scanner(System.in);
        scannerS = new Scanner(System.in);
        int searchField = scannerS.nextInt();
        System.out.println("Введите новое значение");
        if (searchField == 1){
            CurrentContact.setName(scannerS.next());
        } else if (searchField == 2) {
            CurrentContact.setSurname(scannerS.next());
        } else if (searchField == 3) {
            CurrentContact.setNumber(scannerS.next());
        }

    }
    public static void delContact(){

        listContacts(true);
        Contact CurrentContact = getCurrentContact();
        //CurrentContact.setDeleteMark(true);
        if (actionConfirm("Уверены, что хотите удалить контакт?  ", 1,2) == true){
            contacts.remove(CurrentContact);
        }
    }

    public static boolean actionConfirm(String questionText,int PositiveResponseCode, int NegativeResponseCode){
        System.out.print(questionText);
        System.out.println(PositiveResponseCode + " -да/"+ NegativeResponseCode+" -нет");
        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();
        if (answer == PositiveResponseCode){

            return true;
        }
        return false;
    }
    public static void fillingContactListFromFile(String filePuth, List contacts){
        try {
            FileReader reader = new FileReader(filePuth);
            BufferedReader breader = new BufferedReader(reader);
            String textLine;
            Integer i1;
            while((textLine = breader.readLine()) != null ){
             //   System.out.println(textLine);
                String [] arrTextLine = textLine.split("/");
               // int b2 = int.valueOf(arrTextLine[3]);

                i1 = new Integer(arrTextLine[3]);
                Contact contact = new Contact(arrTextLine[0], arrTextLine[1], arrTextLine[2], i1);
                contacts.add(contact);
            }
        } catch (Exception e){
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
        }

    }


    public static void exitProgram(){
        writeListToFile();
    }

    private static void fileСleaning(String filePuth){
        try (BufferedWriter bf = Files.newBufferedWriter(Path.of(filePuth),
            StandardOpenOption.TRUNCATE_EXISTING)) {
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    private static void writeListToFile(){
        String filePuth = "listOfPersons.txt";

        fileСleaning(filePuth);

        for (int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i).getDeleteMark()!= true) {
                //    System.out.println(contacts.get(i));
                writingToFile(filePuth, contacts.get(i));
            }
        };

    }

    private static void writingToFile(String filePuth, Contact contact ){

        try(FileWriter writer = new FileWriter(filePuth, true))
        {
            String sep = "/";

            writer.write(contact.getName() + sep + contact.getSurname() + sep +  contact.getNumber() + sep +  contact.getAge()+"\n");

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }


    }


    public static void writingContactToFile(String filePuth, Contact contact ){

        try(FileWriter writer = new FileWriter(filePuth, true))
        {
            String sep = "/";

            writer.write(contact.getName() + sep + contact.getSurname() + sep +  contact.getNumber() + sep +  contact.getAge()+" \n ");

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }


    }

    public static void addContact(Contact contact) throws Exception {
        //System.out.println("1");
        if (contacts.contains(contact)){
            throw new Exception("Такой контакт уже существует");
        }
        contacts.add(contact);

    }
    public static void listContacts(boolean ShowSequenceNumber) {
        for (int i = 0; i < contacts.size(); i++) {
            if(ShowSequenceNumber == true){
                System.out.print((i+1)+". ");
            }
            if(contacts.get(i).getDeleteMark()!= true) {
                System.out.println(contacts.get(i));
            }
        };

    }


}
