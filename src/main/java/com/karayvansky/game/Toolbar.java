package com.karayvansky.game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Date;

public class Toolbar extends JPanel {
    private Board board;
    private JButton statistic = new JButton("Statistics");
    private JButton clearBoard = new JButton("New Game");
    private JButton sortStaticWin = new JButton("Sort by wins");
    private JButton sortStaticLose = new JButton("Sort by lose");
    private List<JButton> buttons;
    private Date date;

    public void setButtons(List<JButton> buttons) {
        this.buttons = buttons;
    }

    public Toolbar(final Board board, final Statistics statistics) {
        this.board = board;
        this.date = new Date();
        LayoutManager layoutManager = new FlowLayout(FlowLayout.CENTER);
        setLayout(layoutManager);

        add(statistic, layoutManager);
        add(clearBoard, layoutManager);
        add(sortStaticWin, layoutManager);
        add(sortStaticLose, layoutManager);

        statistic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Player winner = board.calculateWinner();
                // Player louser = board.calculateLoser();
                statistics.sortByFirstnamePlayer();
                // JOptionPane.showMessageDialog(null,
                // "Game Finished. Winner: " + winner + " " + date + "\nLouser:
                // " + louser + " " + date);
                JOptionPane.showMessageDialog(null, statistics.toString());
            }
        });

        clearBoard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (JButton btn : buttons) {
                    btn.setText("");
                }
                board.clearBoard();
                // Player playerX = new Human("Ivanov", 'X');
                // playerX.setLastName("Ivan");
                // Player playerO = new AI("Petrov", 'O');
                // playerO.setLastName("Petr");
                //
                // Board board = new Board(playerX, playerO);
            }
        });

        sortStaticWin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                statistics.sortByWin();
                JOptionPane.showMessageDialog(null, statistics.toString());

            }
        });

        sortStaticLose.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                statistics.sortByLoss();
                JOptionPane.showMessageDialog(null, statistics.toString());

            }
        });

    }
}
