import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];

        int max = -1;

        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = max < arr[i] ? arr[i] : max;
        }

        int[][] dp = new int[max + 2][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= max; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(dp[arr[i]][0]).append(" ").append(dp[arr[i]][1]).append("\n");
        }

        System.out.println(sb);
    }
}
