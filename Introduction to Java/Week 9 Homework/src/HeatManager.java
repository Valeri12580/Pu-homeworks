import java.util.List;

public class HeatManager implements Printer {
    private static int count=1;
    private int id;
    private List<Engine> heatEngines;
    private List<Engine> wrapperEngines;

    public HeatManager(List<Engine> heatEngines, List<Engine> wrapperEngines) {
        this.id=count++;
        this.heatEngines = heatEngines;
        this.wrapperEngines = wrapperEngines;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("HeadManager number: %d\n", id));
        sb.append("Heat Engines:").append(System.lineSeparator());
        sb.append(this.heatEngines.toString()).append(System.lineSeparator());

        sb.append("Wrapper Engines:").append(System.lineSeparator());
        sb.append(this.wrapperEngines.toString()).append(System.lineSeparator());
        return sb.toString();
    }

    @Override
    public void print() {
        System.out.println(this.toString());

    }
}
