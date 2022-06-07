package GiaiDe.De5.service;

import GiaiDe.De1.NotFoundCarException;
import GiaiDe.De4.utils.CheckException;
import GiaiDe.De5.model.Teacher;
import GiaiDe.De5.utils.ComparatorbyName;
import GiaiDe.De5.utils.FileService;
import GiaiDe.De5.utils.RegexData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TeacherImplement implements TeacherImpl {

    static Scanner scanner = new Scanner(System.in);
    static List<Teacher> teacherList = new ArrayList<>();
    public static final String TEACHER = "src/GiaiDe/De5/Data/Teacher.csv";
    public static final String REGEX_HOUR = "^[0-9]{1,10}+$";
    public static final String REGEX_BIRTHDAY = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";

    @Override
    public void display() {
        teacherList = FileService.readTeacher(TEACHER);
        if (!teacherList.isEmpty()) {
            for (Teacher teacher : teacherList) {
                System.out.println(teacherList);
            }
        } else {
            System.out.println("List rong");
        }
    }

    @Override
    public void add() {
        teacherList = FileService.readTeacher(TEACHER);

        if (teacherList.isEmpty()) {
            Teacher.setCountID(1);
        } else {
            int max = teacherList.get(0).getId();
            for (Teacher teacher : teacherList) {
                if (teacher.getId() > max) {
                    max = teacher.getId();
                }
            }
            Teacher.setCountID(max);
            if (Teacher.getCountID() == null) {
                Teacher.setCountID(1);
            } else {
                Teacher.setCountID(Teacher.getCountID() + 1);
            }
        }

        System.out.println("Nhap ten");
        String name = scanner.nextLine();

        System.out.println("Nhap gioi tinh");
        String gender = scanner.nextLine();

        System.out.println("Nhap ngay sinh");
        String birthday = inputAge();

        System.out.println("Nhap dia chi");
        String address = scanner.nextLine();

        System.out.println("Nhap lop day");
        String classRoom = scanner.nextLine();

        System.out.println("Nhap luong 1 gio day ");
        double salary = Double.parseDouble(inputMoney());

        System.out.println("Nhap so gio day");
        double hour = Double.parseDouble(inputMoney());

        teacherList.add(new Teacher(Teacher.getCountID(), name, gender, birthday, address, classRoom, salary, hour));
        FileService.writeTeacher(TEACHER, teacherList);
    }

    @Override
    public void delete() {
        teacherList = FileService.readTeacher(TEACHER);
        do {
            teacherList = FileService.readTeacher(TEACHER);
            System.out.println("Nhập id cần xóa: ");
            int id = Integer.parseInt(scanner.nextLine());
            for (Teacher teacher : teacherList) {
                if (teacher.getId().equals(id)) {
                    System.out.println("Bạn có muốn xóa hay không? 1.Yes ; 2. No");
                    int choose1 = CheckException.checkParseInteger();
                    switch (choose1) {
                        case 1:
                            teacherList.remove(teacher);
                            FileService.writeTeacher(TEACHER, teacherList);
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
                throw new NotFoundCarException("Ma không tồn tại");
            } catch (NotFoundCarException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    @Override
    public void sort() {

        teacherList = FileService.readTeacher(TEACHER);
        Collections.sort(teacherList, new ComparatorbyName());
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    @Override
    public void edit() {
        teacherList = FileService.readTeacher(TEACHER);
        System.out.println("Nhap ID can sua");
        int id = Integer.parseInt(scanner.nextLine());
        boolean isExist = false;

        for (Teacher teacher : teacherList) {
            if (teacher.getId() == id) {
                isExist = true;
                teacher.setId(id);

                System.out.println("Nhap ten");
                String name = scanner.nextLine();
                teacher.setName(name);

                System.out.println("Nhap gioi tinh");
                String gender = scanner.nextLine();
                teacher.setGender(gender);

                System.out.println("Nhap ngay sinh");
                String birthday = inputAge();
                teacher.setBirthday(birthday);

                System.out.println("Nhap dia chi");
                String address = scanner.nextLine();
                teacher.setAddress(address);

                System.out.println("Nhap lop day");
                String classRoom = scanner.nextLine();
                teacher.setClassRoom(classRoom);

                System.out.println("Nhap luong 1 gio day");
                double salary = Double.parseDouble(inputMoney());
                teacher.setSalaryByHour(salary);

                System.out.println("Nhap so gio day");
                double hour = Double.parseDouble(inputMoney());
                teacher.setTeachHourByMonth(hour);

                FileService.writeTeacher(TEACHER, teacherList);
            }
        }
        if (isExist) {
            System.out.println("Chinh sua thanh cong");
        } else {
            System.out.println("Id ko ton tai");
        }
    }

    public static String inputMoney(){
        return RegexData.regexStr(scanner.nextLine(),REGEX_HOUR, "Phai la so duong");
    }

    public static String inputAge(){
        return RegexData.regexAge(scanner.nextLine(), REGEX_BIRTHDAY);
    }
}

