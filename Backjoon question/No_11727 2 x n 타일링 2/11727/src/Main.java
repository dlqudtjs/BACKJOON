import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 2];

        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + (dp[i - 2] * 2)) % 10_007;
        }

        System.out.println(dp[n]);
    }
}

/*
 * 1 = 1
 * 2 = 3
 * 3 = 5
 * 4 = 11
 * 
 * 규칙을 찾으면 되는 문제이다. 점화식은 dp[i - 1] + (dp[i - 2] * 2) 이다.
 */