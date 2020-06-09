public  class Machine implements Printer {

    private int power;
    private int height;
    private String color;
    private Person operator;

    public Machine(int power, int height, String color, Person operator) {
        this.power = power;
        this.height = height;
        this.color = color;
        this.operator = operator;
    }

    @Override
    public String toString() {
        return String.format("Power: %d,Height: %d,Color: %s,Operator: %s",this.power,this.height,this.color,this.operator.getName());
    }


    @Override
    public void print() {
        System.out.println(this.toString());
    }
}
