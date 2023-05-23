import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] graph;
    static char[] visited;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            flag = false;
            st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            inputGraph(V, E);

            visited = new char[V + 1];
            visited[1] = 'L';

            for (int j = 1; j <= V; j++) {
                checkGraph(j);
            }

            if (flag) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void checkGraph(int n) {
        if (graph[n] == 0) {
            return;
        }
        int node = graph[n];

        if (visited[n] != '\0') { // 이미 값을 가지고 있을 때
            if (visited[n] == visited[node]) {
                flag = true;
                return;
            }

            if (visited[node] != '\0') {
                return;
            }

            if (visited[n] == 'L') {
                visited[node] = 'R';
            } else {
                visited[node] = 'L';
            }

            return;
        }

        if (visited[node] != '\0') { // n과 이어져 있는 node가 값을 가지고 있을 때
            if (visited[node] == 'L') {
                visited[n] = 'R';
            } else {
                visited[n] = 'L';
            }

            return;
        }

        if (visited[n] == 'L') { // n과 n이 이어지는 노드가 값을 가지고 있지 않을 때
            visited[node] = 'R';
        } else {
            visited[node] = 'L';
        }

        checkGraph(node);
    }

    private static void inputGraph(int V, int E) throws Exception {
        graph = new int[V + 1];

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph[node1] = node2;
        }
    }
}
