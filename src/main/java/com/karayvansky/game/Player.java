package com.karayvansky.game;

public abstract class Player implements Comparable {

    private String firstName;
    private String lastName;
    private char type;

    public Player() {

    }

    public Player(char type) {
        // this.firstName = firstName;
        // this.lastName = lastName;
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public char getType() {
        return type;
    }

    @Override
    public int compareTo(Object o) {
        Player player = (Player) o;
        return this.firstName.compareTo(player.firstName);

    }

    public String toString() {
        return firstName + " " + lastName + " ";
    }

    public abstract String makeMove();

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != Player.class) {
            return false;
        }
        Player player = (Player) obj;
        if (this.firstName == null || this.getLastName() == null) {
            return false;
        }
        if (this.firstName.equals(player.firstName) && this.getLastName().equals(player.getLastName())
                && this.type == player.type) {
            return true;
        }

        return false;
    }

}

