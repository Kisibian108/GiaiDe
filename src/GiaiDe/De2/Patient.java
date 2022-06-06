package GiaiDe.De2;

public abstract class Patient {

    private static Integer countId;
    private Integer id;
    private String patientCode;
    private String medicalCode;
    private String name;
    private String enterDate;
    private String outDate;
    private String reason;

    public Patient() {
    }

    public Patient(Integer id, String patientCode, String medicalCode, String name, String enterDate, String outDate, String reason) {
        this.id = id;
        this.patientCode = patientCode;
        this.medicalCode = medicalCode;
        this.name = name;
        this.enterDate = enterDate;
        this.outDate = outDate;
        this.reason = reason;
    }

    public Patient(int id, String medicalCode, String name, String enterDate, String outDate, String reason) {
        this.id = id;
        this.medicalCode = medicalCode;
        this.name = name;
        this.enterDate = enterDate;
        this.outDate = outDate;
        this.reason = reason;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

    public static Integer getCountId() {
        return countId;
    }

    public static void setCountId(Integer countId) {
        Patient.countId = countId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicalCode() {
        return medicalCode;
    }

    public void setMedicalCode(String medicalCode) {
        this.medicalCode = medicalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public abstract String convertLine();

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", patientCode='" + patientCode + '\'' +
                ", medicalCode='" + medicalCode + '\'' +
                ", name='" + name + '\'' +
                ", enterDate='" + enterDate + '\'' +
                ", outDate='" + outDate + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
