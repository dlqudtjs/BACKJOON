import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) { // 물건의 수
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken()); // 물건의 무게
            int V = Integer.parseInt(st.nextToken()); // 물건의 가치

            for (int j = 1; j <= K; j++) { // j = 현재 들 수 있는 무게
                if (j >= W) {// 현재 물건을 들 수 있을 때
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W] + V); // 아래 설명
                } else {
                    // 들 수 없을 땐 앞서 작성한 윗 행의 최대 가치를 가져온다.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}

/*
 * ...j 무게1 무게2 무게3 무게4 무게5 무게6 무게7
 * i
 * 
 * W, V
 * 
 * W, V
 * 
 * W, V
 * 
 * W, V
 * (반복문 마다 W, V를 새로 받는다.)
 * 
 * dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W] + V);
 * 위 행열 표로 설명한다.
 * dp[i][j]는 현재 물건(반복문에서 받아온 W, V)을 들 수 있는 무게이다. (무게는 1부터 K까지 나열함)
 * dp[i - 1][j]는 자신 윗 행의 최대 가치이다. (갱신할 때 최대 가치를 비교하기 위해)
 * dp[i - 1][j - W] + V는 자신 윗 행에서 현재 물건의 무게를 빼고 가질 수 있는 최대의 가치에
 * 현재 물건의 가치를 더한 값이다.
 * ex) 현재 물건이 3, 6이고 들 수 있는 무게가 6이라면, 들 수 있는 무게 6에서 현재 물건의 무게 3을 빼고
 * 남은 들 수 있는 무게 3을 윗 행에서 구해놓은 최대의 가치에 아까 빼주었던 현재 물건의 가치 V를 더한다.
 * 같은 무게의 물건이 있을 경우에는 먼저 나오는 물건으로 갱신되겠지만 결국 마지막 반복문 까지 돌게 되면
 * 반복문의 조건을 통해 더 높은 가치의 물건을 집게 된다.
 * 참고 블로그 : https://infodon.tistory.com/80
 */
