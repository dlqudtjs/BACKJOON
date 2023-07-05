import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Node>[] nodes;
    static int[] dp;

    public static void main(String[] args) throws Exception {
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
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            nodes[v].add(new Node(v, u));

            // 초기 진입차수 설정
            dp[u]++;
        }

        for (int i = 1; i <= n; i++) {
            // 진입차수가 0인 정점만 bfs 설정 (스페셜 저지 문제이기 때문에 답이 여러개이다.)
            if (dp[i] == 0) {
                bfs(i);
            }
        }

        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            // queue에서 꺼낸 정점이 작업의 순서
            int v = queue.poll();
            sb.append(v).append(" ");

            for (int i = 0; i < nodes[v].size(); i++) {
                // queue에서 꺼낸 정점과 연결된 정점을 모두 끊는다. (dp[node.to]-- 과정을 통해)
                Node node = nodes[v].get(i);
                dp[node.to]--;

                if (dp[node.to] == 0) {
                    queue.add(node.to);
                    // dp[node.to] = -1 을 해줘야 main의 if (dp[i] == 0)문을 한 번더 수행되지 않는다.
                    dp[node.to] = -1;
                }
            }
        }
    }

    static class Node {
        int from;
        int to;

        public Node(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}

/*
 * 스페셜 저지 문제이기 때문에 답이 여러개이다.
 * 문제의 예제 입력만 해도 4 2 3 1이 아ㄴ닌 3 1 4 2도 정답처리가 되며, 정점이 연결되지 않는
 * 경우는 존재하지 않는다.
 */
