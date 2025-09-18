package payment;

public enum PaymentMethod {
    CREDIT_CARD(0.95),
    CASH(0.98),
    ;

    private final double discountPercent;

    PaymentMethod(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }
}
