import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        boolean flag = false;
        int count = 0;

        for (char c : input.toCharArray()) {
            if (c == '.') {
                if (count % 2 != 0) {
                    flag = true;
                    break;
                }

                sb.append(appendAB(count));
                sb.append(".");

                count = 0;
                continue;
            }

            count++;
        }

        // 끝나고 남은 count 처리
        if (count % 2 != 0) {
            flag = true;
        } else {
            sb.append(appendAB(count));
        }

        System.out.println(flag ? -1 : sb);
    }

    private static String appendAB(int count) {
        if (count == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        sb.append("AAAA".repeat(count / 4));
        sb.append("BB".repeat((count % 4) / 2));

        return sb.toString();
    }
}
