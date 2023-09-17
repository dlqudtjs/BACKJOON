import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class practice1 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static boolean[][] nodes;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		nodes = new boolean[n + 1][n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			nodes[node1][node2] = true;
			nodes[node2][node1] = true;
		}

		bfs(v);

		System.out.println(sb);
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int x = queue.poll();
			sb.append(x).append(" ");

			for (int i = 1; i <= n; i++) {
				if (visited[i]) {
					continue;
				}

				if (nodes[x][i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
