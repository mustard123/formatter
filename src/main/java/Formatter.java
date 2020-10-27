import java.util.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


/**
 * The class Formatter formats Input text to the desired format and prints it out .
 */


public class Formatter {

    private boolean isRawFormatter;
    private int fixLength;
    private LinkedHashMap<Integer, String> dictionary;


    public Formatter() {
        isRawFormatter = true;


    }

    public boolean isRawFormatter() {
        return isRawFormatter;
    }


    public void setFormatFix(int fixLength) {
        isRawFormatter = false;
        this.fixLength = fixLength;

    }

    public void setFormatRaw() {
        isRawFormatter = true;
    }

    public void print(LinkedHashMap<Integer, String> dictionary) {
        if (isRawFormatter) {
            printRaw(dictionary);
        } else {
            printFix(dictionary);
        }

    }

    private void printRaw(LinkedHashMap<Integer, String> dictionary) {
        System.out.println("printingRaw:");
        for (Map.Entry<Integer, String> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());

        }
    }

    private void printFix(LinkedHashMap<Integer, String> dictionary) {
        System.out.println("printing fix with column length " + this.fixLength +":");
        // append all entries in the LinkedHashMap into a single String
        String fullText = "";
        for (Map.Entry<Integer, String> entry : dictionary.entrySet()) {
            fullText += entry.getValue() + " ";
        }

        String sub;
        String remainder = fullText;

        // only do this if the text does not fit inside the specified column length (trim first because whitespace can
        // be ignored)
        while (remainder.trim().length() > fixLength) {

                // split the string into a sub and a remainder part
                sub = remainder.substring(0, fixLength);
                remainder = remainder.substring(fixLength);

                // move all whitespace at the beginning of remainder to end of sub. --> remainder never starts with
                //  whitespace
                // e.g :
                // sub: Hallo_
                // remainder: ___Jason
                // after while loop is the following:
                // sub: Hallo____
                // remainder: Jason
                while (remainder.charAt(0) == ' ') {
                    sub = sub + ' ';
                    remainder = remainder.substring(1);
                }

            /**
             * This code here would do the same as the one above, but not as elegant / readable
             */
// ---------------------------------------------------------------------------------------------
//                String remainderCopy = remainder;
//                for (int i = 0; i < remainderCopy.length(); i++) {
//                    if (remainderCopy.charAt(i) == ' ') {
//                        sub = sub + ' ';
//                        remainder = remainder.substring(1);
//                    } else {
//                        break;
//                    }
//                }
// ---------------------------------------------------------------------------------------------------

                // if the last char of sub and the first char of remainder is not a space character
                // it means we split in the middle of a word
                // e.g:
                // sub: Virtute pr
                // remainder: aecunt
                //
                if (sub.charAt(sub.length() - 1) != ' ' && remainder.charAt(0) != ' ') {

                    int indexOfLastSpace = sub.lastIndexOf(' ');
                    // only do this if there is a spac in "sub"
                    // e.g sub: "Virtute pr",
                    // if the sub was: "Vir" and remainder was "tute" indexOfLastSpace would be -1
                    // because the is no space " " in "Vir" and we would get an error trying to extract a partial word
                    if (indexOfLastSpace >= 0) {
                        // in the example above pr is the partial word
                        String partialWord = sub.substring(indexOfLastSpace + 1);
                        // praecunt bla.. =    pr    +  aecunt bla..
                        remainder = partialWord + remainder;
                        // sub is now only Virtute and remainder is: praecunt bla...
                        sub = sub.substring(0, indexOfLastSpace);
                    }

                }
                System.out.println(sub);
        }
        // if the remainder fits inside the column length, print it out
        System.out.println(remainder);

    }


}