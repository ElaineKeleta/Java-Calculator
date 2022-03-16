public class Calculator {
    private String xString;
    private String yString;
    private String opString;
    private int x;
    private int y;
    private char op;

    public Calculator(String xString, String yString, String opString)
    {
        this.xString = xString;
        this.yString = yString;
        this.opString = opString;
    }
    public int calculate(){
        convert();
        return switch (op) {
            case '+' -> add();
            case '-' -> subtract();
            case 'x' -> multiply();
            case '/' -> divide();
            default -> throw new IllegalArgumentException(
                    "Allowable operators are '+', '-', 'x', and '/'."
            );
        };


    }
    private void convert () {
        x= Integer.parseInt(xString);
        y= Integer.parseInt(yString);
        op= opString.charAt(0);
    }
    private
    int add(){
        return x+y;
    }
    int subtract(){
        return x-y;
    }
    int multiply(){
        return x*y;
    }
    int divide(){
        return x/y;
    }
    public static void main(String[] args){
        if (args.length !=3) {
            System.out.println(
                    "Usage: java calculator <a> <op> <b>," +
                            "where <a> and <b> are integers and <op>" +
                            "is one of '+','-','x','/'."
            );
        }
        Calculator calc= new Calculator(args[0],args[2], args[1]);
        int result = calc.calculate();
        System.out.printf("%s %s %s = %d\n", args[0],args[1],args[2], result);
    }
}

