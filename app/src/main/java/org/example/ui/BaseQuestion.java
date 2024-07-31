package org.example.ui;

import javax.swing.JOptionPane;

public class BaseQuestion {
    public static int show(String message) {
        return JOptionPane.showConfirmDialog(null, message, "Confirm", JOptionPane.YES_NO_OPTION);
    }
}
