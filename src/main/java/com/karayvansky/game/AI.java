package com.karayvansky.game;

import java.util.Random;

public class AI extends Player {

    public AI(char type) {
        super(type);

    }

    public String makeMove() {
        Random rnd = new Random();
        int x = rnd.nextInt(3);
        int y = rnd.nextInt(3);
        return String.valueOf(x) + String.valueOf(y);
    }
}
