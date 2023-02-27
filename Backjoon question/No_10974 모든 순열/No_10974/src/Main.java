import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        visited = new boolean[N];

        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int cnt) {
        // cnt 즉 depth의 깊이를 말한다. N과 같아질 때 출력한다.
        // cnt가 N까지 오면서 조합된 배열을 arr에 저장한다. (그 후 저장된 arr를 출력)
        if (cnt == N) {
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(' ');
            }

            sb.append('\n');
            return;
        }

        // 크기를 N으로 잡았기 때문에 0부터 시작한다.
        for (int i = 0; i < N; i++) {
            if (!visited[i]) { // 사용된 조합이 아니라면

                // 사용된 조합이 아니라면 arr[cnt]에 i + 1을 저장한다. (i + 1은 순서대로 증가하는 값 1 -> 2 -> 3)
                // cnt는 depth라고 생각하면 편하다.
                arr[cnt] = i + 1;

                // visited[i]는 위에서 사용 된 i + 1을 의미한다. (0부터 시작했기 때문에 + 1을 하지 않음)
                visited[i] = true;

                // 현재 depth가 마지막이 아니기 때문에 자신의 다음 깊이를 탐색한다.
                dfs(cnt + 1);

                // 현재의 i, 즉 i (i + 1)으로 시작된 dfs의 탐색이 끝났기에 false로 변환한다.
                visited[i] = false;
            }
        }
    }
}
