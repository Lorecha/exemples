import java.util.Scanner;

public class RenverseStringClassique {
    public static void main(String[] args) {
        System.out.println("Ecrivez une phrase  :");
        Scanner sc = new Scanner(System.in);
        String monString = sc.nextLine();
        String reverseString = recursiveSwap(monString);

        System.out.println(reverseString);
    }

    static String recursiveSwap(String str)
    {
        if ((null == str) || (str.length() <= 1))
        {
            return str;
        }
        return recursiveSwap(str.substring(1)) + str.charAt(0);
    }

    }
