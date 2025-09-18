public enum Grade {
    S(15_000),
    A(12_000),
    B(10_000),
    ;

    private final int price;

    Grade(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
