import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mod = 9901;

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][3];

        Arrays.fill(dp[1], 1);

        for (int i = 0; i < 3; i++) {
            for (int j = 2; j <= N; j++) {
                dp[j][0] = (dp[j - 1][0] + dp[j - 1][1] + dp[j - 1][2]) % mod;
                dp[j][1] = (dp[j - 1][0] + dp[j - 1][2]) % mod;
                dp[j][2] = (dp[j - 1][0] + dp[j - 1][1]) % mod;
            }
        }

        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % mod);
    }
}
