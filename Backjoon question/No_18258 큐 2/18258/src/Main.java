import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String comand = st.nextToken();

            if (comand.equals("push")) {
                deque.add(Integer.parseInt(st.nextToken()));
                continue;
            }

            if (comand.equals("pop")) {
                sb.append(deque.isEmpty() ? -1 : deque.pop()).append("\n");
                continue;
            }

            if (comand.equals("size")) {
                sb.append(deque.size()).append("\n");
                continue;
            }

            if (comand.equals("empty")) {
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                continue;
            }

            if (comand.equals("front")) {
                sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
                continue;
            }

            if (comand.equals("back")) {
                sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
                continue;
            }
        }

        System.out.println(sb);
    }
}
