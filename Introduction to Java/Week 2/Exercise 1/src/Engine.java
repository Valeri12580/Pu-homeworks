

public class Engine implements Runnable {
    private final SolutionService solutionService;

    public Engine() {
      solutionService=new SolutionService();
    }

    @Override
    public void run() {
        solutionService.findTheSolution();


    }
}
