import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + R;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + G;
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + B;
        }

        System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
    }
}
/*
 * 포인트는 한 for문 안에 RGB를 받고 바로 dp를 수행한다는 점이다.
 * 3
 * 26 40 83
 * 49 60 57
 * 13 89 99 의 입력으로 따라가보자.
 * 처음 for문을 시작하면 i = 1로 시작하게 되고 rgb 변수들을 받게된다.
 * dp[i][0] = dp[i - 1][1]과 dp[i - 1][2]중에 작은 수와 이제 막 들어온 R 변수와 더한다.
 * 이때 i - 1은 0으로 0으로 초기화된 값이기 때문에 dp[i][0]은 자기 자신의 값 R이 된다.
 * 다음 for문으로 넘어가면 i = 2가 되고 rgb를 변수들을 받게된다.
 * 똑같이 dp[i - 1]중 작은 값과 이제 막 들어온 R 변수와 더한다.
 * 즉, 조건을 따라가다 보면 자신의 위에(i - 1) 집의 색갈만 같지 않으면 된다(dp의 열 부분)
 * 최소값을 구하는 문제이기 때문에 막 들어온 RGB 변수의 값과 자신을 제외한 윗 집 중에 작은 수를 더해주면 된다.
 */

// 참고 블로그 :
// https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-1149%EB%B2%88-RGB%EA%B1%B0%EB%A6%AC-%EC%9E%90%EB%B0%94Java