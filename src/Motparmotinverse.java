import java.util.Scanner;

public class Motparmotinverse {
    public static void main(String[] args) {
        System.out.println("Ecrivez une phrase on vas la decomposer :");
        Scanner sc = new Scanner(System.in);
        String blogName = sc.nextLine();


        //spilt on white space
        String[] tableaustring = blogName.split(" ");

        //It will store reversed words
        StringBuffer finalString = new StringBuffer();

//Loop all words and reverse them
        for (String letableau: tableaustring) {
            String inverser = new StringBuffer(letableau).reverse().toString();
            finalString.append(inverser);
            finalString.append(" ");
        }

//Check final string
        System.out.println(finalString.toString());
    }
}

