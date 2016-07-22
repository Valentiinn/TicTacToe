package com.karayvansky.game;

import javax.swing.SwingUtilities;
import java.sql.SQLException;

public class BasicLayouts {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new MainForm();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
