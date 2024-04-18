import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][n];
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}

			dp[i][0] = arr[i][0];
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i][j - 1] + arr[i][j];
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());

			int result = 0;
			for (int j = y1; j <= y2; j++) {
				if (x1 == 1) {
					result += dp[j - 1][x2 - 1];
				} else {
					result += dp[j - 1][x2 - 1] - dp[j - 1][x1 - 2];
				}
			}

			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}
}
