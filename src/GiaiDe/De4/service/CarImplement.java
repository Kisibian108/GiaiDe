package GiaiDe.De4.service;

import GiaiDe.De1.NotFoundCarException;
import GiaiDe.De4.model.Car;
import GiaiDe.De4.utils.CheckException;
import GiaiDe.De4.utils.FileService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarImplement implements CarImpl {

    public Scanner scanner = new Scanner(System.in);
    static List<Car> cars = new ArrayList<>();
    public static final String CAR = "src/GiaiDe/De4/data/oto.csv";

    public static void main(String[] args) {
        CarImplement carImplement = new CarImplement();
        carImplement.add();
    }
    @Override
    public void add() {
        cars = FileService.readCar(CAR);

        if (cars.isEmpty()) {
            Car.setCountID(1);
        } else {
            int max = cars.get(0).getId();
            for (Car car : cars) {
                if (car.getId() > max) {
                    max = car.getId();
                }
            }
            Car.setCountID(max);
            if (Car.getCountID() == null) {
                Car.setCountID(1);
            } else {
                Car.setCountID(Car.getCountID() + 1);
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

        System.out.println("Nhap so cho ngoi");
        int seats = CheckException.checkParseInteger();

        System.out.println("Nhap kieu xe");
        String type = scanner.nextLine();

        cars.add(new Car(Car.getCountID(), plates, productor, year, name, seats, type));
        FileService.writeCar(CAR, cars);

    }

    @Override
    public void display() {
        cars = FileService.readCar(CAR);
        if (!cars.isEmpty()) {
            for (Car car : cars) {
                System.out.println(car);
            }
        } else {
            System.out.println("List rong");
        }
    }

    @Override
    public void delete() {
        cars = FileService.readCar(CAR);
        do {
            cars = FileService.readCar(CAR);
            System.out.println("Nhập id cần xóa: ");
            String plates = scanner.nextLine();
            for (Car car : cars) {
                if (car.getLicensePlates().equals(plates)) {
                    System.out.println("Bạn có muốn xóa hay không? 1.Yes ; 2. No");
                    int choose1 = CheckException.checkParseInteger();
                    switch (choose1) {
                        case 1:
                            cars.remove(car);
                            FileService.writeCar(CAR, cars);
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
                throw new NotFoundCarException("Xe không tồn tại");
            } catch (NotFoundCarException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
}
