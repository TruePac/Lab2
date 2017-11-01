import java.io.IOException;
import java.math.BigDecimal;

import static java.lang.Math.log10;

/**
 * Created by Vladimir on 29/10/2017.
 */
public class Main {
    public static void main(String[] args) {
        Reader myReader = new Reader();
        Integrator myIntegrator = new Integrator();
        try {
           myIntegrator.setFunc(myReader.readFunc());
           myIntegrator.setLimits(myReader.readLimits());
           myIntegrator.setPrecision(myReader.readPrecision());
           double result[] = myIntegrator.integrate();
           double integrationResult = result[0];
           double fault = result[2];
           double myScale = log10(1/myIntegrator.getPrecision());
           System.out.println("Result: " + BigDecimal.valueOf(integrationResult).setScale((int) myScale, BigDecimal.ROUND_HALF_UP));
           System.out.println("Number of partitions: " + Math.round((myIntegrator.getLimits()[1]-myIntegrator.getLimits()[0])/myIntegrator.getPrecision()));
           System.out.println("Fault: " + BigDecimal.valueOf(fault).setScale(8, BigDecimal.ROUND_HALF_UP));
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
