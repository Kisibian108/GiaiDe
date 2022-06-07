package GiaiDe.De5.Model;

public class Teacher extends Person {

    private String classRoom;
    private double salaryByHour;
    private double teachHourByMonth;

    public Teacher() {
    }

    public Teacher(String classRoom, double salaryByHour, double teachHourByMonth) {
        this.classRoom = classRoom;
        this.salaryByHour = salaryByHour;
        this.teachHourByMonth = teachHourByMonth;
    }

    public Teacher(Integer id, String name, String gender, String birthday, String address, String classRoom, double salaryByHour, double teachHourByMonth) {
        super(id, name, gender, birthday, address);
        this.classRoom = classRoom;
        this.salaryByHour = salaryByHour;
        this.teachHourByMonth = teachHourByMonth;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public double getSalaryByHour() {
        return salaryByHour;
    }

    public void setSalaryByHour(double salaryByHour) {
        this.salaryByHour = salaryByHour;
    }

    public double getTeachHourByMonth() {
        return teachHourByMonth;
    }

    public void setTeachHourByMonth(double teachHourByMonth) {
        this.teachHourByMonth = teachHourByMonth;
    }

    @Override
    public String toString() {
        return "Teacher{" + super.toString() +
                "classRoom='" + classRoom + '\'' +
                ", salaryByHour=" + salaryByHour +
                ", teachHourByMonth=" + teachHourByMonth +
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
                this.getClassRoom() + COMMA +
                this.getSalaryByHour() + COMMA +
                this.getTeachHourByMonth();
    }
}
