package ex_02.strategy;

public class NoDiscountStrategy implements PaymentProcessor{


    @Override
    public double calculateTotal(double total) {
        return total;
    }
}
