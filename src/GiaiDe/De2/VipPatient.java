package GiaiDe.De2;

public class VipPatient extends Patient {

    private String typeVip;
    private String dueDate;

    public VipPatient() {
    }

    public VipPatient(String typeVip, String dueDate) {
        this.typeVip = typeVip;
        this.dueDate = dueDate;
    }

    public VipPatient(Integer id, String patientCode, String medicalCode, String name, String enterDate, String outDate, String reason, String typeVip, String dueDate) {
        super(id, patientCode, medicalCode, name, enterDate, outDate, reason);
        this.typeVip = typeVip;
        this.dueDate = dueDate;
    }

    public VipPatient(int id, String medicalCode, String name, String enterDate, String outDate, String reason, String typeVip, String dueDate) {
        super(id, medicalCode, name, enterDate, outDate, reason);
        this.typeVip = typeVip;
        this.dueDate = dueDate;
    }

    public String getTypeVip() {
        return typeVip;
    }

    public void setTypeVip(String typeVip) {
        this.typeVip = typeVip;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "VipPatient{" + super.toString() +
                "typeVip='" + typeVip + '\'' +
                ", dueDate='" + dueDate + '\'' +
                '}';
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
                this.getTypeVip() + COMMA +
                this.getDueDate();
    }
}
