import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2 {
	static StringBuilder sb;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] permutation = new int[m];
		check = new boolean[n];

		recursion(permutation, n, m, 0);

		System.out.println(sb);
	}

	static void recursion(int[] permutation, int n, int m, int depth) {
		if (m == depth) {
			for (int i : permutation) {
				sb.append(i).append(" ");
			}

			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			if (check[i]) {
				continue;
			}

			check[i] = true;
			permutation[depth] = i + 1;
			recursion(permutation, n, m, depth + 1);
			check[i] = false;
		}
	}
}
