package GiaiDe.De3.Service;

import GiaiDe.De1.NotFoundCarException;
import GiaiDe.De3.Model.Staff;
import GiaiDe.De3.utils.CheckException;
import GiaiDe.De3.utils.FileService;
import GiaiDe.De3.utils.MySearchException;
import GiaiDe.De3.utils.RegexData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductionStaffImplement implements ProductionStaff{

    private static List<GiaiDe.De3.Model.ProductionStaff> productionStaffs = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME = "src/GiaiDe/De3/Data/ProductionStaff.csv";
    private static final String MONEY = "^[0-9]+$";
    private static final String BIRTHDAY = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";

    @Override
    public void display() {
        productionStaffs = FileService.readProductionStaff(FILE_NAME);
        if (!productionStaffs.isEmpty()) {
            for (GiaiDe.De3.Model.ProductionStaff productionStaff : productionStaffs) {
                System.out.println(productionStaff);
            }
        } else {
            System.out.println("Production list is empty!");
        }
    }

    @Override
    public void add() {
        productionStaffs = FileService.readProductionStaff(FILE_NAME);

        if (productionStaffs.isEmpty()) {
            Staff.setCountId(1);
        } else {
            int max = productionStaffs.get(0).getId();
            for (GiaiDe.De3.Model.ProductionStaff productionStaff : productionStaffs) {
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
        productionStaffs.add(new GiaiDe.De3.Model.ProductionStaff(Staff.getCountId(), id1, name1, birthday, address, amount, price));

        FileService.writeProductionStaff(FILE_NAME, productionStaffs);
    }

    @Override
    public void delete() {
        do {
            productionStaffs = FileService.readProductionStaff(FILE_NAME);
            System.out.println("Nhập id cần xóa: ");
            Integer inputId = CheckException.checkParseInteger();
            for (GiaiDe.De3.Model.ProductionStaff productionStaff : productionStaffs) {
                if (productionStaff.getId().equals(inputId)) {
                    System.out.println("Bạn có muốn xóa hay không? 1.Yes ; 2. No");
                    int choose1 = CheckException.checkParseInteger();
                    switch (choose1) {
                        case 1:
                            productionStaffs.remove(productionStaff);
                            FileService.writeProductionStaff(FILE_NAME, productionStaffs);
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
        productionStaffs = FileService.readProductionStaff(FILE_NAME);

        System.out.print("Enter name for search: ");
        String name = scanner.nextLine();
        if (checkNameExists(name)) {
            for (GiaiDe.De3.Model.ProductionStaff productionStaff : productionStaffs) {
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

    private static boolean checkNameExists(String name) {
        productionStaffs = FileService.readProductionStaff(FILE_NAME);

        for (GiaiDe.De3.Model.ProductionStaff productionStaff : productionStaffs) {
            if (productionStaff.getName().contains(name.toLowerCase())) {
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
