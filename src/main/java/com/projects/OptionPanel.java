package com.projects;

import javax.swing.*;

public class OptionPanel extends JPanel {
    private final JTextField fileName = new JTextField(10);
    private final JButton saveButton = new JButton("Save");
    private final JButton loadButton = new JButton("Load");

    OptionPanel() {
        set();
    }

    private void set() {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        layout.setHorizontalGroup(layout
                .createSequentialGroup()
                .addComponent(fileName)
                .addComponent(saveButton)
                .addComponent(loadButton));
        layout.setVerticalGroup(layout
                .createParallelGroup()
                .addComponent(fileName)
                .addComponent(saveButton)
                .addComponent(loadButton));

        add(fileName);
        add(saveButton);
        add(loadButton);
    }

    public JTextField getFileName() {
        return fileName;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getLoadButton() {
        return loadButton;
    }
}
