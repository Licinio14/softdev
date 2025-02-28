package ex_02;

import ex_02.Payment.Payment;
import ex_02.strategy.FlatDiscountStrategy;
import ex_02.strategy.NoDiscountStrategy;
import ex_02.strategy.PercentageDiscountStrategy;

public class Main {
    public static void main(String[] args) {
        Payment paymentProcessor = new Payment(new NoDiscountStrategy());
        double total = paymentProcessor.calcularDisconto(100.0);
        System.out.println("Total sem desconto: " + total);

        paymentProcessor = new Payment(new FlatDiscountStrategy(10.0));
        total = paymentProcessor.calcularDisconto(100.0);
        System.out.println("Total com desconto fixo: " + total);

        paymentProcessor = new Payment(new PercentageDiscountStrategy(0.2));
        total = paymentProcessor.calcularDisconto(100.0);
        System.out.println("Total com desconto percentual: " + total);
    }
}
