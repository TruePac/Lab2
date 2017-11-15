import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Vladimir on 29/10/2017.
 */
public class Integrator {
    private Function myFunc;
    private double lowLimit;
    private double highLimit;
    private double precision;
    private double result;
    private double partitionNumber;
    private double runge;

    public Integrator (int n, double lowlimit, double highlimit, double prec ) {
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
        if (lowlimit>highlimit) {
            lowLimit = highlimit;
            highLimit = lowlimit;
        } else {
            lowLimit = lowlimit;
            highLimit = highlimit;
        }
        precision = prec;
    }


    public void setResult(double r) {
        this.result = r;
    }

    public void setPartitionNumber(double n) {
        this.partitionNumber = n;
    }

    public double getResult() {
        return this.result;
    }

    public double getPartitionNumber() {
        return this.partitionNumber;
    }

    public void setRunge(double runge) {
        this.runge = runge;
    }

    public double getRunge() {
        return this.runge;
    }

    public double getPrecision() {
        return this.precision;
    }

    public void integrate() {
        double range = highLimit - lowLimit;
        double partitionNumber = 0.5;
        double runge, oldResult, newResult;
        do {
            partitionNumber *= 2;
            double step = range / partitionNumber;
            oldResult = 0;
            double lowerLimit = lowLimit;
            for (int i = 0; i < partitionNumber; i++) {
                oldResult += (myFunc.calculate(lowerLimit) + myFunc.calculate(lowerLimit + step)) * step / 2;
                lowerLimit += step;
            }
            lowerLimit = lowLimit;
            step = step / 2;
            newResult = 0;
            for (int i = 0; i < 2 * partitionNumber; i++) {
                newResult += (myFunc.calculate(lowerLimit) + myFunc.calculate(lowerLimit + step)) * step / 2;
                lowerLimit += step;
            }
            runge = (oldResult - newResult) / 3;
        } while (runge > this.getPrecision());
        this.setResult(oldResult);
        this.setPartitionNumber(partitionNumber);
        this.setRunge(runge);
    }
}
