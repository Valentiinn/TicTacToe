package com.karayvansky.game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class GridForm extends JPanel {

    private Board board;
    private JTextArea area;
    private List<JButton> buttons;

    public void setTextArea(JTextArea area) {
        this.area = area;
        area.append("\n" + board.getChangePlayer() + " " + board.getChangePlayer().getType() + " move!");
    }

    public GridForm(final Board board, List<JButton> buttons, final Statistics statistics) {

        this.board = board;
        this.buttons = buttons;

        Dimension dimension = new Dimension();
        dimension.width = 160;
        dimension.height = 160;

        LayoutManager layoutManager = new GridBagLayout();
        setLayout(layoutManager);

        GridBagConstraints gc = new GridBagConstraints();

        for (int i = 0; i < 9; i++) {
            final JButton button = new JButton("");
            button.setPreferredSize(dimension);

            int x = i / 3;
            int y = i % 3;

            gc.gridx = x;
            gc.gridy = y;

            button.setName(String.valueOf(x) + String.valueOf(y));
            button.setFont(new Font(null, Font.PLAIN, 80));
            add(button, gc);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // JButton btn = (JButton) e.getSource();
                    // String move = btn.getName();
                    //
                    // char type = board.makeMove(move);
                    // btn.setText(String.valueOf(type));
                    area.append(
                            "\n" + board.getChangePlayer() + " " + board.getChangePlayer().getType() + " made a move");
                    if (button.getText() == "") {
                        JButton btn = (JButton) e.getSource();
                        String move = btn.getName();

                        char type = board.makeMove(move);
                        btn.setText(String.valueOf(type));

                    }

                    if (board.gameFinished()) {
                        Player player = board.calculateWinner();
                        JOptionPane.showMessageDialog(null, "Game Finished. Winner: " + player);
                        area.append("\nWinner is " + player);
                        try {
                            statistics.addResult(new GameResult(board.calculateWinner(), "winn"));
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        try {
                            statistics.addResult(new GameResult(board.calculateLoser(), "lost"));
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            });
            buttons.add(button);
        }
    }

}
