import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 마지막 행의 윗 줄 행의 열만큼 돌아야 하기 때문에 n - 1
        int cnt = n - 1;

        // 자세한 풀이는 프로그래머스 lv3 정수 삼각형 참고
        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j < cnt; j++) {
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }

            cnt--;
        }

        System.out.println(triangle[0][0]);
    }
}
