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

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;

            // 3 + 5, 5 + 3은 같은 파티션으로 치지 않기 때문에 범위를 n / 2로 잡고
            // 중간까지만 돌며 중복을 없앤다.
            for (int j = 2; j <= n / 2; j++) {
                if (!isNotPrime[j] && !isNotPrime[n - j]) {
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
