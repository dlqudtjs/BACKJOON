import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        int current = 1;
        while (true) {
            if (!queue.isEmpty() && (queue.peek() == current)) {
                queue.poll();
                current++;
                continue;
            }

            if (!stack.empty() && (stack.peek() == current)) {
                stack.pop();
                current++;
                continue;
            }

            if (queue.isEmpty()) {
                break;
            }

            stack.push(queue.poll());
        }

        System.out.println((queue.isEmpty() && stack.isEmpty()) ? "Nice" : "Sad");
    }
}
