import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());

        System.out.println((a * b) / gcd(Math.max(a, b), Math.min(a, b)));
    }

    private static long gcd(long bigNumber, long smallNumber) {
        if (bigNumber % smallNumber == 0) {
            return smallNumber;
        }

        long divideNumber = bigNumber % smallNumber;

        return gcd(smallNumber, divideNumber);
    }
}
