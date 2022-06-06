package GiaiDe.De4.model;

public class Car extends Vehicle{

    private int seats;
    private String typeCar;

    public Car() {
    }

    public Car(int seats, String typeCar) {
        this.seats = seats;
        this.typeCar = typeCar;
    }

    public Car(Integer countID, String licensePlates, String productor, String year, String owner, int seats, String typeCar) {
        super(countID, licensePlates, productor, year, owner);
        this.seats = seats;
        this.typeCar = typeCar;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    @Override
    public String toString() {
        return "Car{" + super.toString() +
                "seats=" + seats +
                ", typeCar='" + typeCar + '\'' +
                '}';
    }

    @Override
    public String convertLine() {
        String COMMA = ",";
        return super.getLicensePlates() + COMMA +
                super.getProductor() + COMMA +
                super.getYear() + COMMA +
                super.getOwner() + COMMA +
                this.getSeats() + COMMA +
                this.getTypeCar();
    }
}
