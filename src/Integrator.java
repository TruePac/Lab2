import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Vladimir on 29/10/2017.
 */
public class Integrator {
    private Function myFunc;
    private double[] myLimits = new double[2];
    private double precision;

    public void setFunc (int n) {
        switch (n) {
            case 1:
                myFunc = new Linear();
                break;
            case 2:
                myFunc = new Sinus();
                break;
            case 3:
                myFunc = new Sqrt();
                break;
            case 4:
                myFunc = new Exponent();
                break;
            default:
                System.out.println("Sorry. Such function do not exist(");
                System.exit(1);
        }
    }

    public void setLimits (double[] limits) {
        for (int i =0; i<limits.length; i++) {
            this.myLimits[i]=limits[i];
        }
    }

    public double[] getLimits () {
        return this.myLimits;
    }

    public void setPrecision (double prec) {
        this.precision = prec;
    }

    public double getPrecision() {
        return this.precision;
    }

    public double[] integrate() {
        if (myLimits[0]>myLimits[1]) {
            double buf = myLimits[0];
            myLimits[0]=myLimits[1];
            myLimits[1]= buf;
        }
        double range = myLimits[1] - myLimits[0];
        double partitionNumber = range/precision;
        double fragment = range/partitionNumber;
        double[] result = new double[3];
        double lowerLimit = myLimits[0];
        for (int i = 0; i<partitionNumber; i++) {
            result[0] += (myFunc.calculate(lowerLimit)+myFunc.calculate(lowerLimit+fragment))*fragment/2;
            lowerLimit += fragment;
        }
        lowerLimit = myLimits[0];
        fragment = fragment/2;
        for (int i = 0; i<2*partitionNumber; i++) {
            result[1] += (myFunc.calculate(lowerLimit)+myFunc.calculate(lowerLimit+fragment))*fragment/2;
            lowerLimit += fragment;
        }
        result[2]=(result[1]-result[0])/3;
        return result;
    }
}
