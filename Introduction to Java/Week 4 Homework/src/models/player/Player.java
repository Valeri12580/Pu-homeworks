package models.player;

import data.Data;
import models.figures.base.Figure;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Player {
    private String name;
    private char color;
    private int moveCounter = 0;
    private Map<String, Figure> figures;


    public Player(String name, char color) {
        this.name = name;
        this.color = color;
        figures = new LinkedHashMap<>();

        this.init();

    }

    public char getColor() {
        return color;
    }

    public void increaseMoveCounter() {
        this.moveCounter++;
    }

    public int getMoveCounter() {
        return moveCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Figure> getFigures() {
        return Collections.unmodifiableMap(figures);
    }

    private void init() {
        Data.getFiguresDataAsList().forEach(e -> {
            figures.put(String.format("%s%s", this.color, e.getSign()), e);
        });

    }
}
