import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] entryCnt;
    static ArrayList<Node>[] nodes;
    static int[] constructionTime;
    static int n, k, w;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < t; testCase++) {
            // 건물 수, 건설 순서 규칙 개수
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            constructionTime = new int[n + 1];
            entryCnt = new int[n + 1];

            // 정점 그래프 ArrayList 초기화
            nodes = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                nodes[i] = new ArrayList<>();
            }

            // 건설 시간 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                constructionTime[i] = Integer.parseInt(st.nextToken());
            }

            // 건물 순서 입력
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                nodes[u].add(new Node(u, v));
                entryCnt[v]++;
            }

            // 건설해야 할 건물
            w = Integer.parseInt(br.readLine());

            sb.append(bfs()).append("\n");

        }

        System.out.println(sb);
    }

    private static int bfs() {
        int[] result = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        // result 초기화 (기본 공사 시간을 result에 복사)
        for (int i = 1; i <= n; i++) {
            result[i] = constructionTime[i];
            if (entryCnt[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int n = queue.poll();

            for (int i = 0; i < nodes[n].size(); i++) {
                Node node = nodes[n].get(i);

                // 출발 지점의 누적 걸린 시간 + 도착 정점의 기본 시간과 도착 정점에 누적 걸린시간을 비교하여 더 큰 값을 갱신한다.
                result[node.v] = Math.max(result[n] + constructionTime[node.v], result[node.v]);
                entryCnt[node.v]--;

                if (entryCnt[node.v] == 0) {
                    queue.add(node.v);
                }
            }
        }

        return result[w];
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
