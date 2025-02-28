package ex_02.strategy;

public class FlatDiscountStrategy implements PaymentProcessor{
    private double discount;

    public FlatDiscountStrategy(double discount) {
        this.discount = discount;
    }

    @Override
    public double calculateTotal(double total) {
        return total - this.discount;
    }
}
