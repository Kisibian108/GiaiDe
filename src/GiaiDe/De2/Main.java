package GiaiDe.De2;

import GiaiDe.De1.NotFoundCarException;

import java.util.*;

public class Main {
    private static List<Patient> patients = new ArrayList<>();
    private static List<NormalPatient> normalPatients = new ArrayList<>();
    private static List<VipPatient> vipPatients = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME_NORMAL = "src/GiaiDe/De2/normal.csv";
    private static final String FILE_NAME_VIP = "src/GiaiDe/De2/vip.csv";
    private static final String ID_RECORD = "^[BA-]+[0-9]{3}+$";
    private static final String ID_PATIENT = "^[BN-]+[0-9]{3}+$";
    private static final String DATE = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
    private static final String VIP = "^[VIP I]|[VIP II]|[VIP III]+$";

    public static void main(String[] args) {
        while (true) {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN\n" +
                    "Chọn chức năng theo số ( để tiếp tục): \n" +
                    "1. Add\n" +
                    "2. Delete\n" +
                    "3. Display\n" +
                    "4. Exit\n" +
                    "Chọn chức năng");
            System.out.print("Choice: ");
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
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choice again!");
                    break;
            }
        }
    }

    private static void delete() {
        System.out.println("1. Benh nhan thuong");
        System.out.println("2. Benh nhan vip");
        int choose = CheckException.checkParseInteger();
        switch (choose) {
            case 1:
                do {
                    normalPatients = FileService.readNormal(FILE_NAME_NORMAL);
                    System.out.println("Nhập id cần xóa: ");
                    Integer inputId = CheckException.checkParseInteger();
                    for (NormalPatient normalPatient : normalPatients) {
                        if (normalPatient.getId().equals(inputId)) {
                            System.out.println("Bạn có muốn xóa hay không? 1.Yes ; 2. No");
                            int choose1 = CheckException.checkParseInteger();
                            switch (choose1) {
                                case 1:
                                    normalPatients.remove(normalPatient);
                                    FileService.writeNormal(FILE_NAME_NORMAL, normalPatients);
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
                        throw new NotFoundCarException("Bệnh án không tồn tại");
                    } catch (NotFoundCarException e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);

            case 2:
                do {
                    vipPatients = FileService.readVip(FILE_NAME_VIP);
                    System.out.println("Nhập id cần xóa: ");
                    Integer inputId = CheckException.checkParseInteger();
                    for (VipPatient vipPatient : vipPatients) {
                        if (vipPatient.getId().equals(inputId)) {
                            System.out.println("Bạn có muốn xóa hay không? 1.Yes ; 2. No");
                            int choose1 = CheckException.checkParseInteger();
                            switch (choose1) {
                                case 1:
                                    vipPatients.remove(vipPatient);
                                    FileService.writeVip(FILE_NAME_VIP, vipPatients);
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
                        throw new NotFoundCarException("Bệnh án không tồn tại");
                    } catch (NotFoundCarException e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);
        }
    }

    public static void display() {

        System.out.println("1.Benh nhan thuong");
        System.out.println("2.Benh nhan vip");
        int choose = CheckException.checkParseInteger();
        switch (choose) {
            case 1:
                normalPatients = FileService.readNormal(FILE_NAME_NORMAL);
                if (!normalPatients.isEmpty()) {
                    for (NormalPatient normalPatient : normalPatients) {
                        System.out.println(normalPatient);
                    }
                } else {
                    System.out.println("List is empty!");
                }
                break;
            case 2:
                vipPatients = FileService.readVip(FILE_NAME_VIP);
                if (!vipPatients.isEmpty()) {
                    for (VipPatient vipPatient : vipPatients) {
                        System.out.println(vipPatient);
                    }
                } else {
                    System.out.println("List is empty!");
                }
                break;
        }
    }

    public static void add() {
        System.out.println("1.Benh nhan thuong");
        System.out.println("2.Benh nhan vip");
        int choose = CheckException.checkParseInteger();
        switch (choose) {
            case 1:
                normalPatients = FileService.readNormal(FILE_NAME_VIP);
                if (normalPatients.isEmpty()) {
                    Patient.setCountId(1);
                } else {
                    int max = normalPatients.get(0).getId();
                    for (NormalPatient normalPatient : normalPatients) {
                        if (normalPatient.getId() > max) {
                            max = normalPatient.getId();
                        }
                    }
                    Patient.setCountId(max);
                    if (Patient.getCountId() == null) {
                        Patient.setCountId(1);
                    } else {
                        Patient.setCountId(Patient.getCountId() + 1);
                    }
                }

                System.out.println("Ma benh an");
                String patientCode1 = inputBa();

                System.out.println("Ma benh nhan");
                String patientCode2 = inputBn();

                System.out.print("Ten benh nhan: ");
                String name = scanner.nextLine();

                System.out.println("Ngay nhap vien");
                String enterDate = inputDate();

                System.out.println("Ngay ra vien");
                String outDate = inputDate();

                System.out.println("Ly do nhap vien");
                String reason = scanner.nextLine();

                System.out.println("Phi nam vien");
                double price = Double.parseDouble(scanner.nextLine());

                normalPatients.add(new NormalPatient(Patient.getCountId(), patientCode1, patientCode2, name, enterDate, outDate, reason, price));
                FileService.writeNormal(FILE_NAME_NORMAL, normalPatients);
                break;
            case 2:
                normalPatients = FileService.readNormal(FILE_NAME_VIP);
                if (vipPatients.isEmpty()) {
                    Patient.setCountId(1);
                } else {
                    int max = vipPatients.get(0).getId();
                    for (VipPatient vipPatient : vipPatients) {
                        if (vipPatient.getId() > max) {
                            max = vipPatient.getId();
                        }
                    }
                    Patient.setCountId(max);
                    if (Patient.getCountId() == null) {
                        Patient.setCountId(1);
                    } else {
                        Patient.setCountId(Patient.getCountId() + 1);
                    }
                }

                System.out.println("Ma benh an");
                String patientCode3 = inputBa();

                System.out.println("Ma benh nhan");
                String patientCode4 = inputBn();

                System.out.print("Ten benh nhan: ");
                String name1 = scanner.nextLine();

                System.out.println("Ngay nhap vien");
                String enterDate1 = inputDate();

                System.out.println("Ngay ra vien");
                String outDate1 = inputDate();

                System.out.println("Ly do nhap vien");
                String reason1 = scanner.nextLine();

                System.out.println("Loai vip");
                String type = inputVip();

                System.out.println("Han su dung");
                String dueDate = scanner.nextLine();

                vipPatients.add(new VipPatient(Patient.getCountId(), patientCode3, patientCode4, name1, enterDate1, outDate1, reason1, type, dueDate));
                FileService.writeVip(FILE_NAME_VIP, vipPatients);
        }
    }

    public static String inputBa() {
        return RegexData.regexStr(scanner.nextLine(), ID_RECORD, "phai co dang BA-XXX");
    }

    public static String inputBn() {
        return RegexData.regexStr(scanner.nextLine(), ID_PATIENT, "phai co dang BN-XXX");
    }

    public static String inputDate() {
        return RegexData.regexStr(scanner.nextLine(), DATE, "Phai co dang dd/MM/yyyy");
    }

    public static String inputVip() {
        return RegexData.regexStr(scanner.nextLine(), VIP, "Chi co the VIP I, II, hoac III");
    }
}
