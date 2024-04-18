import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int currentIndex = 1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i : arr) {
            while (true) {
                if (!stack.empty() && stack.peek() > i) {
                    break;
                }

                if (stack.empty() || stack.peek() < i) {
                    stack.add(currentIndex++);
                    sb.append("+\n");
                }

                if (i == stack.peek()) {
                    stack.pop();
                    sb.append("-\n");
                    break;
                }
            }
        }

        System.out.println(stack.empty() ? sb : "NO");
    }
}
