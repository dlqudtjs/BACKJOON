import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
	static int n;
	static int[] entryCount;
	static int[] time;
	static List<List<Integer>> buildings;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		entryCount = new int[n + 1];
		time = new int[n + 1];
		buildings = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			buildings.add(new ArrayList<>());
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			time[i] = Integer.parseInt(st.nextToken());

			int count = st.countTokens() - 1;
			for (int j = 0; j < count; j++) {
				int building = Integer.parseInt(st.nextToken());

				buildings.get(building).add(i);
				entryCount[i]++;
			}
		}

		int[] result = topologySort();

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(result[i]).append("\n");
		}

		System.out.println(sb);
	}

	private static int[] topologySort() {
		Queue<Integer> queue = new LinkedList<>();
		int[] result = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			result[i] = time[i];

			if (entryCount[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (Integer i : buildings.get(current)) {
				result[i] = Math.max(result[i], result[current] + time[i]);

				entryCount[i]--;
				if (entryCount[i] == 0) {
					queue.add(i);
				}
			}
		}

		return result;
	}
}
