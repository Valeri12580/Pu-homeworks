package models.figures.base;

import java.util.Objects;

public abstract class Figure {
    private String name;
    private String description;
    private String sign;


    public Figure(String name, String description, String sign) {
        this.name = name;
        this.description = description;
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSign() {
        return sign;
    }

    abstract public boolean isMoveValid(int rowDiff, int colDiff);

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Figure figure = (Figure) o;
        return name.equals(figure.name) &&
                description.equals(figure.description) &&
                sign.equals(figure.sign);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, sign);
    }
}
