import java.util.List;

public class Main {
    public static void main(String[] args) {
        Machine[] machines = {new Machine(15, 30, "Red", new Person("Valeri")), new Machine(35, 2, "Blue", new Person("Pesho"))};

        print(machines);


       HeatManager[]managers={new HeatManager(List.of(new HeatEngine(15, 37.2), new HeatEngine(300, 1500)),
               List.of(new WrapperEngine(135), new WrapperEngine(232))),
               new HeatManager(List.of(new HeatEngine(13123, 37.132), new HeatEngine(321300, 1654500)),
                       List.of(new WrapperEngine(1332135), new WrapperEngine(3213232)))};


       print(managers);
    }


    private static void print(Printer[]data){
        for (Printer m : data) {
            m.print();
        }
    }
}
