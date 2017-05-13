package javase02.t06;

import javase02.t07.AnnotationForSubmarineClass;

@AnnotationForSubmarineClass
public class NuclearSubmarine {
    private boolean inSwimming;

    private class EngineForSubmarine {
        boolean startEngine() {
            return true;
        }
    }

    public void setInSwimming(boolean inSwimming) {
        this.inSwimming = inSwimming;
    }

    public static void main(String[] args) {
        NuclearSubmarine firstSubmarine = new NuclearSubmarine();

        System.out.println("Is the Submarine in swimming before startEngine? Answer: " + firstSubmarine.inSwimming);

        firstSubmarine.setInSwimming(firstSubmarine.new EngineForSubmarine().startEngine());

        System.out.println("Is the Submarine in swimming after startEngine? Answer: " + firstSubmarine.inSwimming);
    }
}

