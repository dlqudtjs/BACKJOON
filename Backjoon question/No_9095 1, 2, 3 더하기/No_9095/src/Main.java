import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] dp = new int[11];

            dp[0] = 1; // 0부터 시작
            dp[1] = 2;
            dp[2] = 4;

            for (int j = 3; j < n; j++) {
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }

            sb.append(dp[n - 1]).append('\n');
        }

        System.out.println(sb);
    }
}

/*
 * 다이나믹 프로그래밍 알고리즘을 활용해 풀었다.
 * dp[1] = 1 한 가지이다.
 * dp[2] = 1 + 1, 2 두 가지이다.
 * dp[3] = 1 + 1 + 1, 1 + 2, 2 + 1, 3 네 가지이다.
 * dp[4]
 * 1 + 1 + 1 + 1
 * 1 + 2 + 1
 * 2 + 1 + 1
 * 3 + 1 <- 여기 까지 dp[3]이랑 같다 (뒤에 붙는 + 1은 떼고)
 * 
 * 1 + 1 + 2
 * 2 + 2 <- 여기 까지 dp[2]랑 같다. (뒤에 붙는 + 2은 떼고)
 * 
 * 1 + 3 <- 여기 까지 dp[1]이랑 같다. (뒤에 붙는 + 3은 떼고)
 * 으로 7가지 이다.
 * 이와 같이 dp[4] = dp[3] + dp[2] + dp[1]의 점화식이 세워지게 된다.
 * 위의 점화식은 n이 4이상일 때 적용이 된다.
 * 
 * 참고 블로그 https://lotuslee.tistory.com/43
 */