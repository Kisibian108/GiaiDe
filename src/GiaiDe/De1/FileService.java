package GiaiDe.De1;

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

    public static void writeGenuine(String pathFile, List<Genuine> genuines) {
        List<String> strings = new ArrayList<>();

        for (Genuine genuine : genuines) {
            strings.add(genuine.convertLine());
        }
        writeToFile(pathFile, strings);
    }

    public static void writeHandle(String pathFile, List<Handed> handeds) {
        List<String> strings = new ArrayList<>();
        for (Handed handed : handeds) {
            strings.add(handed.convertLine());
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

    public static List<Genuine> readGenuine(String pathFile) {
        List<Genuine> genuines = new ArrayList<>();
        List<String> strings = readFromFile(pathFile);

        String[] lines;
        for (String s : strings) {
            lines = s.split(COMMA);
            genuines.add(new Genuine(Integer.parseInt(lines[0]), lines[1], Double.parseDouble(lines[2]), Integer.parseInt(lines[3]), lines[4],Integer.parseInt(lines[5]), lines[6]));
        }
        return genuines;
    }

    public static List<Handed> readHandle(String pathFile) {
        List<Handed> handeds = new ArrayList<>();
        List<String> strings = readFromFile(pathFile);

        String[] lines;
        for (String s : strings) {
            lines = s.split(COMMA);
            handeds.add(new Handed(Integer.parseInt(lines[0]),lines[1],Double.parseDouble(lines[2]),Integer.parseInt(lines[3]), lines[4],lines[5], lines[6]));
        }
        return handeds;
    }
//    public Handed(Integer id, String name, double price, int amount, String production, String national, String status) {
//        super(id, name, price, amount, production);
//        this.national = national;
//        this.status = status;
//    }
}
