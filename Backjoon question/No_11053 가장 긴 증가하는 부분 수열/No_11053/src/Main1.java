import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 1;
		for (int i = 0; i < n; i++) {
			dp[i] = 1;

			for (int j = 0; j < i; j++) {
				if (arr[j] >= arr[i]) {
					continue;
				}

				if (dp[i] > dp[j]) {
					continue;
				}

				dp[i] = dp[j] + 1;
			}

			answer = Math.max(answer, dp[i]);
		}

		System.out.println(answer);
	}
}
