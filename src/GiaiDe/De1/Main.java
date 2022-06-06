//package GiaiDe.De1;
//
//import java.util.*;
//
//public class Main {
//    private static List<Genuine> genuines = new ArrayList<>();
//    private static List<Handed> handeds = new ArrayList<>();
//    private static Scanner scanner = new Scanner(System.in);
//    private static final String FILE_NAME_GENUINE = "src/GiaiDe/De1/genuine.csv";
//    private static final String HANDLE = "src/GiaiDe/De1/handle.csv";
//
//    public static void main(String[] args) {
//        while (true) {
//            System.out.println("----CHUONG TRINH QUAN LY DIEN THOAI----");
//            System.out.println("Chon chuc nang theo so ( de tiep tuc) ");
//            System.out.println("1. Them moi");
//            System.out.println("2. Xoa");
//            System.out.println("3. Xem danh sach dien thoai");
//            System.out.println("4. Tim kiem");
//            System.out.println("5. Thoat");
//            System.out.println("Chon chuc nang: ");
//            int choice = CheckException.checkParseInteger();
//            switch (choice) {
//                case 1:
//
//                    break;
//                case 2:
//
//                    break;
//                case 3:
//                    break;
//                case 4:
//                    break;
//                case 5:System.exit(0);
//                    break;
//                default:
//                    System.out.println("Choice again!");
//                    break;
//            }
//        }
//    }
//
//    private static void add() {
//        while (true) {
//            System.out.println("");
//            System.out.print("Choice: ");
//            int choice = CheckException.checkParseInteger();
//            switch (choice) {
//                case 1:
//                    addNewStudent();
//                    break;
//                case 2:
//                    displayStudent();
//                    break;
//                case 3:
//                    searchStudentByName();
//                    break;
//                case 4:
//                    sortByPoint();
//                    break;
//                case 0:
//                    return;
//                default:
//                    System.out.println("Choice again!");
//                    break;
//            }
//        }
//    }
//
//    private static void choiceTeacherManagement() {
//        while (true) {
//            System.out.println("Student Management\n" +
//                    "1. Add new teacher\n" +
//                    "2. Display teacher\n" +
//                    "0. Return main menu");
//            System.out.print("Choice: ");
//            int choice = CheckException.checkParseInteger();
//            switch (choice) {
//                case 1:
//                    addNewTeacher();
//                    break;
//                case 2:
//                    displayTeacher();
//                    break;
//                case 0:
//                    return;
//                default:
//                    System.out.println("Choice again!");
//                    break;
//            }
//        }
//    }
//
//    public static void displayStudent() {
//        students = FileService.readStudent(FILE_NAME_STUDENT);
//        if (!students.isEmpty()) {
//            for (Genuine student : students) {
//                System.out.println(student);
//            }
//        } else {
//            System.out.println("Student list is empty!");
//        }
//    }
//
//    public static void addNewStudent() {
//        students = FileService.readStudent(FILE_NAME_STUDENT);
//
//        if (students.isEmpty()) {
//            Phone.setCountId(1);
//        } else {
//            int max = students.get(0).getId();
//            for (Genuine student : students) {
//                if (student.getId() > max) {
//                    max = student.getId();
//                }
//            }
//            Phone.setCountId(max);
//            if (Phone.getCountId() == null) {
//                Phone.setCountId(1);
//            } else {
//                Phone.setCountId(Phone.getCountId() + 1);
//            }
//        }
//
//        System.out.print("Name: ");
//        String name = sc.nextLine();
//        System.out.print("Point: ");
//        int point = CheckRegex.checkRegexPoint();
//        students.add(new Genuine(Phone.getCountId(), name, point));
//
//        FileService.writeStudent(FILE_NAME_STUDENT, students);
//    }
//
//    public static void searchStudentByName() {
//        students = FileService.readStudent(FILE_NAME_STUDENT);
//
//        System.out.print("Enter name for search: ");
//        String name = sc.nextLine();
//        if (checkNameExists(name)) {
//            for (Genuine student : students) {
//                if (student.getName().contains(name.toLowerCase())) {
//                    System.out.println(student);
//                }
//            }
//        } else {
//            try {
//                throw new MySearchException("Name is not exists!");
//            } catch (MySearchException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }
//
//    /**
//     * Kiểm tra xem tên có tồn tại trong list không?
//     */
//    private static boolean checkNameExists(String name) {
//        students = FileService.readStudent(FILE_NAME_STUDENT);
//
//        for (Genuine student : students) {
//            if (student.getName().contains(name.toLowerCase())) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static void sortByPoint() {
//        students = FileService.readStudent(FILE_NAME_STUDENT);
//
//        Collections.sort(students, new Comparator<Genuine>() {
//            @Override
//            public int compare(Genuine o1, Genuine o2) {
//                return o1.getPoint() - o2.getPoint();
//            }
//        });
//        for (Genuine student : students) {
//            System.out.println(student);
//        }
//    }
//
//    public static void addNewTeacher() {
//        teachers = FileService.readTeacher(FILE_NAME_TEACHER);
//
//        if (teachers.isEmpty()) {
//            Phone.setCountId(1);
//        } else {
//            int max = teachers.get(0).getId();
//            for (Teacher teacher : teachers) {
//                if (teacher.getId() > max) {
//                    max = teacher.getId();
//                }
//            }
//            Phone.setCountId(max);
//            if (Phone.getCountId() == null) {
//                Phone.setCountId(1);
//            } else {
//                Phone.setCountId(Phone.getCountId() + 1);
//            }
//        }
//
//        System.out.print("Name: ");
//        String name = sc.nextLine();
//        System.out.print("Salary: ");
//        double salary = Double.parseDouble(sc.nextLine());
//        teachers.add(new Teacher(Phone.getCountId(), name, salary));
//
//        FileService.writeTeacher(FILE_NAME_TEACHER, teachers);
//    }
//
//    public static void displayTeacher() {
//        teachers = FileService.readTeacher(FILE_NAME_TEACHER);
//
//        if (!teachers.isEmpty()) {
//            for (Teacher teacher : teachers) {
//                System.out.println(teacher);
//            }
//        } else {
//            System.out.println("Teacher list is empty!");
//        }
//    }
//    /**
//     * Copyright by Phuong
//     */
//}
