package GiaiDe.De4.controller;

import GiaiDe.De4.service.CarImplement;
import GiaiDe.De4.service.MotorbikeImplement;
import GiaiDe.De4.service.TruckImplement;
import GiaiDe.De4.utils.CheckException;

import java.util.Scanner;

public class VehicleController {

    static Scanner scanner = new Scanner(System.in);
    static CarImplement carImplement = new CarImplement();
    static MotorbikeImplement motorbikeImplement = new MotorbikeImplement();
    static TruckImplement truckImplement = new TruckImplement();

    public static void displayMainMenu() {
        while (true) {
            System.out.println("CHUONG TRINH QUAN LY PHUONG TIEN GIAO THONG");
            System.out.println("Chon chuc nang");
            System.out.println("1. Them moi phuong tien");
            System.out.println("2. Hien thi phuong tien");
            System.out.println("3. Xoa phuong tien");
            System.out.println("4. Thoat");

            int choose = CheckException.checkParseInteger();
            switch (choose) {
                case 1:
                    System.out.println("1. Them moi xe tai");
                    System.out.println("2. Them moi o to");
                    System.out.println("3. Them moi xe may");
                    int choose1 = CheckException.checkParseInteger();
                    switch (choose1) {
                        case 1:
                        truckImplement.add();
                        break;
                        case 2:
                            carImplement.add();
                            break;
                        case 3:
                            motorbikeImplement.add();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1. Hien thi xe tai");
                    System.out.println("2. Hien thi o to");
                    System.out.println("3. Hien thi xe may");
                    int choose2 = CheckException.checkParseInteger();
                    switch (choose2) {
                        case 1:
                            truckImplement.display();
                            break;
                        case 2:
                            carImplement.display();
                            break;
                        case 3:
                            motorbikeImplement.display();
                            break;
                    }
                    break;

                case 3:
                    int choose3 = CheckException.checkParseInteger();
                    switch (choose3) {
                        case 1:
                            truckImplement.display();
                            break;
                        case 2:
                            carImplement.display();
                            break;
                        case 3:
                            motorbikeImplement.display();
                            break;
                    }

                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Chon lai");
            }
        }
    }

}