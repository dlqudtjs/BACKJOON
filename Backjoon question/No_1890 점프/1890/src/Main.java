import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[N][N];
        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] != 0 && map[i][j] != 0) {
                    int value = map[i][j];

                    if (j + value < N) {
                        dp[i][j + value] += dp[i][j];
                    }
                    if (i + value < N) {
                        dp[i + value][j] += dp[i][j];
                    }
                }
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}
