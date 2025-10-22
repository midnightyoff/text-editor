package com.projects;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    JMenu menu = new JMenu("Menu");
    JMenuItem save = new JMenuItem("Save");
    JMenuItem load = new JMenuItem("Load");
    JMenuItem exit = new JMenuItem("Exit");
    MenuBar() {
        set();
    }

    private void set() {
        menu.add(save);
        menu.add(load);
        menu.add(exit);
        add(menu);
    }

    public JMenu getMenu() {
        return menu;
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
}
