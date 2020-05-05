package models.figures;

import models.figures.base.Figure;

public class Queen extends Figure {

    public Queen(String name, String description, String sign) {
        super(name, description, sign);
    }

    @Override
    public boolean isMoveValid(int rowDiff, int colDiff) {
        return Math.abs(rowDiff) == 1 && Math.abs(colDiff) == 1;
    }
}
