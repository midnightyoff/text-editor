package com.projects;

import com.projects.panels.TextPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchEngine extends SwingWorker<List<int[]>, Void> {

    private final String text;
    private final String query;
    private final boolean useRegex;
    private final TextPanel textPanel;
    private List<int[]> matches;
    private int currentIndex;

    SearchEngine(String text, String query, boolean useRegex, TextPanel textPanel) {
        this.text = text;
        this.query = query;
        this.useRegex = useRegex;
        this.textPanel = textPanel;
    }

    @Override
    protected List<int[]> doInBackground() {
        return findMatches(text, query, useRegex);
    }

    @Override
    protected void done() {
        try {
            matches = get();
            if (!matches.isEmpty()) {
                selectText(matches.getFirst()[0], matches.getFirst()[1]);
                currentIndex = 0;
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private List<int[]> findMatches(String text, String query, boolean useRegex) {
        List<int[]> matches = new ArrayList<>();
        if (useRegex) {
            Pattern pattern = Pattern.compile(query);
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                int[] indexes = {matcher.start(), matcher.end()};
                matches.add(indexes);
            }
        } else {
            int index = 0;
            while (true) {
                index = text.indexOf(query, index);
                if (index == -1) {
                    break;
                }
                int[] indexes = {index, index + query.length()};
                matches.add(indexes);
                index += query.length();
            }
        }
        for (int[] indexes : matches) {
            System.out.println(Arrays.toString(indexes));
        }
        return matches;
    }

    private void selectText(int pos1, int pos2) {
        textPanel.getTextArea().setCaretPosition(pos2);
        textPanel.getTextArea().select(pos1, pos2);
        textPanel.getTextArea().grabFocus();
    }

    public void next() {
        if (!matches.isEmpty()) {
            currentIndex = (currentIndex + 1) % matches.size();
            selectText(matches.get(currentIndex)[0], matches.get(currentIndex)[1]);
        }
    }

    public void prev() {
        if (!matches.isEmpty()) {
            currentIndex = (currentIndex - 1 + matches.size()) % matches.size();
            selectText(matches.get(currentIndex)[0], matches.get(currentIndex)[1]);
        }
    }
}
