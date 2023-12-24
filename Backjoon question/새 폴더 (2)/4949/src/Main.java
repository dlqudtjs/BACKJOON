import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack;

        while (true) {
            String str = br.readLine();

            if (str.equals(".")) {
                break;
            }

            stack = new Stack<>();
            boolean flag = false;
            for (char c : str.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                    continue;
                }

                if ((c == ')' || c == ']') && stack.empty()) {
                    flag = true;
                    break;
                }

                if (c == ')' && (stack.peek() == '(')) {
                    stack.pop();
                    continue;
                }

                if (c == ']' && (stack.peek() == '[')) {
                    stack.pop();
                    continue;
                }

                // ), ] 일 때 stack.peek() 과 매칭이 되지 않으면
                if (c == ')' || c == ']') {
                    flag = true;
                    break;
                }
            }

            sb.append(flag ? "no" : stack.empty() ? "yes" : "no").append("\n");
        }

        System.out.println(sb);
    }
}
