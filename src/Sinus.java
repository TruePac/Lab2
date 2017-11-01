import static java.lang.Math.sin;

/**
 * Created by Vladimir on 30/10/2017.
 */
public class Sinus implements Function {
    @Override
    public double calculate(double arg) {
        return sin(arg);
    }
}
