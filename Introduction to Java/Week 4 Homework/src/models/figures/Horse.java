package models.figures;

import models.figures.base.Figure;

public class Horse extends Figure {
    private int moveCounter;

    public Horse(String name, String description, String sign) {
        super(name, description, sign);
    }

    public void setMoveCounter(int moveCounter) {
        this.moveCounter = moveCounter;
    }

    @Override
    public boolean isMoveValid(int rowDiff, int colDiff) {
        return (Math.abs(rowDiff) == 2 || Math.abs(colDiff) == 2) && this.moveCounter % 3 == 0;
    }
}
