import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            dp[i] = arr[i];

            for (int j = 0; j < i; j++) { // 0 ~ i 까지 이전의 배열을 순회한다.
                // 현재 arr[i] 값보다 작고 자신의 dp값(현재 최대 합)과 dp[j] + arr[i]
                // 자신보다 값이 작은 값의 dp와 자신의 값을 더 했을 때 자신의 dp보다 크다면 최댓값 갱신
                if (arr[i] > arr[j] && dp[i] < arr[i] + dp[j]) {
                    dp[i] = arr[i] + dp[j]; // 갱신
                }
            }

            answer = answer < dp[i] ? dp[i] : answer;
        }

        System.out.println(answer);
    }
}
