import java.io.IOException;
import java.math.BigDecimal;

import static java.lang.Math.log10;

/**
 * Created by Vladimir on 29/10/2017.
 */
public class Main {
    public static void main(String[] args) {
        Reader myReader = new Reader();
        try {
            System.out.println("Hello. Please choose one of the functions below:\n 1.y=x\n 2.y=sinx\n 3.y=sqrt(x)\n 4.y=e^x");
            int funcCode = myReader.readFunc();
            System.out.println("Enter limits of integration (from, to):");
            double[] limits = myReader.readLimits();
            double lowlimit = limits[0];
            double highlimit = limits[1];
            System.out.println("Enter precision (e. g. 0.00001): ");
            double precision = myReader.readPrecision();
            Integrator myIntegrator = new Integrator(funcCode, lowlimit, highlimit, precision);
            myIntegrator.integrate();
            double integrationResult = myIntegrator.getResult();
            double runge = myIntegrator.getRunge();
            double myScale = log10(1/myIntegrator.getPrecision());
            System.out.println("Result: " + BigDecimal.valueOf(integrationResult).setScale((int) myScale, BigDecimal.ROUND_HALF_UP));
            System.out.println("Number of partitions: " + myIntegrator.getPartitionNumber());
            System.out.println("Fault: " + BigDecimal.valueOf(runge).setScale(8, BigDecimal.ROUND_HALF_UP));
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
