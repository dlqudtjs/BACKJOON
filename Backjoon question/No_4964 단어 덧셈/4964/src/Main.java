import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    static int N, cnt;
    static List<Character> charList; // 중복 없는 알파벳 오름차순
    static String[] str; // N개의 입력 문자들
    static int[] alpha = new int[26]; // 알파벳의 각 가중치
    static boolean[] visited = new boolean[10]; // 0 ~ 9 까지 사용 여부

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            N = Integer.parseInt(br.readLine());
            cnt = 0;

            if (N == 0) {
                break;
            }

            str = new String[N];
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                str[i] = br.readLine();

                for (char c : str[i].toCharArray()) {
                    set.add(c);
                }
            }

            charList = new ArrayList<>(set);

            dfs(0, charList.size());
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int index, int limit) {
        if (index == limit) {
            int sum = 0;
            int result = 0;

            for (int i = 0; i < N - 1; i++) {
                sum += convertToInt(str[i]);
            }

            result = convertToInt(str[N - 1]);

            if (sum == result) {
                cnt++;
            }

            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (i == 0 && !check(charList.get(index))) {
                continue;
            }
            if (visited[i]) {
                continue;
            }

            alpha[charList.get(index) - 'A'] = i;
            visited[i] = true;
            dfs(index + 1, limit);
            visited[i] = false;
        }
    }

    private static int convertToInt(String str) {
        int result = 0;
        for (char c : str.toCharArray()) {
            result = (result * 10) + alpha[c - 'A'];
        }
        return result;
    }

    private static boolean check(char c) {
        for (int i = 0; i < N; i++) {
            if (str[i].charAt(0) == c) {
                if (str[i].length() == 1) {
                    return true;
                }

                return false;
            }
        }

        return true;
    }
}