package models.figures;

import models.figures.base.Figure;

public class King extends Figure {

    public King(String name, String description, String sign) {
        super(name, description, sign);
    }

    @Override
    public boolean isMoveValid(int rowDiff, int colDiff) {
        return Math.abs(rowDiff) == 1 || Math.abs(colDiff) == 1;
    }
}
