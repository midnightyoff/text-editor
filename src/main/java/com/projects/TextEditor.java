package com.projects;

import javax.swing.*;

public class TextEditor extends JFrame {
    TextEditor() {
        createBoxLayout();
        setFrame();
    }

    private void setFrame() {
        setTitle("Text Editor");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createBoxLayout() {
        JPanel panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);
        JTextArea textArea = new JTextArea("This is a text area");
        panel.add(textArea);
        add(panel);
    }
}
