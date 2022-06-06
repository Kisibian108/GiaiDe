package GiaiDe.De4.model;

public abstract class Vehicle {

    private static Integer countID;
    private Integer id;
    private String licensePlates;
    private String productor;
    private String year;
    private String owner;

    public Vehicle() {
    }

    public Vehicle(Integer countID, String licensePlates, String productor, String year, String owner) {
        this.countID = countID;
        this.licensePlates = licensePlates;
        this.productor = productor;
        this.year = year;
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static Integer getCountID() {
        return countID;
    }

    public static void setCountID(Integer countID) {
        Vehicle.countID = countID;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public abstract String convertLine();

    @Override
    public String toString() {
        return "Vehicle{" +
                "countID=" + countID +
                ", licensePlates='" + licensePlates + '\'' +
                ", productor='" + productor + '\'' +
                ", year='" + year + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
