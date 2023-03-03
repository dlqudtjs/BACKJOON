import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
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

        int max = 0;

        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }

            max = Math.max(max, dp[i]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append('\n');

        /*
         * 길이(max) 값을 구한 후 dp에 max값이 들어있는 arr값을 찾아서
         * stack에 넣는다. (크기가 가장 큰 수열의 마지막부터 추적하여 stack에 넣는다.)
         * max값이 들어있는 수열부터 앞으로 가면서 max-- 을 하면서 값을 찾으면 자연스레(?) 역추적이 된다.
         * (앞으로 가면서 같은 dp값을 가진 수열을 잘 못 넣으면 어떻하나 생각했지만 손수 해본 결과
         * max 값부터 앞으로 가는 도중에 같은 값이 있는 다른 수열이 있다는 것은 max값이 같은 수열이 존재한다는 것이다.)
         * (조건에 그러한 경우 아무거나 출력하라고 나와있다.)
         */
        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            if (max == dp[i]) {
                stack.push(arr[i]);
                max--;
            }

            if (max == 0) {
                break;
            }
        }

        while (!stack.empty()) {
            sb.append(stack.pop()).append(' ');
        }

        System.out.println(sb);
    }
}