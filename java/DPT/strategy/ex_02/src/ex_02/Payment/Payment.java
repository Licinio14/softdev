package ex_02.Payment;

import ex_02.strategy.PaymentProcessor;

public class Payment {
    private PaymentProcessor paymentProcessor;

    public Payment(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public double calcularDisconto(double valor){
        return paymentProcessor.calculateTotal(valor);
    }
}
