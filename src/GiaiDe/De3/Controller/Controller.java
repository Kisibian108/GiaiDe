package GiaiDe.De3.Controller;

import GiaiDe.De3.Model.Manager;
import GiaiDe.De3.Model.ProductionStaff;
import GiaiDe.De3.Service.ManagerImplement;
import GiaiDe.De3.Service.ProductionStaffImplement;
import GiaiDe.De3.utils.*;

import java.util.*;

public class Controller {
    private static List<Manager> managers = new ArrayList<>();
    private static List<ProductionStaff> productionStaffs = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME_MANAGER = "src/GiaiDe/De3/Data/Manager.csv";
    private static final String FILE_NAME_PRODUCTION_STAFF = "src/GiaiDe/De3/Data/ProductionStaff.csv";
    private static final String MONEY = "^[0-9]+$";
    private static final String BIRTHDAY = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";

    public static void choiceManager() {
        ManagerImplement managerImplement = new ManagerImplement();
        while (true) {
            System.out.println("Manager Management\n" +
                    "1. Display manager\n" +
                    "2. Add new manager\n" +
                    "3. Delete manager by idCode\n" +
                    "4. Search manager\n" +
                    "5. Exit");
            System.out.print("Choice: ");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    managerImplement.display();
                    break;
                case 2:
                    managerImplement.add();
                    break;
                case 3:
                    managerImplement.delete();
                    break;
                case 4:
                    managerImplement.search();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choice again!");
                    break;
            }
        }
    }

    public static void choicePruductionStaff() {
        ProductionStaffImplement productionStaffImplement = new ProductionStaffImplement();
        while (true) {
            System.out.println("Production Staff Management\n" +
                    "1. Display production staff\n" +
                    "2. Add new production staff\n" +
                    "3. Delete by idCode\n" +
                    "4. Search production staff\n" +
                    "5. Exit");
            System.out.print("Choice: ");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    productionStaffImplement.display();
                    break;
                case 2:
                    productionStaffImplement.add();
                    break;
                case 3:
                    productionStaffImplement.delete();
                    break;
                case 4:
                    productionStaffImplement.search();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choice again!");
                    break;
            }
        }
    }
}