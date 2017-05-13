package javase02.t03;


import java.text.DecimalFormat;

public abstract class ThingsToWrite extends OfficeSupplies {
    private ColorThisIsWriting colorThisIsWriting;

    public ThingsToWrite(float price, ColorThisIsWriting colorThisIsWriting) {
        super(price);
        this.colorThisIsWriting = colorThisIsWriting;
    }

    @Override
    public String toString() {
        String pattern = "#0.00";

        return String.format("%s %s, price: %s$", getClass().getSimpleName(), colorThisIsWriting, new DecimalFormat(pattern).format(super.getPrice()));
    }
}
