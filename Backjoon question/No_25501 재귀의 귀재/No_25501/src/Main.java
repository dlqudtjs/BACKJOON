import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            cnt = 0;
            sb.append((isPalindrome(br.readLine()))).append(" ").append(cnt).append('\n');
        }

        System.out.println(sb);
    }

    public static int isPalindrome(String str) {
        return recursion(str, 0, str.length() - 1);
    }

    public static int recursion(String str, int first, int end) {
        cnt++;

        if (first >= end) { // 첫 글자와 마지막 글자가 이상없이 만났다면 같은 문자
            return 1;

        } else if (str.charAt(first) != str.charAt(end)) { // 다르면 0 리턴
            return 0;

        } else { // 첫 시작점 + 1과 마지막 글자 - 1을 재귀함으로써 확인
            return recursion(str, first + 1, end - 1);
        }
    }
}
