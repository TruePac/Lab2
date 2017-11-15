import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Vladimir on 29/10/2017.
 */
public class Reader {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public int readFunc() throws IOException {
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
