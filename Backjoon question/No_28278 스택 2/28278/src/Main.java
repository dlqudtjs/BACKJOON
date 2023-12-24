import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());

            if (value == 1) {
                stack.push(Integer.parseInt(st.nextToken()));
                continue;
            }
            if (value == 2) {
                sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                continue;
            }
            if (value == 3) {
                sb.append(stack.size()).append("\n");
                continue;
            }
            if (value == 4) {
                sb.append(stack.empty() ? 1 : 0).append("\n");
                continue;
            }
            if (value == 5) {
                sb.append(stack.empty() ? -1 : stack.peek()).append("\n");
                continue;
            }
        }

        System.out.println(sb);
    }
}
