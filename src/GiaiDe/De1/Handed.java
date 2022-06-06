package GiaiDe.De1;

public class Handed extends Phone {
    private Integer countID;
    private String national;
    private String status;

    public Handed() {

    }

    public Handed(String national, String status) {
        this.national = national;
        this.status = status;
    }

    public Handed(Integer id, String name, double price, int amount, String production, String national, String status) {
        super(id, name, price, amount, production);
        this.national = national;
        this.status = status;
    }

    public Handed(Integer countID, String national, String status) {
        this.countID = countID;
        this.national = national;
        this.status = status;
    }

    public Handed(Integer id, String name, double price, int amount, String production, Integer countID, String national, String status) {
        super(id, name, price, amount, production);
        this.countID = countID;
        this.national = national;
        this.status = status;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCountID() {
        return countID;
    }

    public void setCountID(Integer countID) {
        this.countID = countID;
    }

    @Override
    public String toString() {
        return "Handed{" + super.toString() +
                "national='" + national + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public String convertLine() {
           String COMMA =",";
        return super.getId() + COMMA +
                super.getName() + COMMA +
                super.getPrice() + COMMA +
                super.getAmount() + COMMA +
                super.getProduction() + COMMA +
                this.getNational() + COMMA +
                this.status;
    }


}
