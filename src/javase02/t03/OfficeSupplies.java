package javase02.t03;

import java.text.DecimalFormat;

public abstract class OfficeSupplies {
    private float price = 0;

    public OfficeSupplies(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                ", price: " + new DecimalFormat("#0.00").format(price) +
                "$";
    }
}
