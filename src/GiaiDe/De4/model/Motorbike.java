package GiaiDe.De4.model;

public class Motorbike extends Vehicle {

    private String wattage;

    public Motorbike() {
    }

    public Motorbike(Integer countID, String licensePlates, String productor, String year, String owner, String wattage) {
        super(countID, licensePlates, productor, year, owner);
        this.wattage = wattage;
    }

    public String getWattage() {
        return wattage;
    }

    public void setWattage(String wattage) {
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return "Motorbike{" + super.toString() +
                "wattage='" + wattage + '\'' +
                '}';
    }

    @Override
    public String convertLine() {
        String COMMA = ",";
        return super.getLicensePlates() + COMMA +
                super.getProductor() + COMMA +
                super.getYear() + COMMA +
                super.getOwner() + COMMA +
                this.getWattage();
    }
}
