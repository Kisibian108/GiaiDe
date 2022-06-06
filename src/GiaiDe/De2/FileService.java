package GiaiDe.De2;

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

    public static void writeNormal(String pathFile, List<NormalPatient> normalPatients) {
        List<String> strings = new ArrayList<>();

        for (NormalPatient normalPatient : normalPatients) {
            strings.add(normalPatient.convertLine());
        }
        writeToFile(pathFile, strings);
    }

    public static void writeVip(String pathFile, List<VipPatient> vipPatients) {
        List<String> strings = new ArrayList<>();
        for (VipPatient vipPatient : vipPatients) {
            strings.add(vipPatient.convertLine());
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

    public static List<NormalPatient> readNormal(String pathFile) {
        List<NormalPatient> normalPatients = new ArrayList<>();
        List<String> strings = readFromFile(pathFile);

        String[] lines;
        for (String s : strings) {
            lines = s.split(COMMA);
            normalPatients.add(new NormalPatient(Integer.parseInt(lines[0]), lines[1], lines[2], lines[3], lines[4], lines[5], Double.parseDouble(lines[6])));
        }
        return normalPatients;
    }

    public static List<VipPatient> readVip(String pathFile) {
        List<VipPatient> vipPatients = new ArrayList<>();
        List<String> strings = readFromFile(pathFile);

        String[] lines;
        for (String s : strings) {
            lines = s.split(COMMA);
            vipPatients.add(new VipPatient(Integer.parseInt(lines[0]), lines[1], lines[2], lines[3], lines[4], lines[5], lines[6], lines[7]));
        }
        return vipPatients;
    }
}
