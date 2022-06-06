package GiaiDe.De3.view;

import GiaiDe.De3.Controller.Controller;
import GiaiDe.De3.utils.CheckException;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. Manager");
        System.out.println("2. Production Staff");
        int choose = CheckException.checkParseInteger();
        switch (choose) {
            case 1:
                Controller.choiceManager();
                break;
            case 2:
                Controller.choicePruductionStaff();
                break;
        }
    }
}
