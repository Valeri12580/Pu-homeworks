public abstract class Engine {
    private int power;

    public Engine(int power) {
        this.power = power;
    }

    protected int getPower() {
        return power;
    }


    @Override
    public String toString() {
        return String.format("Power :%d",this.getPower());
    }
}
