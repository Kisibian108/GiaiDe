package GiaiDe.De3.Service;

import GiaiDe.De1.NotFoundCarException;
import GiaiDe.De3.Model.Manager;
import GiaiDe.De3.Model.Staff;
import GiaiDe.De3.utils.CheckException;
import GiaiDe.De3.utils.FileService;
import GiaiDe.De3.utils.MySearchException;
import GiaiDe.De3.utils.RegexData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerImplement implements ManagerImpl{

    private static List<Manager> managers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME = "src/GiaiDe/De3/Data/Staff.csv";
    private static final String MONEY = "^[0-9]+$";
    private static final String BIRTHDAY = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";

    @Override
    public void display() {
        managers = FileService.readManager(FILE_NAME);
        if (!managers.isEmpty()) {
            for (Manager manager : managers) {
                System.out.println(manager);
            }
        } else {
            System.out.println("Manager list is empty!");
        }
    }

    @Override
    public void add() {
        managers = FileService.readManager(FILE_NAME);
        if (managers.isEmpty()) {
            Manager.setCountId(1);
        } else {
            int max = managers.get(0).getId();
            for (Manager manager : managers) {
                if (manager.getId() > max) {
                    max = manager.getId();
                }
            }
            Manager.setCountId(max);
            if (Manager.getCountId() == null) {
                Manager.setCountId(1);
            } else {
                Manager.setCountId(Manager.getCountId() + 1);
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

        FileService.writeManager(FILE_NAME, managers);
    }

    @Override
    public void delete() {
        do {
            managers = FileService.readManager(FILE_NAME);
            System.out.println("Nhập id cần xóa: ");
            Integer inputId = CheckException.checkParseInteger();
            for (Manager manager : managers) {
                if (manager.getId().equals(inputId)) {
                    System.out.println("Bạn có muốn xóa hay không? 1.Yes ; 2. No");
                    int choose1 = CheckException.checkParseInteger();
                    switch (choose1) {
                        case 1:
                            managers.remove(manager);
                            FileService.writeManager(FILE_NAME, managers);
                            display();
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
                throw new NotFoundCarException("Nhan vien không tồn tại");
            } catch (NotFoundCarException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    @Override
    public void search() {
        managers = FileService.readManager(FILE_NAME);

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

    private static boolean checkNameExists(String name) {
        managers = FileService.readManager(FILE_NAME);

        for (Manager manager : managers) {
            if (manager.getName().contains(name.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static String inputMoney(){
        return RegexData.regexStr(scanner.nextLine(), MONEY, "Phai la so duong");
    }

    public static String inputAge(){
        return RegexData.regexAge(scanner.nextLine(),BIRTHDAY);
    }
}

