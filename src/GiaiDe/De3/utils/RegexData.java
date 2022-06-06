package GiaiDe.De3.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexData {

    static Scanner scanner = new Scanner(System.in);
    public static String regexStr(String temp, String regex, String error){
        boolean check = true;
        do {
            if(temp.matches(regex)){
                check = false;
            }else {
                System.out.println(error);
                temp = scanner.nextLine();
            }
        }while (check);
        return temp;
    }

    public static String regexAge(String temp, String regex){

        boolean check = true;
        while (check){
            try {
                if(Pattern.matches(regex, temp)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate age = LocalDate.parse(temp, formatter);
                    LocalDate now = LocalDate.now();
                    int current = Period.between(age, now).getYears();
                    if (current > 18) {
                        check = false;
                    } else {
                        throw new AgeException("Tuoi phai lon hon 18 ");
                    }
                }else {
                    throw  new AgeException("Dinh dang nhap vao ko dung");
                }
            }catch (AgeException e){
                System.out.println(e.getMessage());
                temp = scanner.nextLine();
            }
        } return temp;
    }
}
