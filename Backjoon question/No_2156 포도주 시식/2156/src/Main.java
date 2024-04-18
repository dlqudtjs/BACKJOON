import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 3];
        int[] dp = new int[n + 3];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }4

        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        }

        System.out.println(dp[n]);
    }
}

/*
 * dp에 저장되는 값은 위치마다 최대로 마실 수 있는 와인의 양이 저장된다.
 * 따라서, 현재 위치의 와인 양을 포함하지 않을 수 있다.
 * 
 * 현재 위치의 와인을 포함하지 않고 전 dp의 값과, (dp[i - 1])
 * 현재 위치의 와인과 i - 2의 dp값 과, (dp[i - 2] + arr[i])
 * 현재 위치의 와인, i - 1의 위치의 와인과 i - 3의 dp값을 더한 값 (dp[i - 3] + arr[i - 1] + arrㄴ[i])
 * 을 비교한다.
 * 
 * 이렇게 되면 dp[n]에 자연스레 가장 큰 값이 저장된다.
 * 
 * 여기서 dp[i - 3] + arr[i - 1] + arr[i] 점화식의 경우 arr[i - 1] + arr[i] 이 부분이
 * 두 번 반복된다면 와인을 연속으로 3번 고르게 되는 거 아닌가 하는 오류에 빠지기 쉽다.
 * 
 * 이 부분은 잘 보면 dp[i - 1] + arr[i]가 아니기 때문에 두 번 반복되어도 연속으로 3번 고르는 것이 아니다.
 * 따라서, dp[i - 3] + arr[i - 1] + arr[i] 는 항상 세 번째 전, 전 와인의 값 + 현재 와인의 값을 구하기 때문에
 * 조건에 위배되지 않는다. dp와 arr를 잘 구별하여 이해하자.
 */