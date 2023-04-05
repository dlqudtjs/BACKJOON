import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int maxValue = 0;

            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            int[][] dp = new int[2][n];

            // 배열 초기화
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            if (n >= 1) {
                dp[0][0] = arr[0][0];
                dp[1][0] = arr[1][0];
                maxValue = maxValue > Math.max(dp[0][0], dp[1][0]) ? maxValue : Math.max(dp[0][0], dp[1][0]);

                if (n >= 2) {
                    dp[0][1] = arr[1][0] + arr[0][1];
                    dp[1][1] = arr[0][0] + arr[1][1];
                    maxValue = maxValue > Math.max(dp[0][1], dp[1][1]) ? maxValue : Math.max(dp[0][1], dp[1][1]);
                }

            }

            for (int j = 2; j < n; j++) {
                dp[0][j] = Math.max(dp[1][j - 2], dp[1][j - 1]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j - 2], dp[0][j - 1]) + arr[1][j];

                maxValue = maxValue > Math.max(dp[0][j], dp[1][j]) ? maxValue : Math.max(dp[0][j], dp[1][j]);
            }

            sb.append(maxValue).append('\n');
        }

        System.out.println(sb);
    }
}
