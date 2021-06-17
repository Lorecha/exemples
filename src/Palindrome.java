import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args)
    {


     System.out.println("Ecrivez un mot, on vas vérifier s'il est un palindrome :");
        Scanner sc=new Scanner(System.in);
        String originalString = sc.next();

        StringBuilder strBuilder = new StringBuilder(originalString);
        String reverseString = strBuilder.reverse().toString();


        boolean isPalindrame = originalString.equals(reverseString);
        if (originalString.equals(reverseString))
        {
            System.out.println("Le mot "+originalString+" est un palindrome");
        }  //true}
            else
            {
                System.out.println("Le mot "+originalString+" n'est pas un palindrome");
            }
    }
}

