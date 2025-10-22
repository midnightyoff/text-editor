package com.projects;

import com.projects.menu.MenuBar;
import com.projects.panels.OptionPanel;
import com.projects.panels.TextPanel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Objects;


public class TextEditor extends JFrame {
    private final TextPanel textPanel = new TextPanel();
    private final OptionPanel optionPanel = new OptionPanel();
    private final MenuBar menuBar = new MenuBar();
    private final JFileChooser fileChooser = new JFileChooser();
    private SearchEngine searchEngine;

    TextEditor() {
        workSpace();
        setFrame();
    }

    private void setFrame() {
        setTitle("Text Editor");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void workSpace() {
        setLayout(new BorderLayout());
        add(textPanel, BorderLayout.CENTER);
        add(optionPanel, BorderLayout.NORTH);
        setJMenuBar(menuBar);

        fileChooser.setDialogTitle("Choose Text File");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Text File", "txt"));
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir") + "/src/main/java/com/projects/data/"));

        ActionListener load = (e -> {
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                    StringBuilder text = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        text.append(line);
                        text.append("\n");
                    }
                    textPanel.getTextArea().setText(text.toString());
                } catch (IOException exception) {
                    System.out.println("Error opening file: " + exception.getMessage());
                }
            }
        });

        ActionListener save = (e -> {
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
                    bufferedWriter.write(textPanel.getTextArea().getText());
                } catch (IOException exception) {
                    System.out.println("Error opening file: " + exception.getMessage());
                }
            }
        });

        ActionListener setCheckBox = (e -> {
            boolean newState = !optionPanel.getUseRegExCheckBox().isSelected();
            optionPanel.getUseRegExCheckBox().setSelected(newState);
        });

        ActionListener findText = (e -> {
            if (!Objects.equals(textPanel.getTextArea().getText(), "") && !Objects.equals(optionPanel.getSearchField().getText(), "")) {
                searchEngine = new SearchEngine(textPanel.getTextArea().getText(), optionPanel.getSearchField().getText(), optionPanel.getUseRegExCheckBox().isSelected(), textPanel);
                searchEngine.execute();
            }
        });

        ActionListener next = (e -> {
            if (searchEngine != null) {
                searchEngine.next();
            }
        });

        ActionListener prev = (e -> {
            if (searchEngine != null) {
                searchEngine.prev();
            }
        });

        optionPanel.getSaveButton().addActionListener(save);
        optionPanel.getLoadButton().addActionListener(load);
        optionPanel.getSearchButton().addActionListener(findText);
        optionPanel.getNextButton().addActionListener(next);
        optionPanel.getPrevButton().addActionListener(prev);
        menuBar.getSave().addActionListener(save);
        menuBar.getLoad().addActionListener(load);
        menuBar.getUseRegex().addActionListener(setCheckBox);
        menuBar.getExit().addActionListener(e -> this.dispose());
        menuBar.getStartSearch().addActionListener(findText);
        menuBar.getNextMatch().addActionListener(next);
        menuBar.getPrevMatch().addActionListener(prev);

    }
}
