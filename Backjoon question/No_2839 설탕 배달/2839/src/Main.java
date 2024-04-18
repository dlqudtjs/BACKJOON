import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 4 || n == 7) {
            System.out.println(-1);
            return;
        }

        int[] dp = new int[n + 3];
        dp[3] = 1;
        dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            if (i == 7) {
                continue;
            }

            if (dp[i - 5] != 0) {
                dp[i] = dp[i - 5] + 1;
            } else {
                dp[i] = dp[i - 3] + 1;
            }
        }

        System.out.println(dp[n]);
    }
}

/*
 * 3 = 1
 * 5 = 1
 * 6 = 2 | 3 / 3
 * 8 = 2 | 5 / 3
 * 9 = 3 | 3 / 6
 * 10 = 2 | 5 / 5
 * 11 = 3 | 
 * 12 = 4
 * 13 = 3
 * 14 = 4
 * 15 = 3
 * 16 = 4
 * 17 = 5
 * 18 = 4
 * 19 = 5
 * 20 = 4
 */