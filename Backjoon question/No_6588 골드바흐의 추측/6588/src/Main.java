import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    final static int MAX = 1000001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] isNotPrime = new boolean[MAX];

        isNotPrime[1] = true;
        for (int i = 2; i < Math.sqrt(MAX); i++) {
            if (isNotPrime[i]) {
                continue;
            }

            for (int j = i * i; j < MAX; j += i) {
                isNotPrime[j] = true;
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            boolean flag = false;

            if (n == 0) {
                System.out.println(sb);
                break;
            }

            for (int i = n - 3; i >= 3; i--) {
                if (!isNotPrime[i] && !isNotPrime[n - i]) {
                    sb.append(n).append(" = ").append(n - i).append(" + ").append(i).append("\n");
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                sb.append("Goldbach's conjecture is wrong.").append("\n");
            }
        }
    }
}
