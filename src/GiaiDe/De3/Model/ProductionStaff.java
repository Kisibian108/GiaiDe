package GiaiDe.De3.Model;

public class ProductionStaff extends Staff {

    private Integer amount;
    private double price;

    public ProductionStaff() {
    }

    public ProductionStaff(Integer id, Integer code, String name, String birthday, String address, Integer amount, double price) {
        super(id, code, name, birthday, address);
        this.amount = amount;
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductionStaff{" + super.toString() +
                "amount=" + amount +
                ", price=" + price +
                '}';
    }

    @Override
    public String convertLine() {
        String COMMA = ",";
        return super.getId() + COMMA +
                super.getCode() + COMMA +
                super.getName() + COMMA +
                super.getBirthday() + COMMA +
                super.getAddress() + COMMA +
                this.getAmount() + COMMA +
                this.getPrice();
    }
}
