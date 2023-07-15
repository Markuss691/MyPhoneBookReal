import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Contact implements Comparable<Contact> {

    private String name;
    private String surname;
    private String number;//+994519999902
    private int age;
    private boolean deleteMark;

    public Contact(String name, String surname, String number, int age) {
        this.name = capitalizedWord(name);
        this.surname = capitalizedWord(surname);
        this.number = number;
        this.age = age;
        this.deleteMark = false;//убрал. стал сразу удалять
    }

    private String capitalizedWord(String word){
        word = word.trim();
        word = word.substring(0, 1).toUpperCase() + word.substring(1, word.length()).toLowerCase();
        return word;
    }
    public Contact() {
    }
    //compareTo Для сортировки по Name
    public int compareTo(Contact o) {
        return name.compareTo(o.name);
    }

    public void setDeleteMark(boolean deleteMark) {
        this.deleteMark = deleteMark;
    }

    //    public int compareToName(Contact o) {
//        return -name.compareTo(o.name);
//    }
//    public int compareTo(Contact o, int sortField, int sortDirection) {
//        if(sortField == 1){
//            if(sortDirection ==2) {
//                return -name.compareTo(o.name);
//            } else{
//                return name.compareTo(o.name);
//            }
//        }else{
//            if(sortDirection ==2) {
//                return -surname.compareTo(o.name);
//            } else{
//                return surname.compareTo(o.name);
//            }
//
//        }
//    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public String getNumber() {
        return number;
    }

    public int getAge() {
        return age;
    }

    public boolean getDeleteMark() {
        return deleteMark;
    }

    public String toString(){
        return this.name+ " " + this.surname + " " + this.number + " " + this.age;
    }

}
