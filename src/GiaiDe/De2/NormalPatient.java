package GiaiDe.De2;

public class NormalPatient extends Patient {

    private double price;

    public NormalPatient() {
    }

    public NormalPatient(int id, String medicalCode, String name, String enterDate, String outDate, String reason) {
        super(id, medicalCode, name, enterDate, outDate, reason);
    }

    public NormalPatient(double price) {
        this.price = price;
    }

    public NormalPatient(Integer id, String patientCode, String medicalCode, String name, String enterDate, String outDate, String reason, double price) {
        super(id, patientCode, medicalCode, name, enterDate, outDate, reason);
        this.price = price;
    }

    public NormalPatient(int id, String medicalCode, String name, String enterDate, String outDate, String reason, double price) {
        super(id, medicalCode, name, enterDate, outDate, reason);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String convertLine() {
        String COMMA = ",";
        return super.getId() + COMMA +
                super.getMedicalCode() + COMMA +
                super.getName() + COMMA +
                super.getEnterDate() + COMMA +
                super.getOutDate() + COMMA +
                super.getReason() + COMMA +
                this.getPrice();
    }

    @Override
    public String toString() {
        return "NormalPatient{" + super.toString() +
                "price=" + price +
                '}';
    }
}
