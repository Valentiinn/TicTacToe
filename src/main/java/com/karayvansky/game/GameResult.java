package com.karayvansky.game;

import java.util.Date;

public class GameResult implements Comparable {

    private Player player;
    private String result;
    private Date date;

    public GameResult(Player player, String result) {
        this.player = player;
        this.result = result;
        this.date = new Date();

    }

    public Player getPlayer() {
        return player;
    }

    public String getResult() {
        return result;
    }

    public Date getDate() {
        return date;
    }

    public String resForStatistic() {
        return result;
    }

    public String toString() {
        return player + "   " + result + "   " + date;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != GameResult.class) {
            return false;
        }
        GameResult gameResult = (GameResult) obj;
        if (this.player == null || this.result == null || this.date == null) {
            return false;
        }
        if (this.player.equals(gameResult) && this.date.equals(gameResult.date)
                && this.result.equals(gameResult.result)) {
            return true;
        }
        return false;

    }

    @Override
    public int compareTo(Object o) {
        GameResult gameResult = (GameResult) o;
        return this.player.compareTo(gameResult.player);
    }

}
