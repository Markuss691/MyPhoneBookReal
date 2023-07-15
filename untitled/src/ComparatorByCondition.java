import java.util.Comparator;

public class ComparatorByCondition implements Comparator<Contact> {

    public int compare(Contact o1, Contact o2) {
        //return Integer.compare(o1.getAge(), o2.getAge());//это работает
        return o1.getSurname().compareTo(o2.getSurname());
    }
}


