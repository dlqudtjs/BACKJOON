import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N]; // 수열 크기

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            dp[i] = 1; // 모든 수열은 1로 초기화 후 진행

            for (int j = 0; j < i; j++) { // 0 ~ i 까지 i 이전의 배열을 순회한다.
                if (arr[i] > arr[j] && dp[i] <= dp[j]) { // 현재 arr[i] 보다 작으면서 dp의 크기가 자신보다 크거나 같을 때
                    dp[i] = dp[j] + 1; // + 1 을 함으로써 그 수열 뒤로 붙는다.
                }
            }

            answer = answer < dp[i] ? dp[i] : answer; // 가장 큰 수열의 크기를 저장
        }

        System.out.println(answer);
    }
}

/*
 * 
 * 
 * 참고 블로그 https://steady-coding.tistory.com/47
 */