package shawnFirstRound;

import java.util.*;

public class WhoHasntSignUp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        Set<String> names = new HashSet<>();
        Set<String> joins = new HashSet<>();
        for (int i = 0; i < num; ++i) {
            names.add(scanner.nextLine());
        }
        System.out.println(names);

        for (int i = 0; i < num-1; ++i) {
            joins.add(scanner.nextLine());
        }

        names.removeAll(joins);

        for (String name : names) {
            System.out.println(name);
        }
    }
}
