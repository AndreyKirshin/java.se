package javase02.t06;

import javase02.t07.AnnotationForSubmarineClass;

@AnnotationForSubmarineClass(
        author = "Kirshin A.",
        version = "1.0",
        date = "08/05/2017"
)
public class NuclearSubmarine {
    private final EngineForSubmarine engineForSubmarine = new EngineForSubmarine();

    /**
     * Sends the Submarine to sail and stops it
     * @param c command to start or stop sail
     * @return is the Submarine in sailing or not?
     */
    private boolean swim(CommandsForSubmarine c) {
        if(c.equals(CommandsForSubmarine.START)) {
            return engineForSubmarine.startEngine();
        } else return engineForSubmarine.stopEngine();
    }

    private enum CommandsForSubmarine {
        START,
        STOP,
    }

    /**
     * Creates the engine for the Submarine
     */
    private class EngineForSubmarine {
        boolean startEngine() {
            return true;
        }
        boolean stopEngine() {
            return false;
        }
    }

    public static void main(String[] args) {
        NuclearSubmarine firstSubmarine = new NuclearSubmarine();

        System.out.println("Is the Submarine swimming after command START? Answer: " + firstSubmarine.swim(CommandsForSubmarine.START));
        System.out.println("Is the Submarine swimming after command stop? Answer: " + firstSubmarine.swim(CommandsForSubmarine.STOP));
    }
}

