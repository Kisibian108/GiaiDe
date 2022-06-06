package GiaiDe.De1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    private static List<Genuine> genuines = new ArrayList<>();
    private static List<Handed> handeds = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String GENUINE = "src/GiaiDe/De1/genuine.csv";
    private static final String HANDLE = "src/GiaiDe/De1/handle.csv";
    private static final String PRICE_AMOUNT ="^[0-9]{1,10}$";
    private static final String INSURANCE_TIME ="^([0-7]{1}+[0-2]{1}+[0-9]{1})|([0-9]{1})|([1-9]{1}+[0-9]{1})|([0-6]{1}+[0-6]{1}+[0-9]{1})$";
    private static final String INSURANCE_RANG ="^[Toan Quoc| Quoc Te]+$";
    private static final String NATIONAL ="[^(Viet Nam)]+";
    private static final String STATUS ="^[Da sua chua| Chua sua chua]+$";

    public static void main(String[] args) {
        System.out.println(Genuine.getCountId());
        while (true) {
            System.out.println("----CHUONG TRINH QUAN LY DIEN THOAI----");
            System.out.println("Chon chuc nang theo so ( de tiep tuc) ");
            System.out.println("1. Them moi");
            System.out.println("2. Xoa");
            System.out.println("3. Xem danh sach dien thoai");
            System.out.println("4. Tim kiem");
            System.out.println("5. Thoat");
            System.out.println("Chon chuc nang: ");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    display();
                    break;
                case 4:
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

    public static void add() {

        System.out.println("1.Dien thoai chinh hang");
        System.out.println("2.Dien thoai xach tay");
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                genuines = FileService.readGenuine(GENUINE);
                if (genuines.isEmpty()) {
                    Phone.setCountId(1);
                } else {
                    int max = genuines.get(0).getId();
                    for (Genuine genuine : genuines) {
                        if (genuine.getId() > max) {
                            max = genuine.getId();
                        }
                    }
                    Phone.setCountId(max);
                    if (Phone.getCountId() == null) {
                        Phone.setCountId(1);
                    } else {
                        Phone.setCountId(Phone.getCountId() + 1);
                    }
                }

                System.out.println("Nhap ten dien thoai");
                String name = scanner.nextLine();

                System.out.println("Nhap gia ban");
                double price = Double.parseDouble(inputPriceAmount());

                System.out.println("Nhap so luong");
                int amount = Integer.parseInt(inputPriceAmount());

                System.out.println("Nhap nha san xuat");
                String production = scanner.nextLine();

                System.out.println("Nhap thoi gian bao hanh");
                int insurance = Integer.parseInt(inputInsuranceTime());

                System.out.println("Nhap pham vi bao hanh");
                String range = inputInsuranceRange();

                genuines.add(new Genuine(Phone.getCountId(), name, price, amount, production, insurance, range));
                FileService.writeGenuine(GENUINE, genuines);
                break;
            case 2:

                handeds = FileService.readHandle(HANDLE);
                if (handeds.isEmpty()) {
                    Phone.setCountId(1);
                } else {
                    int max = handeds.get(0).getId();
                    for (Handed handed : handeds) {
                        if (handed.getId() > max) {
                            max = handed.getId();
                        }
                    }
                    Phone.setCountId(max);
                    if (Phone.getCountId() == null) {
                        Phone.setCountId(1);
                    } else {
                        Phone.setCountId(Phone.getCountId() + 1);
                    }
                }

                System.out.println("Nhap ten dien thoai");
                String name1 = scanner.nextLine();

                System.out.println("Nhap gia ban");
                double price1 = Double.parseDouble(inputPriceAmount());

                System.out.println("Nhap so luong");
                int amount1 = Integer.parseInt(inputPriceAmount());

                System.out.println("Nhap nha san xuat");
                String production1 = scanner.nextLine();

                System.out.println("Nhap quoc gia xach tay");
                String national = inputNational();

                System.out.println("Nhap trang thai");
                String status = inputStatus();

                handeds.add(new Handed(Phone.getCountId(), name1, price1, amount1, production1, national, status));
                FileService.writeHandle(HANDLE, handeds);

                break;
        }
    }

    public static void display() {
        System.out.println("1.Dien thoai chinh hang");
        System.out.println("2. Dien thoai xach tay");
        int choose = CheckException.checkParseInteger();
        switch (choose) {
            case 1:
                genuines = FileService.readGenuine(GENUINE);
                if (!genuines.isEmpty()) {
                    for (Genuine genuine : genuines) {
                        System.out.println(genuine);
                    }
                }
                break;
            case 2:
                handeds = FileService.readHandle(HANDLE);
                if (!handeds.isEmpty()) {
                    for (Handed handed : handeds) {
                        System.out.println(handed);
                    }
                }
                break;
        }
    }

    public static void delete() {

        System.out.println("1. Dien thoai chinh hang");
        System.out.println("2. Dien thoai xach tay");
        int choose = CheckException.checkParseInteger();
        switch (choose){
            case 1:
                do {
                    genuines = FileService.readGenuine(GENUINE);
                    System.out.println("Nhập id cần xóa: ");
                    Integer inputId = CheckException.checkParseInteger();
                    for (Genuine genuine : genuines) {
                        if (genuine.getId().equals(inputId)) {
                            System.out.println("Bạn có muốn xóa hay không? 1.Yes ; 2. No");
                            int choose1 = CheckException.checkParseInteger();
                            switch (choose1) {
                                case 1:
                                    genuines.remove(genuine);
                                    FileService.writeGenuine(GENUINE,genuines);
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
                        throw new NotFoundCarException("Điện thoại này không tồn tại");
                    } catch (NotFoundCarException e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);

            case 2:
                do {
                    handeds = FileService.readHandle(HANDLE);
                    System.out.println("Nhập id cần xóa: ");
                    Integer inputId = CheckException.checkParseInteger();
                    for (Handed handed : handeds) {
                        if (handed.getId().equals(inputId)) {
                            System.out.println("Bạn có muốn xóa hay không? 1.Yes ; 2. No");
                            int choose1 = CheckException.checkParseInteger();
                            switch (choose1) {
                                case 1:
                                    handeds.remove(handed);
                                    FileService.writeHandle(HANDLE,handeds);
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
                        throw new NotFoundCarException("Điện thoại này không tồn tại");
                    } catch (NotFoundCarException e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);
        }

    }
    public static String inputPriceAmount(){
        return RegexData.regexStr(scanner.nextLine(),PRICE_AMOUNT,"Phai la so duong");
    }

    public static String inputInsuranceTime(){
        return RegexData.regexStr(scanner.nextLine(),INSURANCE_TIME,"Phai nho hon 730 ngay");
    }

    public static String inputInsuranceRange(){
        return RegexData.regexStr(scanner.nextLine(),INSURANCE_RANG,"Phai la Toan Quoc hoac Quoc Te");
    }

    public static String inputNational(){
        return RegexData.regexStr(scanner.nextLine(),NATIONAL,"Khong duoc la Viet Nam");
    }

    public static String inputStatus(){
        return RegexData.regexStr(scanner.nextLine(),STATUS,"Phai la da sua chua hoac chua sua chua");
    }
}