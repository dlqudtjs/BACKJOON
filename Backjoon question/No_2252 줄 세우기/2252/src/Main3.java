import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3 {
	static List<List<Integer>> nodes;
	static int[] entryCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		nodes = new ArrayList<>();
		entryCount = new int[n + 1];

		for (int i = 0; i < n + 1; i++) {
			nodes.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());

			nodes.get(front).add(back);

			entryCount[back]++;
		}

		System.out.println(topologySort());
	}

	private static String topologySort() {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i < entryCount.length; i++) {
			if (entryCount[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current).append(" ");

			for (Integer i : nodes.get(current)) {
				entryCount[i]--;

				if (entryCount[i] == 0) {
					queue.add(i);
				}
			}
		}

		return sb.toString();
	}
}