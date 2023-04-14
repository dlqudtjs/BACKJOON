import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[][] node = new boolean[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];

        // 시작 지점으로부터 촌수를 구하기 위한 dp
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int findNode1 = Integer.parseInt(st.nextToken());
        int findNode2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            node[x][y] = node[y][x] = true;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(findNode1);

        // 자신의 촌수는 0
        dp[findNode1] = 0;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            visited[currentNode] = true;

            for (int i = 1; i <= n; i++) {
                // 방문을 했거나, 해당 노드가 연결 돼있지 않거나
                if (visited[i] || !node[currentNode][i]) {
                    continue;
                }

                // 위에 조건문을 통과한 i만 남음
                queue.add(i);
                visited[i] = true;

                // 자신과 연결된 촌수는 자신 + 1의 촌수를 갖게된다.
                dp[i] = dp[currentNode] + 1;
            }
        }

        dp[findNode2] = dp[findNode2] == 0 ? -1 : dp[findNode2];

        // 시작 지점으로부터 떨어진 findNode2의 촌수를 출력한다.
        System.out.println(dp[findNode2]);
    }
}
