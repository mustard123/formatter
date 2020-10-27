import java.text.Format;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        LinkedHashMap<Integer, String> dictionary = new LinkedHashMap<>();
        dictionary.put(1,"Virtute praecedunt, quod fere cotidianis proeliis cum");
        dictionary.put(2,"Germanis contendunt, septentr ionesimmensoslongusw");
        dictionary.put(3, "ordos.");

        Formatter formatter = new Formatter();
        formatter.print(dictionary);
        System.out.println("--------------------");
        formatter.setFormatFix(20);
        formatter.print(dictionary);
        System.out.println("--------------------");
        formatter.setFormatFix(15);
        formatter.print(dictionary);
        System.out.println("--------------------");
        formatter.setFormatFix(2);
        formatter.print(dictionary);
        System.out.println("--------------------");

        /*LinkedHashMap<Integer, String> mymap = new LinkedHashMap<>();

        while (true){

            Scanner scanner = new Scanner(System.in);
            System.out.println("what do you want to do?");
            String input = scanner.nextLine();
            if (input.equals("ADD")) {
                System.out.println("enter your line:");
                String absatz = scanner.nextLine();
                System.out.println("your absatz is: " + absatz);
                if (mymap.size() > 0){
                    System.out.println("lengt is: " +  mymap.size());
                    mymap.put(mymap.size() + 1, absatz);
                }
                else {
                    mymap.put(1, absatz);
                }


            }
            if (input.equals("ABORT")){
                break;
            }
        }*/


    }
}