package com.projects.panels;

import javax.swing.*;
import java.awt.*;

public class OptionPanel extends JPanel {

    private final JTextField searchField = new JTextField(10);
    private final JButton saveButton = new JButton(Icons.SAVE.getIcon());
    private final JButton loadButton = new JButton(Icons.LOAD.getIcon());
    private final JButton searchButton = new JButton(Icons.SEARCH.getIcon());
    private final JButton nextButton = new JButton(Icons.NEXT.getIcon());
    private final JButton prevButton = new JButton(Icons.PREV.getIcon());
    private final JCheckBox useRegExCheckBox = new JCheckBox("Use RegEx", false);


    public OptionPanel() {
        set();
    }

    private void set() {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        useRegExCheckBox.setFont(new Font("SansSerif", Font.BOLD, 16));

        layout.setHorizontalGroup(layout
                .createSequentialGroup()
                .addComponent(loadButton)
                .addComponent(saveButton)
                .addComponent(searchField)
                .addComponent(searchButton)
                .addComponent(prevButton)
                .addComponent(nextButton)
                .addComponent(useRegExCheckBox, 120, 120, 120));
        layout.setVerticalGroup(layout
                .createParallelGroup()
                .addComponent(loadButton)
                .addComponent(saveButton)
                .addComponent(searchField)
                .addComponent(searchButton)
                .addComponent(prevButton)
                .addComponent(nextButton)
                .addComponent(useRegExCheckBox, 35, 35, 35));
    }

    public JCheckBox getUseRegExCheckBox() {
        return useRegExCheckBox;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getLoadButton() {
        return loadButton;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public JButton getPrevButton() {
        return prevButton;
    }
}
