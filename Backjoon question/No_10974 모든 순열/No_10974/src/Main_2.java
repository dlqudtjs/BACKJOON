import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2 {
	static StringBuilder sb;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[] permutation = new int[n];
		check = new boolean[n];

		recursion(permutation, n, 0);

		System.out.println(sb);
	}

	static void recursion(int[] permutation, int n, int depth) {
		if (depth == n) {
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
			recursion(permutation, n, depth + 1);
			check[i] = false;
		}
	}
}
