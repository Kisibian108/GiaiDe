package GiaiDe.De5.utils;

import GiaiDe.De5.model.Student;
import GiaiDe.De5.model.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private static final String COMMA = ",";

    /**
     * Write to file
     */
    private static void writeToFile(String pathFile, List<String> strings) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (String s : strings) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeStudent(String pathFile, List<Student> studentList) {
        List<String> strings = new ArrayList<>();

        for (Student student : studentList) {
            strings.add(student.convertLine());
        }
        writeToFile(pathFile, strings);
    }

    public static void writeTeacher(String pathFile, List<Teacher> teacherList) {
        List<String> strings = new ArrayList<>();
        for (Teacher teacher : teacherList) {
            strings.add(teacher.convertLine());
        }
        writeToFile(pathFile, strings);
    }


    /**
     * Read from file
     */
    private static List<String> readFromFile(String pathFile) {
        List<String> strings = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                strings.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    public static List<Student> readStudent(String pathFile) {
        List<Student> studentList = new ArrayList<>();
        List<String> strings = readFromFile(pathFile);

        String[] lines;
        for (String s : strings) {
            lines = s.split(COMMA);
            studentList.add(new Student(Integer.parseInt(lines[0]),
                    lines[1],
                    lines[2],
                    lines[3],
                    lines[4],
                    lines[5],
                    Double.parseDouble(lines[6])));
        }
        return studentList;
    }

    public static List<Teacher> readTeacher(String pathFile) {
        List<Teacher> teacherList = new ArrayList<>();
        List<String> strings = readFromFile(pathFile);

        String[] lines;
        for (String s : strings) {
            lines = s.split(COMMA);
            teacherList.add(new Teacher(Integer.parseInt(lines[0]),
                    lines[1],
                    lines[2],
                    lines[3],
                    lines[4],
                    lines[5],
                    Double.parseDouble(lines[6]),
                    Double.parseDouble(lines[7])));
        }
        return teacherList;
    }
}
