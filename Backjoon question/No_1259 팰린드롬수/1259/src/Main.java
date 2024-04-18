import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();

            if (input.equals("0")) {
                break;
            }

            boolean flag = false;
            for (int i = 0; i < (input.length() / 2); i++) {
                if (input.charAt(i) != input.charAt((input.length() - i) - 1)) {
                    flag = true;
                    break;
                }
            }

            sb.append(flag ? "no" : "yes").append("\n");
        }

        System.out.println(sb);
    }
}
