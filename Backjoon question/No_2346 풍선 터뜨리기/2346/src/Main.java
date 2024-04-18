import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<int[]> deque = new ArrayDeque<>();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            deque.add(new int[] { i, Integer.parseInt(st.nextToken()) });
        }

        // 방향 설정 (처음에 맨 앞 1번을 터트리기 위해 true로 설정)
        boolean right = true;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int[] value = right ? deque.pollFirst() : deque.pollLast();
            right = value[1] > 0 ? true : false;
            sb.append(value[0]).append(" ");

            if (deque.isEmpty()) {
                break;
            }

            // 3이라면 2번만 돌아서 터트려야할 풍선을 맨 앞 또는 뒤로 보냄(그 후 for문 처음에서 poll함)
            for (int j = 0; j < Math.abs(value[1]) - 1; j++) {
                // 양수라면 맨 앞 원소를 빼서 맨 뒤로 삽입(오른쪽으로 돔)
                if (right) {
                    deque.add(deque.pollFirst());
                    continue;
                }

                // 음수라면 맨 뒤 원소를 빼서 맨 앞으로 삽입(왼쪽으로 돔)
                deque.push(deque.pollLast());
            }
        }

        System.out.println(sb);
    }
}
