import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static char[] arr;
    static char[] answer;
    static int L, C;
    static int consonantCount = 0; // 자음
    static int vowelCount = 0; // 모음

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken()); // 암호 구성 수
        C = Integer.parseInt(st.nextToken()); // 주어지는 글자 수

        arr = new char[C];
        answer = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        dfs(0, 0);

        System.out.println(sb);
    }

    private static void dfs(int index, int count) {
        if (count == L) {
            consonantCount = 0;
            vowelCount = 0;

            for (char c : answer) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }

            // 모음이 하나 이상 없거나, 자음이 두개 이상 없을 때
            if (vowelCount < 1 || consonantCount < 2) {
                return;
            }

            for (char c : answer) {
                sb.append(c);
            }

            sb.append("\n");
            return;
        }

        if (index >= C) {
            return;
        }

        answer[count] = arr[index];
        // 자신을 추가
        dfs(index + 1, count + 1);
        dfs(index + 1, count);
    }
}
