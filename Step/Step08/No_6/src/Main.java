import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static boolean prime[] = new boolean[10001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        get_prime();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            // 짝수를 2로 나눈 수가 소수가 아니라면
            // 하나씩 ++ --를 하게 되면 두 수가 모두 소수일 경우가 나오게된다. (하나씩 확인해봄)
            int first = n / 2;
            int second = n / 2;

            while (true) {
                if (!prime[first] && !prime[second]) {
                    sb.append(first).append(' ').append(second).append('\n');
                    break;
                }
                // 작은 거 부터 출력하기 위해 first를 감소시킨다.
                first--;
                second++;
            }
        }

        System.out.println(sb);
    }

    public static void get_prime() {
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i]) {
                continue;
            }

            for (int j = i * i; j <= prime.length - 1; j += i) {
                prime[j] = true;
            }
        }
    }
}
