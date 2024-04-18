import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1 {
	static PriorityQueue<Node> queue = new PriorityQueue<>();
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int result = 0;
		dp = new int[v + 1];

		for (int i = 1; i <= v; i++) {
			dp[i] = i;
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			queue.add(new Node(from, to, weight));
		}

		// PriorityQueue의 경우 foreach로 순환할 경우 우선순위에 따라서 순환하지 않는다.
		// poll 메서드가 마지막 노드의 값을 root로 올려 아래의 값과 비교하여 heapify를 재구성하기
		// 때문에 poll 메서드를 사용해야한다.
		for (int i = 0; i < e; i++) {
			Node node = queue.poll();
			if (union(node.from, node.to)) {
				result += node.weight;
			}
		}

		System.out.println(result);
	}

	private static boolean union(int from, int to) {
		int fromParent = find(from);
		int toParent = find(to);

		if (fromParent == toParent) {
			return false;
		}

		if (fromParent > toParent) {
			dp[fromParent] = toParent;
		} else {
			dp[toParent] = fromParent;
		}

		return true;
	}

	private static int find(int v) {
		if (dp[v] == v) {
			return v;
		}

		return find(dp[v]);
	}
}

class Node implements Comparable<Node> {
	int from;
	int to;
	int weight;

	public Node(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o1) {
		return this.weight - o1.weight;
	}
}
