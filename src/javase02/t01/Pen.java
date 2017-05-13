package javase02.t01;

import java.text.DecimalFormat;

public class Pen {
    private float price;
    private String producerName;
    private Color color;

    public Pen() {
        price = 15.00f;
        producerName = "Parker";
        color = Color.BLUE;
    }

    public Pen(float price, String producerName, Color color) {
        this.price = price;
        this.producerName = producerName;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(null == o) return false;
        if (getClass() != o.getClass()) return false;

        Pen pen = (Pen) o;

        if (Float.compare(pen.price, price) != 0) return false;
        if(null == producerName) return false;

        if (!producerName.equals(pen.producerName)) return false;

        if(null == pen.color) return false;
        return color == pen.color;
    }

    @Override
    public int hashCode() {
        int result = (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + producerName.hashCode();
        result = 31 * result + color.hashCode();
        return result;
    }

    @Override
    public String toString() {
        String pattern = "#0.00";

        return String.format("Pen \n price: %s $ \n producer: '%s' \n color: %s \n ===========",new DecimalFormat(pattern).format(price) , producerName, color);
    }

    private enum Color {
        BLUE,
        RED,
        BLACK;
    }

    private String toWrite() {
        return "Some text";
    }

    private String toPoint() {
        return "Some target";
    }

    public static void main(String[] args) {
        Pen p1 = new Pen();
        Pen p2 = new Pen();
        Pen p3 = new Pen(20, "Pilot", Color.BLACK);
        Pen p4 = new Pen(20, null, Color.BLACK);
        Pen p5 = new Pen(20, "Pilot", Color.BLACK);

        System.out.println(p1.hashCode() + " " + p2.hashCode() + " " + p3.hashCode());

        System.out.println(p2);
        System.out.println(p3);

    }
}
