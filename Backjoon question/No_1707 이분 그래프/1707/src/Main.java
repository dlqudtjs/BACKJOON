import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] nodes;
    static int visited[];
    static int V, E;
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            flag = false;
            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            nodes = new ArrayList[V + 1]; // 한 노드에 연결돼 있는 노드가 여러개 있을 수 있다.
            visited = new int[V + 1];

            for (int j = 0; j <= V; j++) {
                nodes[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int node = Integer.parseInt(st.nextToken());
                int nextNode = Integer.parseInt(st.nextToken());

                nodes[node].add(nextNode); // 현재 노드와 연결된 노드를 node배열에 넣는다.
                nodes[nextNode].add(node); // 반대도 넣어줌
            }

            Queue<Integer> queue = new LinkedList<>();

            for (int j = 1; j < V; j++) {
                if (visited[j] == 0) { // 방문하지 않았다면 queue에 넣고 1로 초기화한다.
                    queue.add(j);
                    visited[j] = 1;
                    bfs(j, queue);
                }

                if (flag) {
                    sb.append("NO").append("\n");
                    break;
                }
            }

            if (!flag) {
                sb.append("YES").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void bfs(int n, Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int j = 0; j < nodes[now].size(); j++) {
                if (visited[nodes[now].get(j)] == 0) { // 연결된 노드의 가중치가 없다면
                    // 현재 노드와 반대로 연결 노드의 가중치를 설정한다.
                    if (visited[now] == 1) {
                        visited[nodes[now].get(j)] = 2;
                    } else {
                        visited[nodes[now].get(j)] = 1;
                    }

                    // 그 후 연결 노드를 queue에 넣는다.
                    queue.add(nodes[now].get(j));
                }

                // 현재 노드와 연결된 노드의 가중치가 같다면 이분 그래프가 아니다.
                if (visited[nodes[now].get(j)] == visited[now]) {
                    flag = true;
                    return;
                }
            }
        }
    }
}

/*
 * 참고로 모두 떨어진 노드는 이분 그래프이다.
 */