package ex_02.strategy;

public class PercentageDiscountStrategy implements PaymentProcessor{
    private double discount;

    public PercentageDiscountStrategy(double discount) {
        this.discount = discount;
    }

    @Override
    public double calculateTotal(double total) {
        return total - (total * this.discount);
    }
}
