package models.figures;

import models.figures.base.Figure;

public class Dwarf extends Figure {
    private boolean hasRightToGoBack = false;
    private String playerColor;
    private int counter = 0;

    public Dwarf(String name, String description, String sign) {
        super(name, description, sign);
    }

    @Override
    public boolean isMoveValid(int rowDiff, int colDiff) {
        //Може и по-добре да стане,но не остана време ,пък и главата ми е бъркотия...
        int rowDiffExpectedValue = playerColor.equals("w") ? -1 : 1;

        if (!hasRightToGoBack) {
            if (rowDiff == rowDiffExpectedValue && colDiff == 0) {
                counter++;
                if (counter == 5) {
                    hasRightToGoBack = true;
                }

                return true;
            }

        } else {
            rowDiffExpectedValue *= -1;
            if (rowDiff == rowDiffExpectedValue && colDiff == 0) {
                counter--;
                if (counter == 0) {
                    hasRightToGoBack = true;
                }
                return true;
            }

        }
        return false;


    }

    public void setPlayerColor(String playerColor) {
        this.playerColor = playerColor;
    }
}
