import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dfs("", N);
    }

    private static void dfs(String str, int limit) {
        if (str.length() == limit) {
            System.out.println(str);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            if (check(str + i)) {
                dfs(str + i, limit);
            }
        }
    }

    private static boolean check(String str) {
        if (str.length() == 1) {
            return true;
        }

        for (int i = 1; i <= str.length() / 2; i++) {
            // 1212 일 때, 맨뒤 12, 그 앞 12를 비교하여 같은 부분 수열인지 확인한다.
            String back = str.substring(str.length() - i);
            String front = str.substring(str.length() - i - i, str.length() - i);

            if (back.equals(front)) {
                return false;
            }
        }

        return true;
    }
}
