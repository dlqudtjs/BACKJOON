import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[] num;
    private static int N; // 정수의 개수
    private static int S; // 정수의 합
    private static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if (S == 0) {
            // S 0일때가 전체 합이 0 일때랑 겹치기 때문에 -1 을 해줘야한다.
            System.out.println(answer - 1);
        } else {
            System.out.println(answer);
        }

    }

    private static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S)
                answer++;
            return;
        }

        dfs(depth + 1, sum + num[depth]);
        dfs(depth + 1, sum);
    }
}