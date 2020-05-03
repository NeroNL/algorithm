package coderforce;

import java.util.Scanner;

public class CF1097c {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.valueOf(scanner.next());
        String[] sequences = new String[len];

        for (int i = 0; i < len; ++i) {
            sequences[i] = scanner.next();
        }
        scanner.close();


    }
}
