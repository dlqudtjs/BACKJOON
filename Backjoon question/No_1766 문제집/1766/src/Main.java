import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Node>[] nodes;
    static int[] indegree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        indegree = new int[n + 1];
        nodes = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nodes[u].add(new Node(u, v));
            indegree[v]++;
        }

        bfs(n);

        System.out.println(sb);
    }

    private static void bfs(int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            // n은 이미 사용했기 때문에 변수명 now
            int now = pq.poll();
            sb.append(now).append(" ");

            for (Node node : nodes[now]) {
                indegree[node.v]--;

                if (indegree[node.v] == 0) {
                    pq.add(node.v);
                }
            }
        }
    }

    static class Node {
        int u;
        int v;

        public Node(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }
}

/*
 * 원래 위상정렬의 답은 여러개이나, 해당 문제의 조건에는 낮은 순서로 출력해야 함으로 답이 정해져있다.
 * 따라서, 원래 위상정렬을 하는 queue에서 priorityQueue로 바꿔준다면 45번 줄에서 진입차수가 0인 정점만
 * 우선으로 탐색하기 때문에 낮은 순서로 자연스레 출력이 된다.
 */