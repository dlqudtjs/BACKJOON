import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int MAX = 123456 * 2 + 1;
        boolean[] prime = new boolean[MAX];
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(MAX); i++) {
            if (prime[i]) {
                continue;
            }

            for (int j = i * i; j <= MAX; j += i) {
                prime[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while (n != 0) {
            int count = 0;

            // n보다 크고 2n보다 작거나 같은 소수의 수
            for (int i = n + 1; i <= n * 2; i++) {
                if (!prime[i]) {
                    count++;
                }
            }

            sb.append(count).append("\n");
            n = Integer.parseInt(br.readLine());
        }

        System.out.println(sb);
    }
}
