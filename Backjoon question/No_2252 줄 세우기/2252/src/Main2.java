import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
	static StringBuilder sb = new StringBuilder();
	static List<Node>[] nodes;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		dp = new int[n + 1];
		nodes = new ArrayList[n + 1];

		for (int i = 0; i <= n; i++) {
			nodes[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			nodes[from].add(new Node(from, to));
			dp[to]++;
		}

		topologicalSort();

		System.out.println(sb);
	}

	private static void topologicalSort() {
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i < dp.length; i++) {
			if (dp[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current).append(" ");

			for (int i = 0; i < nodes[current].size(); i++) {
				Node nextNode = nodes[current].get(i);

				dp[nextNode.getTo()]--;

				if (dp[nextNode.getTo()] == 0) {
					queue.add(nextNode.getTo());
					dp[nextNode.getTo()] = -1;
				}
			}
		}
	}
}

class Node {
	private int from;
	private int to;

	public Node(int from, int to) {
		this.from = from;
		this.to = to;
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}
}
