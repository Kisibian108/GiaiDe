package GiaiDe.De5.Controller;

import GiaiDe.De5.service.StudentImplement;
import GiaiDe.De5.service.TeacherImplement;
import GiaiDe.De5.utils.CheckException;
import java.util.Scanner;

public class PersonController {

    public static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
        System.out.println("QUAN LY HOC SINH VA GIAO VIEN");
        System.out.println("1. Student Management");
        System.out.println("2. Teacher Management");
        System.out.println("3. Exit");

        int choose = CheckException.checkParseInteger();
        switch (choose) {
            case 1:
                studentManagement();
                break;
            case 2:
                teacherManagement();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Chon lai");
        }
    }

    public static void studentManagement() {
        StudentImplement studentImplement = new StudentImplement();
        System.out.println("1. Hien thi danh sach");
        System.out.println("2. Them moi");
        System.out.println("3. Xoa theo id");
        System.out.println("4. Sap xep ");
        System.out.println("5. Chinh sua ");
        System.out.println("6. Thoat");

        int choose = CheckException.checkParseInteger();
        switch (choose) {
            case 1:
                studentImplement.display();
                break;
            case 2:
                studentImplement.add();
                break;
            case 3:
                studentImplement.delete();
                break;
            case 4:
                studentImplement.sort();
                break;
            case 5:
                studentImplement.edit();
                break;
            default:
                System.out.println("Chon lai");
        }
    }

    public static void teacherManagement() {
        TeacherImplement teacherImplement = new TeacherImplement();
        System.out.println("1. Hien thi danh sach");
        System.out.println("2. Them moi");
        System.out.println("3. Xoa theo id");
        System.out.println("4. Sap xep ");
        System.out.println("5. Chinh sua ");
        System.out.println("6. Thoat");

        int choose = CheckException.checkParseInteger();
        switch (choose) {
            case 1:
            teacherImplement.display();
                break;
            case 2:
            teacherImplement.add();
                break;
            case 3:
            teacherImplement.delete();
                break;
            case 4:
            teacherImplement.sort();
                break;
            case 5:
            teacherImplement.edit();
                break;
            default:
                System.out.println("Chon lai");
        }
    }
}
