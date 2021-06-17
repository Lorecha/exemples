
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class occurence {
    public static void main(String[] args) {
        System.out.println("Ecrivez une phrase  :");
        Scanner sc = new Scanner(System.in);
        String monstring = sc.nextLine();
        HashMap<Character, Integer> occurancesMap = new HashMap<Character, Integer>();

        char[] strArray = monstring.toCharArray();
        char a=' ';
        for (char c : strArray)
            {

            if (Character.compare(c,a)!=0)
            {
            if (occurancesMap.containsKey(c))
                {
                    occurancesMap.put(c, occurancesMap.get(c)+1);
                }
            else
                {
                    occurancesMap.put(c, 1);
                }
                }


            }

        Map<Character, Integer> result2 = new LinkedHashMap<>();
       occurancesMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));
        System.out.println("Le résultat par lettre");
        System.out.println(result2);
        Map<Character, Integer> result3 = new LinkedHashMap<>();
       occurancesMap.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> result3.put(x.getKey(), x.getValue()));
        System.out.println("Le résultat par nombre d'apparition");
        System.out.println(result3);
    }

}
