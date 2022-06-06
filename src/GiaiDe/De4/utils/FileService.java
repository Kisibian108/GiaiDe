package GiaiDe.De4.utils;

import GiaiDe.De4.model.Car;
import GiaiDe.De4.model.Motorbike;
import GiaiDe.De4.model.Truck;
import GiaiDe.Thi.Student;
import GiaiDe.Thi.Teacher;

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

    public static void writeCar(String pathFile, List<Car> cars) {
        List<String> strings = new ArrayList<>();

        for (Car car : cars) {
            strings.add(car.convertLine());
        }
        writeToFile(pathFile, strings);
    }

    public static void writeMotorbike(String pathFile, List<Motorbike> motorbikes) {
        List<String> strings = new ArrayList<>();
        for (Motorbike motorbike : motorbikes) {
            strings.add(motorbike.convertLine());
        }
        writeToFile(pathFile, strings);
    }

    public static void writeTruck(String pathFile, List<Truck> trucks) {
        List<String> strings = new ArrayList<>();
        for (Truck truck : trucks) {
            strings.add(truck.convertLine());
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

    public static List<Car> readCar(String pathFile) {
        List<Car> cars = new ArrayList<>();
        List<String> strings = readFromFile(pathFile);

        String[] lines;
        for (String s : strings) {
            lines = s.split(COMMA);
            cars.add(new Car(Integer.parseInt(lines[0]),
                    lines[1],
                    lines[2],
                    lines[3], lines[4],
                    Integer.parseInt(lines[5]),
                           lines[6]));
        }
        return cars;
    }

    public static List<Motorbike> readMotorbike(String pathFile) {
        List<Motorbike> motorbikes = new ArrayList<>();
        List<String> strings = readFromFile(pathFile);

        String[] lines;
        for (String s : strings) {
            lines = s.split(COMMA);
            motorbikes.add(new Motorbike(Integer.parseInt(lines[0]),
                    lines[1],
                    lines[2],
                    lines[3],
                    lines[4],
                    lines[5]));
        }
        return motorbikes;
    }

    public static List<Truck> readTruck(String pathFile) {
        List<Truck> trucks = new ArrayList<>();
        List<String> strings = readFromFile(pathFile);

        String[] lines;
        for (String s : strings) {
            lines = s.split(COMMA);
            trucks.add(new Truck(Integer.parseInt(lines[0]),
                    lines[1],
                    lines[2],
                    lines[3],
                    lines[4],
                    lines[5]));
        }
        return trucks;
    }
}
