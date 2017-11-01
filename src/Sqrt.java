import static java.lang.Math.sqrt;

/**
 * Created by Vladimir on 30/10/2017.
 */
public class Sqrt implements Function {
    @Override
    public double calculate(double arg) {
        if (arg<0) {
            System.out.println("Square root from negative number? Seriously?");
            System.exit(1);
        }
        return sqrt(arg);
    }
}
