package GiaiDe.De1;

public class Genuine extends Phone {
    private Integer countID;
    private int insuarance;
    private String range;

    public Genuine() {
    }

    public Genuine(int insuarance, String range) {
        this.insuarance = insuarance;
        this.range = range;
    }

    public Genuine(int id, String name, double price, int amount, String production, Integer insuarance, String range) {
        super(id, name, price, amount, production);
        this.insuarance = insuarance;
        this.range = range;
    }

    public Genuine(Integer countID, int insuarance, String range) {
        this.countID = countID;
        this.insuarance = insuarance;
        this.range = range;
    }

    public Genuine(Integer id, String name, double price, int amount, String production, Integer countID, int insuarance, String range) {
        super(id, name, price, amount, production);
        this.countID = countID;
        this.insuarance = insuarance;
        this.range = range;
    }

    public Integer getCountID() {
        return countID;
    }

    public void setCountID(Integer countID) {
        this.countID = countID;
    }

    public int getInsuarance() {
        return insuarance;
    }

    public void setInsuarance(int insuarance) {
        this.insuarance = insuarance;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    @Override
    public String convertLine() {
        String COMMA =",";
        return super.getId() + COMMA +
                super.getName() + COMMA +
                super.getPrice() + COMMA +
                super.getAmount() + COMMA +
                super.getProduction() + COMMA +
                this.getInsuarance() + COMMA +
                this.getRange();
    }

    @Override
    public String toString() {
        return "Genuine{" + super.toString() +
                "insuarance='" + insuarance + '\'' +
                ", range='" + range + '\'' +
                '}';
    }
}
