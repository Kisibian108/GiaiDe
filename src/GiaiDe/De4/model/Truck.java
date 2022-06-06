package GiaiDe.De4.model;

public class Truck extends Vehicle {

    private String tonnage;

    public Truck() {
    }

    public Truck(String tonnage) {
        this.tonnage = tonnage;
    }

    public Truck(Integer countID, String licensePlates, String productor, String year, String owner, String tonnage) {
        super(countID, licensePlates, productor, year, owner);
        this.tonnage = tonnage;
    }

    public String getTonnage() {
        return tonnage;
    }

    public void setTonnage(String tonnage) {
        this.tonnage = tonnage;
    }

    @Override
    public String toString() {
        return "Truck{" + super.toString() +
                "tonnage='" + tonnage + '\'' +
                '}';
    }

    @Override
    public String convertLine() {
        String COMMA = ",";
        return super.getLicensePlates() + COMMA +
                super.getProductor() + COMMA +
                super.getYear() + COMMA +
                super.getOwner() + COMMA +
                this.getTonnage();
    }
}
