package util;

import java.util.Random;

public class Dado {
    private static Random random = new Random();

    public static int rolar() {
        return random.nextInt(6) + 1;
    }
}
