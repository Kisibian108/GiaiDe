package GiaiDe.De4.service;

import GiaiDe.De4.model.Car;
import GiaiDe.De4.model.Motorbike;
import GiaiDe.De4.utils.FileService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotorbikeImplement implements MotorbikeImpl {

    public Scanner scanner = new Scanner(System.in);
    static List<Motorbike> motorbikes = new ArrayList<>();
    public static final String MOTORBIKE = "src/GiaiDe/De4/data/oto.csv";

    @Override
    public void add() {
        motorbikes = FileService.readMotorbike(MOTORBIKE);

        if (motorbikes.isEmpty()) {
            Motorbike.setCountID(1);
        } else {
            int max = motorbikes.get(0).getId();
            for (Motorbike motorbike : motorbikes) {
                if (motorbike.getId() > max) {
                    max = motorbike.getId();
                }
            }
            Motorbike.setCountID(max);
            if (Motorbike.getCountID() == null) {
                Motorbike.setCountID(1);
            } else {
                Motorbike.setCountID(Car.getCountID() + 1);
            }
        }

        System.out.println("Nhap bien kiem soat");
        String plates = scanner.nextLine();

        System.out.println("Nhap hang san xuat");
        String productor = scanner.nextLine();

        System.out.println("Nhap nam san xuat");
        String year = scanner.nextLine();

        System.out.println("Nhap chu so huu");
        String name = scanner.nextLine();

        System.out.println("Nhap trong tai");
        String weight = scanner.nextLine();

        motorbikes.add(new Motorbike(Motorbike.getCountID(), plates, productor, year, name, weight));
        FileService.writeMotorbike(MOTORBIKE, motorbikes);
    }

    @Override
    public void display() {
        motorbikes = FileService.readMotorbike(MOTORBIKE);
        if (!motorbikes.isEmpty()) {
            for (Motorbike motorbike : motorbikes) {
                System.out.println(motorbike);
            }
        } else {
            System.out.println("List rong");
        }
    }

    @Override
    public void delete() {

    }
}
