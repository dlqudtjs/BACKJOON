import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int answer = 0;

        boolean[] prime = new boolean[n + 1];
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (prime[i]) {
                continue;
            }

            for (int j = i * i; j <= n; j += i) {
                prime[j] = true;
            }
        }

        for (int i = k + 1; i <= n; i++) {
            if (!prime[i]) {
                primes.add(i);
            }
        }

        for (int i = 1; i <= n; i++) {
            boolean flag = false;

            for (int j : primes) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
