import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Vladimir on 29/10/2017.
 */
public class Reader {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public int readFunc() throws IOException {
        System.out.println("Hello. Please choose one of the functions below:\n 1.y=x\n 2.y=sinx\n 3.y=sqrt(x)\n 4.y=e^x");
        try {
            int funcCode = Integer.parseInt(in.readLine());
            return funcCode;
        } catch (Exception e) {
            System.out.println("Input error while reading code of function, sorry");
            e.printStackTrace();
            return 0;
        }
    }

    public double[] readLimits() throws IOException {
        System.out.println("Enter limits of integration (from, to):");
        double [] doubleLimits = new double [2];
        try {
            String[] stringLimits = in.readLine().split(",",2);
            for (int i = 0; i<stringLimits.length; i++) {
                doubleLimits[i]=Double.parseDouble(stringLimits[i]);
            }
            return doubleLimits;
        } catch (Exception ex) {
            System.out.println("Input error while reading limits, sorry");
            return doubleLimits;
        }
    }

    public double readPrecision() throws IOException {
        System.out.println("Enter precision (e. g. 0.00001): ");
        double precision;
        try {
            precision = Double.parseDouble(in.readLine());
            return precision;
        } catch (Exception ex) {
            System.out.println("Input error while reading precision, sorry");
            return 0;
        }
    }
}
