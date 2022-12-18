import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int x = (n / h) + 1; // 호수
            int y = n % h; // 층수
            if (y == 0) {
                y = h; // 맨 위층은 0이 아닌 h
                x--; // 맨 위층은 다음 호수로 넘어가기 때문에 -1
            }

            System.out.println((y * 100) + x);
        }
    }
}
