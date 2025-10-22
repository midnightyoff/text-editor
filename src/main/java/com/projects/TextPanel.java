package com.projects;

import javax.swing.*;

public class TextPanel extends JPanel {
    private final JTextArea textArea = new JTextArea();
    private final JScrollPane scrollPane = new JScrollPane(textArea);

    public TextPanel() {
        set();
    }

    private void set() {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        layout.setHorizontalGroup(layout
                .createParallelGroup()
                .addComponent(scrollPane));
        layout.setVerticalGroup(layout
                .createSequentialGroup()
                .addComponent(scrollPane));
        add(scrollPane);
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}
