public class HeatEngine extends Engine {
    private double heatDegree;

    public HeatEngine(int power, double heatDegree) {
        super(power);
        this.heatDegree = heatDegree;
    }

    @Override
    public String toString() {
        return String.format("Max heat degree: %.2f--Creation rate per hour: %d",this.heatDegree,super.getPower());
    }
}
