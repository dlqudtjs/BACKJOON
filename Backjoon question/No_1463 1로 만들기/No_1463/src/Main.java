import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        dp[1] = 0; // 1은 연산이 필요없기 때문에 0으로 초기화 (이를 시작으로 N까지 구한다.)

        for (int i = 2; i <= N; i++) {
            // 어떤 경우에나 1은 뺄 수 있기 때문에 1을 뺀 경우부터 num을 구한다.
            // num(앞서 구한 최소 경우의 수)
            int num = dp[i - 1] + 1;

            // 위에서 1을 뺀 경우의 수와 2로 나눌 수 있는 경우의 수를 비교하여 최소 경우의 수를 비교한다.
            if (i % 2 == 0) {
                num = Math.min(dp[i / 2] + 1, num);
            }

            // 위와 같음
            if (i % 3 == 0) {
                num = Math.min(dp[i / 3] + 1, num);
            }

            // 그 후 현재 수의 최소 경우의 수를 갱신한다. (다른 수의 최적의 수를 구하는데 사용됨)
            dp[i] = num;
        }

        System.out.println(dp[N]);
    }
}
