import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i < n; i++) {
            if (i + getDigitTotal(i) == n) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }

    public static int getDigitTotal(int n) {
        int digitTotal = 0;

        while (true) {
            digitTotal += n % 10;

            if (n < 10) {
                break;
            }

            n /= 10;
        }

        return digitTotal;
    }
}
