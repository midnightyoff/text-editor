package com.projects.panels;

import javax.swing.*;
import java.awt.*;

public enum Icons {

    NEXT("next.png"),
    PREV("previous.png"),
    SAVE("save.png"),
    LOAD("load.png"),
    SEARCH("search.png");

    private final ImageIcon icon;

    Icons(String filename) {
        ImageIcon icon = new ImageIcon(Icons.class.getResource("/icons/" + filename));
        Image image = icon.getImage();
        this.icon = new ImageIcon(image.getScaledInstance(25, 25, Image.SCALE_SMOOTH));
    }

    public ImageIcon getIcon() {
        return icon;
    }
}
