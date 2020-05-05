package enums;

public enum Coordinates {
    A(0),
    B(1),
    C(2),
    D(3),
    E(4),
    F(5);

    private int value;

    Coordinates(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
