package GiaiDe.De3.Controller;

import GiaiDe.De1.NotFoundEmployeeException;
import GiaiDe.De3.Model.Manager;
import GiaiDe.De3.Model.ProductionStaff;
import GiaiDe.De3.Model.Staff;
import GiaiDe.De3.utils.*;

import java.util.*;

public class Controller {
    private static List<Manager> managers = new ArrayList<>();
    private static List<ProductionStaff> productionStaffs = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME_MANAGER = "src/GiaiDe/De3/Data/manager.csv";
    private static final String FILE_NAME_PRODUCTION_STAFF = "src/GiaiDe/De3/Data/productionStaff.csv";
    private static final String MONEY = "^[0-9]+$";
    private static final String BIRTHDAY = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";

    public static void choiceManager() {
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
                    displayManager();
                    break;
                case 2:
                    addNewManager();
                    break;
                case 3:
                    deleteManagerStaff();
                    break;
                case 4:
                    searchManagerByName();
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
                    displayProductionStaff();
                    break;
                case 2:
                    addNewProductionStaff();
                    break;
                case 3:
                    deleteProductionStaff();
                    break;
                case 4:
                    searchProductionStaff();
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

    public static void displayManager() {
        managers = FileService.readManager(FILE_NAME_MANAGER);
        if (!managers.isEmpty()) {
            for (Manager manager : managers) {
                System.out.println(manager);
            }
        } else {
            System.out.println("Manager list is empty!");
        }
    }

    public static void addNewManager() {
        managers = FileService.readManager(FILE_NAME_MANAGER);

        if (managers.isEmpty()) {
            Staff.setCountId(1);
        } else {
            int max = managers.get(0).getId();
            for (Manager manager : managers) {
                if (manager.getId() > max) {
                    max = manager.getId();
                }
            }
            Staff.setCountId(max);
            if (Staff.getCountId() == null) {
                Staff.setCountId(1);
            } else {
                Staff.setCountId(Staff.getCountId() + 1);
            }
        }

        System.out.println("Ma nhan vien");
        Integer id = CheckException.checkParseInteger();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Ngay sinh: ");
        String birthday = inputAge();

        System.out.println("Dia chi: ");
        String address = scanner.nextLine();

        System.out.println("Luong co ban");
        double salary = Double.parseDouble(inputMoney());

        System.out.println("He so luong");
        double cofficiency = Double.parseDouble(inputMoney());

        managers.add(new Manager(Staff.getCountId(), id, name, birthday, address, salary, cofficiency));

        FileService.writeManager(FILE_NAME_MANAGER, managers);
    }

    public static void searchManagerByName() {
        managers = FileService.readManager(FILE_NAME_MANAGER);

        System.out.print("Enter name for search: ");
        String name = scanner.nextLine();
        if (checkNameExists(name)) {
            for (Manager manager : managers) {
                if (manager.getName().contains(name) |
                        manager.getAddress().contains(name) |
                        manager.getBirthday().contains(name)) {
                    System.out.println(manager);
                }
            }
        } else {
            try {
                throw new MySearchException("Name is not exists!");
            } catch (MySearchException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void deleteManagerStaff() {
        do {
            managers = FileService.readManager(FILE_NAME_MANAGER);
            System.out.println("Nhập id cần xóa: ");
            Integer inputId = CheckException.checkParseInteger();
            for (Manager manager : managers) {
                if (manager.getId().equals(inputId)) {
                    System.out.println("Bạn có muốn xóa hay không? 1.Yes ; 2. No");
                    int choose1 = CheckException.checkParseInteger();
                    switch (choose1) {
                        case 1:
                            managers.remove(manager);
                            FileService.writeManager(FILE_NAME_MANAGER, managers);
                            displayManager();
                            return;
                        case 2:
                            return;
                        default:
                            System.out.println("Chọn lại đi!!");
                            return;
                    }
                }
            }
            try {
                throw new NotFoundEmployeeException("Nhan vien không tồn tại");
            } catch (NotFoundEmployeeException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    /**
     * Kiểm tra xem tên có tồn tại trong list không?
     */
    private static boolean checkNameExists(String name) {
        managers = FileService.readManager(FILE_NAME_MANAGER);

        for (Manager manager : managers) {
            if (manager.getName().contains(name.toLowerCase())) {
                return true;
            }
        }
        return false;
    }


    public static void addNewProductionStaff() {
        productionStaffs = FileService.readProductionStaff(FILE_NAME_PRODUCTION_STAFF);

        if (productionStaffs.isEmpty()) {
            Staff.setCountId(1);
        } else {
            int max = productionStaffs.get(0).getId();
            for (ProductionStaff productionStaff : productionStaffs) {
                if (productionStaff.getId() > max) {
                    max = productionStaff.getId();
                }
            }
            Staff.setCountId(max);
            if (Staff.getCountId() == null) {
                Staff.setCountId(1);
            } else {
                Staff.setCountId(Staff.getCountId() + 1);
            }
        }

        System.out.println("Ma nhan vien");
        Integer id1 = CheckException.checkParseInteger();

        System.out.print("Name: ");
        String name1 = scanner.nextLine();

        System.out.print("Ngay sinh: ");
        String birthday = inputAge();

        System.out.println("Dia chi: ");
        String address = scanner.nextLine();

        System.out.println("Nhap so san pham");
        int amount = Integer.parseInt(inputMoney());

        System.out.println("Nhap gia san pham");
        double price = Double.parseDouble(inputMoney());
        productionStaffs.add(new ProductionStaff(Staff.getCountId(), id1, name1, birthday, address, amount, price));

        FileService.writeProductionStaff(FILE_NAME_PRODUCTION_STAFF, productionStaffs);
    }

    public static void displayProductionStaff() {
        productionStaffs = FileService.readProductionStaff(FILE_NAME_PRODUCTION_STAFF);

        if (!productionStaffs.isEmpty()) {
            for (ProductionStaff productionStaff : productionStaffs) {
                System.out.println(productionStaff);
            }
        } else {
            System.out.println("Production list is empty!");
        }
    }

    public static void searchProductionStaff() {
        productionStaffs = FileService.readProductionStaff(FILE_NAME_PRODUCTION_STAFF);

        System.out.print("Enter name for search: ");
        String name = scanner.nextLine();
        if (checkNameExists(name)) {
            for (ProductionStaff productionStaff : productionStaffs) {
                if (productionStaff.getName().contains(name) |
                        productionStaff.getBirthday().contains(name) |
                        productionStaff.getAddress().contains(name)) {
                    System.out.println(productionStaff);
                }
            }
        } else {
            try {
                throw new MySearchException("Name is not exists!");
            } catch (MySearchException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void deleteProductionStaff() {
        do {
            productionStaffs = FileService.readProductionStaff(FILE_NAME_PRODUCTION_STAFF);
            System.out.println("Nhập id cần xóa: ");
            Integer inputId = CheckException.checkParseInteger();
            for (ProductionStaff productionStaff : productionStaffs) {
                if (productionStaff.getId().equals(inputId)) {
                    System.out.println("Bạn có muốn xóa hay không? 1.Yes ; 2. No");
                    int choose1 = CheckException.checkParseInteger();
                    switch (choose1) {
                        case 1:
                            productionStaffs.remove(productionStaff);
                            FileService.writeProductionStaff(FILE_NAME_PRODUCTION_STAFF, productionStaffs);
                            displayProductionStaff();
                            return;
                        case 2:
                            return;
                        default:
                            System.out.println("Chọn lại đi!!");
                            return;
                    }
                }
            }
            try {
                throw new NotFoundEmployeeException("Nhan vien không tồn tại");
            } catch (NotFoundEmployeeException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static String inputMoney(){
        return RegexData.regexStr(scanner.nextLine(), MONEY, "Phai la so duong");
    }

    public static String inputAge(){
        return RegexData.regexAge(scanner.nextLine(),BIRTHDAY);
    }
}