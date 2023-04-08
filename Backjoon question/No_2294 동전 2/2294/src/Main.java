import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] dp = new int[k + 1];

        Arrays.fill(dp, 100001);

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] > k) {
                continue;
            }

            dp[arr[i]] = 1;

            for (int j = arr[i]; j <= k; j++) {
                // dp[j - arr[i]] + 1 의 + 1를 하는 이유는 ex) 6 일 때 5를 빼고 남은 1의 dp와 비교를 해야 한다.
                // 여기서 5를 빼주는 게 연산이기 때문에 +1를 해준다.
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }

        dp[k] = dp[k] <= 100000 ? dp[k] : -1;

        System.out.println(dp[k]);
    }
}
