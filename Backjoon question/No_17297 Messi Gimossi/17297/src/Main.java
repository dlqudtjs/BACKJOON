import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    // 5, 13으로 시작하는 수열은 41번째가 int수의 범위이다.
    static int[] dp = new int[42];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp[1] = 5;
        dp[2] = 13;

        int i = 3;
        // int 3, 15로 시작하는 피보나치 수열을 41번째 dp까지 꽉 채운다.(중간에 멈춰도 되지만 수가 적어서 그냥 채움)
        while (dp[i - 1] <= N) {
            dp[i] = dp[i - 1] + 1 + dp[i - 2];
            i++;
        }
        i--;

        // i가 2보다 작거나 같으면 멈춤. 2일땐, N이 13이므로 "Messi Gimossi" 문자열까지 커버 가능 (12자리)
        while (i > 2) {
            /*
             * 만약 현재 찾는 글자 수가 dp에 저장된 수 + 1이라면 공백이기 때문에 N -1을 하고 break한다.
             * dp[i]의 다음 글자는 무조건 공백이 나오기 때문이다.
             */
            if (N == dp[i - 1] + 1) {
                N = -1;
                break;
            }
            /*
             * 만약 N이 dp[i - 1] 보다 크다면, dp[i -1] + 1을 빼준다. 그 이유는 만약 20번째 글자를 알고 싶을 때
             * dp[i - 1] + 1인 14을 빼면 dp[i-2]의 6번째에 있게 된다.
             * 그렇게 때문에 N은 dp[i - 1] + 1에서 빼주게 되고 i -= 2가 된다.
             */
            if (N > dp[i - 1]) {
                N -= dp[i - 1] + 1;
                i -= 2;
            } else {
                /*
                 * N이 dp[i - 1]보다 작다면 그대로 i만 -1해서 다시 탐색을 시작한다.
                 */
                i -= 1;
            }
        }

        String str = "Messi Gimossi";
        if (N == -1 || N == 6) {
            System.out.println("Messi Messi Gimossi");
        } else {
            System.out.println(str.charAt(N - 1));
        }
    }
}