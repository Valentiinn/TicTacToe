package com.karayvansky.game;
import java.util.Scanner;

public class Human extends Player {

    public Human(char type) {
        super(type);
    }

    public String makeMove() {
        Scanner scanner = new Scanner(System.in);
        String move = scanner.next();
        return move;
    }
}
