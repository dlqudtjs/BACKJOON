import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        BigInteger num = new BigInteger("1");
        int count = 0;

        for (int i = 1; i <= n; i++) {
            num = num.multiply(BigInteger.valueOf(i));
        }

        while (true) {
            if (num.remainder(BigInteger.valueOf(10)).intValue() != 0) {
                break;
            }

            num = num.divide(BigInteger.valueOf(10));
            count++;
        }

        System.out.println(count);
    }
}
