import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolutionService {
    private final BufferedReader reader;

    public SolutionService() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));

    }

    public void findTheSolution() {
        try {
            System.out.println("Enter a:");
            double a = Double.parseDouble(reader.readLine());

            System.out.println("Enter b:");
            double b = Double.parseDouble(reader.readLine());

            System.out.printf("The perimeter is: %.2f\n", MathFunctions.findParameter(a, b));
            System.out.printf("The face is: %.2f\n", MathFunctions.findFace(a, b));

        } catch (Exception e) {
            System.out.println("Invalid data!");
        }
    }
}
