import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            // 출발, 도착 입력
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 출발점
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            // 도착점
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 행성계의 개수
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                // Math.sprt(Math.pow(x1 - cx, 2) + Math.pow(y1 - xy, 2))으로 하면 sqrt 과정에서 범위를
                // 미세하게 벗어나는 경우가 있다. 따라서 sqrt를 하지 않고 r를 제곱한다.
                int startDistance = (int) Math.pow(x1 - cx, 2) + (int) Math.pow(y1 - cy, 2);
                int finishDistance = (int) Math.pow(x2 - cx, 2) + (int) Math.pow(y2 - cy, 2);
                boolean isInside1 = startDistance <= r * r;
                boolean isInside2 = finishDistance <= r * r;

                /*
                 * 두 좌표 모두 원 안에 들어있다면, 두 좌표 모두 원 안에 들어있지 않다면의 조건들을 만족하지 않고
                 * 0, 1 또는 1, 0 일 때만 cnt를 1 올려준다. (^ 은 xor 연산)
                 */
                cnt = (isInside1 ^ isInside2) ? cnt + 1 : cnt;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
