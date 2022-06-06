package GiaiDe.De3.Model;

public abstract class Staff {
    private static Integer countId;
    private Integer id;
    private Integer code;
    private String name;
    private String birthday;
    private String address;

    public Staff() {
    }

    public Staff(Integer id, Integer code, String name, String birthday, String address) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
    }

    public static Integer getCountId() {
        return countId;
    }

    public static void setCountId(Integer countId) {
        Staff.countId = countId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public abstract String convertLine();

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
