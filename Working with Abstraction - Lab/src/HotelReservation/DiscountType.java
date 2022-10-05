package HotelReservation;

public enum DiscountType {
    VIP(0.80),
    SecondVisit(0.90),
    None(1);

    private double priceWithDiscount;

    DiscountType(double priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }

    public double getPriceWithDiscount() {
        return priceWithDiscount;
    }
}
