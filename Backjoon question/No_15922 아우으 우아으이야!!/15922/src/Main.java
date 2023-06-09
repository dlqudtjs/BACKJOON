import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        // 초기 값 설정
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int length = 0;

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 기존 end 보다 시작 선이 크지 않다면 y 값을 보고 end를 갱신한다.
            if (end >= x) {
                end = end < y ? y : end;

                continue;
            }

            length += end - start;
            start = x;
            end = y;
        }

        System.out.println(length + (end - start));
    }
}
