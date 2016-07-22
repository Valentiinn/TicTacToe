package com.karayvansky.game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainForm extends JFrame {

    private JTextArea textArea;

    public MainForm() throws SQLException {
        super("Tic Tac Toe");
        Statistics statistics = Statistics.getInstance();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();
        int x = screen.width;
        int y = screen.height;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize((int) Math.round(x * 0.8), (int) Math.round(y * 0.8));
        setLocationRelativeTo(null);
        setVisible(true);

        LayoutManager layoutManager = new BorderLayout(5, 5);
        setLayout(layoutManager);

        textArea = new JTextArea();

        Dimension textAreaSize = textArea.getPreferredSize();
        // System.out.println(textAreaSize.width + ":" + textAreaSize.height);

        textAreaSize.width = 300;
        textAreaSize.height = 100;
        textArea.setPreferredSize(textAreaSize);

        Player playerX = new Human('X');
        playerX.setFirstName("Player");
        playerX.setLastName("1");
        Player playerO = new Human('O');
        playerO.setFirstName("Player");
        playerO.setLastName("2");

        Board board = new Board(playerX, playerO);

        List<JButton> list = new ArrayList<>();
        GridForm gridForm = new GridForm(board, list, statistics);
        gridForm.setTextArea(textArea);
        Toolbar toolbar = new Toolbar(board, statistics);
        toolbar.setButtons(list);

        add(textArea, BorderLayout.EAST);
        add(gridForm, BorderLayout.CENTER);
        add(toolbar, BorderLayout.NORTH);
    }
}
