import java.util.Comparator;

public class ComparatorByConditionDesc  implements Comparator<Contact> {

    public int compare(Contact o1, Contact o2) {
        return - o1.getName().compareTo(o2.getName());
    }
}
