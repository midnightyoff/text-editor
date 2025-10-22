package com.projects;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextEditor extends JFrame {
    private final TextPanel textPanel = new TextPanel();
    private final OptionPanel optionPanel = new OptionPanel();
    private final String path = System.getProperty("user.dir") + "/src/main/java/com/projects/data/";

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

        optionPanel.getLoadButton().addActionListener(e -> {
            String fileName = optionPanel.getFileName().getText();
            try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(path + fileName))) {
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
        });

        optionPanel.getSaveButton().addActionListener(e -> {
            String fileName = optionPanel.getFileName().getText();
            try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(path + fileName))) {
                bufferedWriter.write(textPanel.getTextArea().getText());
            } catch (IOException exception) {
                System.out.println("Error opening file: " + exception.getMessage());
            }
        });
    }
}
