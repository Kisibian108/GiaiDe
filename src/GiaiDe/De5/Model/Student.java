package GiaiDe.De5.Model;

public class Student extends Person {

    private String idStudent;
    private double point;

    public Student() {
    }

    public Student(String idStudent, double point) {
        this.idStudent = idStudent;
        this.point = point;
    }

    public Student(Integer id, String name, String gender, String birthday, String address, String idStudent, double point) {
        super(id, name, gender, birthday, address);
        this.idStudent = idStudent;
        this.point = point;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                "idStudent='" + idStudent + '\'' +
                ", point=" + point +
                '}';
    }

    @Override
    public String convertLine() {
        String COMMA = ",";
        return super.getId() + COMMA +
                super.getName() + COMMA +
                super.getGender() + COMMA +
                super.getBirthday() + COMMA +
                super.getAddress() + COMMA +
                this.getIdStudent() + COMMA +
                this.getPoint();
    }
}
