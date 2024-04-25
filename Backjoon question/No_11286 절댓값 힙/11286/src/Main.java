import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        PriorityQueue<Integer> plus = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (minus.isEmpty() && plus.isEmpty()) {
                    sb.append(0).append("\n");
                    continue;
                }

                if (minus.isEmpty()) {
                    sb.append(plus.poll()).append("\n");
                    continue;
                }

                if (plus.isEmpty()) {
                    sb.append(-minus.poll()).append("\n");
                    continue;
                }

                if (plus.peek().equals(minus.peek())) {
                    sb.append(-minus.poll()).append("\n");
                    continue;
                }

                if (plus.peek() > minus.peek()) {
                    sb.append(-minus.poll()).append("\n");
                } else {
                    sb.append(plus.poll()).append("\n");
                }

                continue;
            }

            if (x < 0) {
                minus.add(-x);
            } else {
                plus.add(x);
            }
        }

        System.out.println(sb);
    }
}
