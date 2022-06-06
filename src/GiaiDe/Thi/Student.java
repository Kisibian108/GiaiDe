package GiaiDe.Thi;

public class Student extends Person {
    private Integer point;

    public Student() {
    }

    public Student(Integer point) {
        this.point = point;
    }

    public Student(int id, String name, Integer point) {
        super(id, name);
        this.point = point;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    @Override
    public String convertLine() {
        String comma = ",";
        return super.getId() + comma + super.getName() + comma + this.point;
    }

    @Override
    public String toString() {
        return "Student {" +
                super.toString() +
                ", point: " + point +
                '}';
    }
}
