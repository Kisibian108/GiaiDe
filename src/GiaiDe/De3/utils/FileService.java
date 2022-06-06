package GiaiDe.De3.utils;

import GiaiDe.De3.Model.Manager;
import GiaiDe.De3.Model.ProductionStaff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private static final String COMMA = ",";

    /**
     * Write to file
     */
    public static void writeToFile(String pathFile, List<String> strings) {
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

    public static void writeManager(String pathFile, List<Manager> managers) {
        List<String> strings = new ArrayList<>();

        for (Manager manager : managers) {
            strings.add(manager.convertLine());
        }
        writeToFile(pathFile, strings);
    }

    public static void writeProductionStaff(String pathFile, List<ProductionStaff> productionStaffs) {
        List<String> strings = new ArrayList<>();
        for (ProductionStaff productionStaff : productionStaffs) {
            strings.add(productionStaff.convertLine());
        }
        writeToFile(pathFile, strings);
    }

    /**
     * Read from file
     */
    public static List<String> readFromFile(String pathFile) {
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

    public static List<Manager> readManager(String pathFile) {
        List<Manager> managers = new ArrayList<>();
        List<String> strings = readFromFile(pathFile);

        String[] lines;
        for (String s : strings) {
            lines = s.split(COMMA);
            managers.add(new Manager(
                    Integer.parseInt(lines[0]),
                    Integer.parseInt(lines[1]),
                    lines[2], lines[3], lines[4],
                    Double.parseDouble(lines[5]),
                    Double.parseDouble(lines[6])));
        }
        return managers;
    }

    public static List<ProductionStaff> readProductionStaff(String pathFile) {
        List<ProductionStaff> productionStaff = new ArrayList<>();
        List<String> strings = readFromFile(pathFile);

        String[] lines;
        for (String s : strings) {
            lines = s.split(COMMA);
            productionStaff.add(new ProductionStaff
                    (Integer.parseInt(lines[0]),
                            Integer.parseInt(lines[1]),
                            lines[2], lines[3],
                            (lines[4]),
                            Integer.parseInt(lines[5]),
                            Double.parseDouble(lines[6])));
        }
        return productionStaff;
    }
}
