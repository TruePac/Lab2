import static java.lang.Math.E;
import static java.lang.Math.pow;

/**
 * Created by Vladimir on 30/10/2017.
 */

public class Exponent implements Function {
    @Override
    public double calculate(double arg) {
        return pow(E,arg);
    }
}
