import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;

        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int findValue = Integer.parseInt(st.nextToken());

            // 왼쪽이 더 가깝다면 true
            boolean isLeft = isLeft(deque, findValue);

            while (deque.peekFirst() != findValue) {
                if (isLeft) {
                    deque.addLast(deque.pollFirst());
                } else {
                    deque.addFirst(deque.pollLast());
                }

                count++;
            }

            deque.pollFirst();
        }

        System.out.println(count);
    }

    private static boolean isLeft(Deque<Integer> deque, int findValue) {
        Deque<Integer> copy = new ArrayDeque<>(deque);
        int count = 0;

        while (copy.peekFirst() != findValue) {
            copy.add(copy.pollFirst());
            count++;
        }

        // deque.size() - count = 오른쪽으로 돌렸을 때 나오는 횟수 (같을 땐 어디로 돌려도 상관 X)
        return count < (deque.size() - count);
    }
}
