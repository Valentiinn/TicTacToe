package com.karayvansky.game;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Statistics {
    private List<GameResult> results = new ArrayList<GameResult>();
    private static Statistics instance = null;
    Connection connection;
    private DataBase dataBase = new DataBase();

    private Statistics() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tictactoe?serverTimezone=UTC&useSSL=false", "root", "123456");
    }

    public static Statistics getInstance() throws SQLException {
        if (instance == null) {
            instance = new Statistics();
        }

        return instance;
    }

    public void addResult(GameResult result) throws SQLException {
        //results.add(result);
        this.results.add(result);
        try {
            this.dataBase.isConnect();
            this.dataBase.addStatistics(result);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortByFirstnamePlayer() {
        Collections.sort(results);
    }

    public void sortByWin() {
        Collections.sort(results, new Comparator<GameResult>() {
            @Override
            public int compare(GameResult gameResultFirst, GameResult gameResultSecond) {

                if (gameResultFirst.resForStatistic().equals("winn")) {
                    if (gameResultSecond.resForStatistic().equals("winn"))
                        return 0;

                    if (gameResultSecond.resForStatistic().equals("lost"))
                        return -1;
                }

                if (gameResultFirst.toString().equals("lost")) {
                    if (gameResultSecond.resForStatistic().equals("winn"))
                        return 1;
                    if (gameResultSecond.resForStatistic().equals("lost"))
                        return 0;
                }

                return 0;
            }
        });
    }

    public void sortByLoss() {
        Collections.sort(results, new Comparator<GameResult>() {
            @Override
            public int compare(GameResult gameResultFirst, GameResult gameResultSecond) {

                if (gameResultFirst.resForStatistic().equals("winn")) {
                    if (gameResultSecond.resForStatistic().equals("winn"))
                        return 0;
                    if (gameResultSecond.resForStatistic().equals("lost"))
                        return 1;
                }

                if (gameResultFirst.resForStatistic().equals("lost")) {
                    if (gameResultSecond.resForStatistic().equals("winn"))
                        return -1;
                    if (gameResultSecond.resForStatistic().equals("lost"))
                        return 0;
                }

                return 0;
            }
        });
    }

    public String toString() {
        String printRes = "";
        for (int i = 0; i < results.size(); i++) {
            // Collections.sort(results);
            GameResult gameResult = results.get(i);
            printRes += gameResult.toString() + '\n';
        }
        return printRes;
    }

}
