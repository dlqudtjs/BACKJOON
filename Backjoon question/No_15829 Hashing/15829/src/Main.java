import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = (Integer.parseInt(br.readLine()));
        String str = br.readLine();
        BigInteger result = new BigInteger("0");

        for (int i = 0; i < n; i++) {
            result = result.add(BigInteger.valueOf(str.charAt(i) - 'a' + 1)
                    .multiply(BigInteger.valueOf(31).pow(i)));
        }

        System.out.println(result.remainder(BigInteger.valueOf(1234567891)));
    }
}
