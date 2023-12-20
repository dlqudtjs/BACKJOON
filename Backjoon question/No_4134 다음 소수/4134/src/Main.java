import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            BigInteger value = new BigInteger(br.readLine());

            sb.append(value.isProbablePrime(10) ? value : value.nextProbablePrime());
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
