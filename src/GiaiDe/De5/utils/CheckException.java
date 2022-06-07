package GiaiDe.De5.utils;

import java.util.Scanner;

public class CheckException {
    private static Scanner sc = new Scanner(System.in);

    public static int checkParseInteger() {
        int value;
        while (true) {
            try {
                value = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.print("Enter again: ");
            }
        }
        return value;
    }
}
