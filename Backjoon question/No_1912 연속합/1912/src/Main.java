import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];

        st = new StringTokenizer(br.readLine());
        dp[0] = Integer.parseInt(st.nextToken());
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());

            dp[i] = Math.max(dp[i - 1] + x, x);

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
