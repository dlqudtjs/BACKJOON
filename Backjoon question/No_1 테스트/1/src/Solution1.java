import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution1 {
	static int Answer;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (b > a) {
				int temp = a;
				a = b;
				b = temp;
			}

			for (int i = 0; (i * a) < n; i++) {
				if ((n - (i * a)) % b == 0) {
					Answer = i + (n - (i * a)) / b;
					break;
				}
			}

			sb.append("Case #").append(test_case + 1).append("\n").append(Answer).append("\n");
		}

		System.out.println(sb);
	}
}