package GiaiDe.De5.service;

import GiaiDe.De1.NotFoundCarException;
import GiaiDe.De4.utils.CheckException;
import GiaiDe.De5.model.Student;
import GiaiDe.De5.utils.ComparatorByBirthday;
import GiaiDe.De5.utils.ComparatorbyName;
import GiaiDe.De5.utils.FileService;
import GiaiDe.De5.utils.RegexData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentImplement implements StudentImpl {

    static Scanner scanner = new Scanner(System.in);
    static List<Student> studentList = new ArrayList<>();
    public static final String STUDENT = "src/GiaiDe/De5/Data/Student.csv";
    public static final String REGEX_HOUR = "^[0-9]{1,10}+$";
    public static final String REGEX_BIRTHDAY = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
    public static final String POINT = "^[0-9]{1}|10+$";
    public static final String REGEX_IDSTUDENT = "^[0-9]{8}+$";

    @Override
    public void display() {
        studentList = FileService.readStudent(STUDENT);
        if (!studentList.isEmpty()) {
            for (Student student : studentList) {
                System.out.println(student);
            }
        } else {
            System.out.println("List rong");
        }
    }

    @Override
    public void add() {
        studentList = FileService.readStudent(STUDENT);

        if (studentList.isEmpty()) {
            Student.setCountID(1);
        } else {
            int max = studentList.get(0).getId();
            for (Student student : studentList) {
                if (student.getId() > max) {
                    max = student.getId();
                }
            }
            Student.setCountID(max);
            if (Student.getCountID() == null) {
                Student.setCountID(1);
            } else {
                Student.setCountID(Student.getCountID() + 1);
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

        System.out.println("Nhap ma sinh vien");
        String idStudent = inputIDstudent();

        System.out.println("Nhap diem trung binh ");
        double point = Double.parseDouble(inputPoint());

        studentList.add(new Student(Student.getCountID(), name, gender, birthday, address, idStudent, point));
        FileService.writeStudent(STUDENT, studentList);
    }

    @Override
    public void delete() {
        studentList = FileService.readStudent(STUDENT);
        do {
            studentList = FileService.readStudent(STUDENT);
            System.out.println("Nhập id cần xóa: ");
            int id = Integer.parseInt(scanner.nextLine());
            for (Student student : studentList) {
                if (student.getId().equals(id)) {
                    System.out.println("Bạn có muốn xóa hay không? 1.Yes ; 2. No");
                    int choose1 = CheckException.checkParseInteger();
                    switch (choose1) {
                        case 1:
                            studentList.remove(student);
                            FileService.writeStudent(STUDENT, studentList);
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
        studentList = FileService.readStudent(STUDENT);
        studentList.sort(new ComparatorbyName());
        studentList.sort(new ComparatorByBirthday());
        for (Student student : studentList) {
            System.out.println(student);
        }
        FileService.writeStudent(STUDENT,studentList);
    }

    @Override
    public void edit() {
        studentList = FileService.readStudent(STUDENT);
        System.out.println("Nhap ID can sua");
        int id = Integer.parseInt(scanner.nextLine());
        boolean isExist = false;
       
        for (Student student: studentList) {
            if(student.getId() == id ){
                isExist = true;
                student.setId(id);

                System.out.println("Nhap ten");
                String name = scanner.nextLine();
                student.setName(name);

                System.out.println("Nhap gioi tinh");
                String gender = scanner.nextLine();
                student.setGender(gender);

                System.out.println("Nhap ngay sinh");
                String birthday = inputAge();
                student.setBirthday(birthday);

                System.out.println("Nhap dia chi");
                String address = scanner.nextLine();
                student.setAddress(address);

                System.out.println("Nhap ma sinh vien");
                String idStudent = inputIDstudent();
                student.setIdStudent(idStudent);

                System.out.println("Nhap diem trung binh");
                String point = inputPoint();
                student.setPoint(Double.parseDouble(point));
                FileService.writeStudent(STUDENT,studentList);
            }
        }
        if(isExist){
            System.out.println("Chinh sua thanh cong");
        }else {
            System.out.println("Id ko ton tai");
        }
    }

    public static String inputMoney(){
        return RegexData.regexStr(scanner.nextLine(),REGEX_HOUR, "Phai la so duong");
    }

    public static String inputAge(){
        return RegexData.regexAge(scanner.nextLine(), REGEX_BIRTHDAY);
    }

    public static String inputPoint(){
        return RegexData.regexStr(scanner.nextLine(), POINT, "Phai tu 0-10");
    }

    public static String inputIDstudent(){
        return RegexData.regexStr(scanner.nextLine(), REGEX_IDSTUDENT, "Phai co 8 so");
    }
}

