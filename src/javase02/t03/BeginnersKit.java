package javase02.t03;

import java.util.ArrayList;
import java.util.List;


public class BeginnersKit {
    private List<OfficeSupplies> kit = new ArrayList<>();

    public BeginnersKit(){
        kit.add(new Pen(10.2f, ColorThisIsWriting.BLUE));
        kit.add(new Pen(10.5f, ColorThisIsWriting.BLUE));
        kit.add(new Pen(10.4f, ColorThisIsWriting.RED));
        kit.add(new Pen(10.2f, ColorThisIsWriting.BLACK));
        kit.add(new Pencil(2.2f));
        kit.add(new Pencil(3.1f));
        kit.add(new Marker(5.53f, ColorThisIsWriting.ORANGE));
        kit.add(new Marker(5.3f, ColorThisIsWriting.GREEN));
        kit.add(new Corrector(13.3f));
        kit.add(new Puncher(20.7f));
        kit.add(new Stapler(15.6f));
        kit.add(new Note(16.7f));
        kit.add(new Sticers(2.2f));
        kit.add(new Clips(2.2f));
        kit.add(new Paper(6.3f));
    }

    public List<OfficeSupplies> getKit() {
        return kit;
    }

    public void print(){
        for(OfficeSupplies s : kit) {
            System.out.println(s);
        }
        System.out.println("===================");
    }

    public static void main(String[] args) {
       new BeginnersKit().print();
    }
}
