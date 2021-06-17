import java.util.Scanner;

public class ConcatenationString {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        System.out.println("Ecrivez un mot:");
        Scanner sc = new Scanner(System.in);
        String one = sc.next();
        System.out.println("Ecrivez un deuxiemme  mot:");
        String two = sc.next();
        System.out.println("Ecrivez un troisieme  mot:");
        String three = sc.next();

        buffer.append(one)
                .append(two)
                .append(three)
                .append(" et")
                .append("bla")
                .append("bla")
                .append("bla");

        System.out.println(buffer.toString());
    }

}
