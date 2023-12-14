import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3 {
	static StringBuilder sb;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] permutation = new int[n];
		check = new boolean[n];

		permutation(permutation, 0, n);

		System.out.println(sb);
	}

	private static void permutation(int[] permutation, int current, int depth) {
		if (current == depth) {
			for (int n : permutation) {
				sb.append(n).append(" ");
			}

			sb.append("\n");
			return;
		}

		for (int i = 0; i < depth; i++) {
			if (check[i]) {
				continue;
			}

			check[i] = true;
			permutation[current] = i + 1;
			permutation(permutation, current + 1, depth);
			check[i] = false;
		}
	}
}
