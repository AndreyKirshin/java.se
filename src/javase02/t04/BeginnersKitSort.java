package javase02.t04;

import javase02.t03.*;

import java.util.Collections;
import java.util.Comparator;

public class BeginnersKitSort {
    private static final PriceComparatorDecrease priceCompDecrease = new PriceComparatorDecrease();
    private static final PriceComparatorIncrease priceCompIncrease = new PriceComparatorIncrease();
    private static final NameComparatorIncrease nameCompIncrease = new NameComparatorIncrease();
    private static final NameComparatorDecrease nameCompDecrease = new NameComparatorDecrease();
    private static final PriceAndNameComparator priceNameCompDecrease = new PriceAndNameComparator(priceCompDecrease, nameCompDecrease);
    private static final PriceAndNameComparator priceNameCompIncrease = new PriceAndNameComparator(priceCompIncrease, nameCompIncrease);


    public static void main(String[] args) {
        BeginnersKit kitForSort = new BeginnersKit();

        kitForSort.print();
        Collections.sort(kitForSort.getKit(), priceNameCompDecrease);
        kitForSort.print();
        Collections.sort(kitForSort.getKit(), priceNameCompIncrease);
        kitForSort.print();
    }
}
     class PriceComparatorDecrease implements Comparator<OfficeSupplies> {

        @Override
        public int compare(OfficeSupplies o1, OfficeSupplies o2) {
            return o1.getPrice() < o2.getPrice() ? 1 : o1.getPrice() == o2.getPrice() ? 0 : -1;
        }
    }

     class PriceComparatorIncrease extends PriceComparatorDecrease {
        @Override
        public int compare(OfficeSupplies o1, OfficeSupplies o2) {
            return -super.compare(o1, o2);
        }
    }

class NameComparatorIncrease implements Comparator<OfficeSupplies> {

    @Override
    public int compare(OfficeSupplies o1, OfficeSupplies o2) {
        String name1 = o1.getClass().getSimpleName();
        String name2 = o2.getClass().getSimpleName();

        return name1.compareTo(name2);
    }
}

class NameComparatorDecrease extends NameComparatorIncrease {
    @Override
    public int compare(OfficeSupplies o1, OfficeSupplies o2) {
        return -super.compare(o1, o2);
    }
}

class PriceAndNameComparator implements Comparator<OfficeSupplies> {
    private final Comparator<OfficeSupplies> c1;
    private final Comparator<OfficeSupplies> c2;

    public PriceAndNameComparator(Comparator<OfficeSupplies> c1, Comparator<OfficeSupplies> c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public int compare(OfficeSupplies o1, OfficeSupplies o2) {
        int res = c1.compare(o1, o2);
        if (res == 0) {
            res = c2.compare(o1, o2);
        }
        return res;
    }
}

