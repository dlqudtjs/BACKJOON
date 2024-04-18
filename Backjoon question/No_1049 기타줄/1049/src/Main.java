import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int minA = Integer.MAX_VALUE;
        int minB = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            minA = Math.min(minA, a);
            minB = Math.min(minB, b);
        }

        // A로만 다 구매한 경우
        int buyA = (n / 6) * minA + (n % 6 != 0 ? minA : 0);
        // A로 구매한 후 나머지는 B로 구매한 경우
        int buyAAndB = (n / 6) * minA + (n % 6 != 0 ? (n % 6 * minB) : 0);
        // B로만 구매한 경우와 위에 두 경우를 비교
        int answer = Math.min(minB * n, Math.min(buyA, buyAAndB));

        System.out.println(answer);
    }
}
