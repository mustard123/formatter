import java.util.Map;


/**
 * The class Formatter formats Input text to the desired format.
 */


public class FormatterCpy {

    private boolean isRawFormatter;
    private int fixLength;
    private Map<Integer, String> dictionary;


    public FormatterCpy() {
        isRawFormatter = true;


    }

    public void isRawFormatter(String paragraphs) {
    }


    public void setFormatFix(int fixLength) {
        isRawFormatter = false;
        this.fixLength = fixLength;

    }

    public void setFormatRaw() {
        isRawFormatter = true;
    }

    public void print(Map<Integer, String> dictionary) {
        if (isRawFormatter) {
            printRaw(dictionary);
        } else {
            printFix(dictionary);
        }

    }

    private void printRaw(Map<Integer, String> dictionary) {
        System.out.println("printingRaw");
        for (Map.Entry<Integer, String> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());

        }
    }

    private void printFix(Map<Integer, String> dictionary) {
        String fullText = "";
        for (Map.Entry<Integer, String> entry : dictionary.entrySet()) {
            fullText += entry.getValue() + " ";
        }

        String sub;
        String remainder = fullText;

        if (remainder.trim().length() > fixLength) {
            sub = remainder.substring(0, fixLength);
            remainder = remainder.substring(fixLength);

            if (remainder.charAt(0) == ' '){

                String remainderCopy = remainder;
                for (int i = 0; i < remainderCopy.length(); i++) {
                    if (remainderCopy.charAt(i) == ' ') {
                        sub = sub + ' ';
                        remainder = remainder.substring(1);
                    }
                    else {
                        break;
                    }
                }
            }
            if (sub.charAt(sub.length()-1) != ' ' &&  remainder.charAt(0) != ' '){

                int indexOfLastSpace = sub.lastIndexOf(' ');
                if (indexOfLastSpace >= 0){
                    String partialWord = sub.substring(indexOfLastSpace+1);
                    remainder = partialWord+ remainder;
                    sub = sub.substring(0, indexOfLastSpace );
                }


            }

            System.out.println(sub);

        }


        while (remainder.trim().length() > fixLength) {

                sub = remainder.substring(0, fixLength);
                remainder = remainder.substring(fixLength);

                if (remainder.charAt(0) == ' ') {

                    String remainderCopy = remainder;
                    for (int i = 0; i < remainderCopy.length(); i++) {
                        if (remainderCopy.charAt(i) == ' ') {
                            sub = sub + ' ';
                            remainder = remainder.substring(1);
                        } else {
                            break;
                        }
                    }
                }
                if (sub.charAt(sub.length() - 1) != ' ' && remainder.charAt(0) != ' ') {

                    int indexOfLastSpace = sub.lastIndexOf(' ');
                    if (indexOfLastSpace >= 0) {
                        String partialWord = sub.substring(indexOfLastSpace + 1);
                        remainder = partialWord + remainder;
                        sub = sub.substring(0, indexOfLastSpace);
                    }

                }
                System.out.println(sub);
        }
        System.out.println(remainder);

    }


}