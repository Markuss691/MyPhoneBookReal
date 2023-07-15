import java.util.ArrayList;

public class inputValueValidation {
    private String numericalValue;
    //public arr [] ValidNumericValues;
    //private ArrayList<> ValidNumericValues;
    //private ArrayList [] ValidNumericValues;
    private ArrayList <Integer> ValidNumericValues;
    //ArrayList<String> people = new ArrayList<String>()
    private int CurrentValueInt;
    private String stringValue;//+994519999902
    private int age;

    public inputValueValidation() {

    }

    //public inputValueValidation(String numericalValue) {
//        this.numericalValue = numericalValue;
//    }

    public static boolean compareInt(ArrayList <Integer>  ValidNumericValues, int CurrentValueInt) {
        if (ValidNumericValues.contains(CurrentValueInt) == true)
            return true;
        else
            System.out.println("Введено некорректное числовое значение \n");
            return false;
    }
    //List<String> list = new ArrayList<>();
}
