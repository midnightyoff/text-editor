package com.projects.menu;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    JMenu fileMenu = new JMenu("File");
    JMenu searchMenu = new JMenu("Search");
    JMenuItem save = new JMenuItem("Save");
    JMenuItem load = new JMenuItem("Load");
    JMenuItem exit = new JMenuItem("Exit");
    JMenuItem startSearch = new JMenuItem("Start search");
    JMenuItem prevMatch = new JMenuItem("Previous search");
    JMenuItem nextMatch = new JMenuItem("Next match");
    JMenuItem useRegex = new JMenuItem("Use regular expressions");

    public MenuBar() {
        set();
    }

    private void set() {
        fileMenu.add(save);
        fileMenu.add(load);
        fileMenu.add(exit);
        searchMenu.add(startSearch);
        searchMenu.add(prevMatch);
        searchMenu.add(nextMatch);
        searchMenu.add(useRegex);
        add(fileMenu);
        add(searchMenu);
    }

    public JMenu getFileMenu() {
        return fileMenu;
    }

    public JMenu getSearchMenu() {
        return searchMenu;
    }

    public JMenuItem getSave() {
        return save;
    }

    public JMenuItem getLoad() {
        return load;
    }

    public JMenuItem getExit() {
        return exit;
    }

    public JMenuItem getUseRegex() {
        return useRegex;
    }

    public JMenuItem getNextMatch() {
        return nextMatch;
    }

    public JMenuItem getPrevMatch() {
        return prevMatch;
    }

    public JMenuItem getStartSearch() {
        return startSearch;
    }
}
