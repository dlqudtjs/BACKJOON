import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int computerCnt, computerLine, lineCnt;
    static boolean[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        computerCnt = Integer.parseInt(br.readLine());
        computerLine = Integer.parseInt(br.readLine());

        map = new boolean[computerCnt + 1][computerCnt + 1]; // 맵의 크기가 정해져 있지 않았기에 컴퓨터 개수만큼 설정
        visited = new boolean[computerCnt + 1]; // 그 노드의 방문 여부를 확인하기 위해 computerCnt로 하였음

        for (int i = 0; i < computerLine; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = map[y][x] = true;
        }

        dfs(1);
        System.out.println(lineCnt);

    }

    public static void dfs(int node) {
        visited[node] = true;

        for (int next = 1; next <= computerCnt; next++) {
            if (!visited[next] && map[node][next]) { // 방문을 안 한곳이며, 간선이 존재할 때
                lineCnt++;
                dfs(next);
            }
        }
    }
}
