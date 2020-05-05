package data;

import models.figures.*;
import models.figures.base.Figure;

import java.util.Arrays;
import java.util.List;

public class Data {
    public static List<Figure> getFiguresDataAsList() {
        return Arrays.asList(new Dwarf("Dwarf",
                        "Move one square forward. If reach the end of the board is entitled to be bring back the same traffic rules", "DwL")
                , new Dwarf("Dwarf",
                        "Move one square forward. If reach the end of the board is entitled to be bring back the same traffic rules", "DwR")
                , new MachineGun("Machine Gun", "One box in all directions (excluding diagonals).", "M"),
                new Horse("Horse", "Two squares in all directions, but only and only within the third stroke of the corresponding color of the figures. In another time don't move from your position.", "D")
                , new King("King", "One box in all directions including and diagonals.", "K")
                , new Queen("Queen", "One box diagonally only.", "Q"));
    }
}
