package javase02.t03;

import java.text.DecimalFormat;

/**
 * Created by 1 on 09.05.2017.
 */
public class UnknownSupplies extends OfficeSupplies {
    private String nameOfLatest;
    public UnknownSupplies(float price, String nameOfLatest) {
        super(price);
        this.nameOfLatest = nameOfLatest;
    }

    @Override
    public String toString() {
        return nameOfLatest +
                ", price: " + new DecimalFormat("#0.00").format(getPrice()) + "$";

    }
}
