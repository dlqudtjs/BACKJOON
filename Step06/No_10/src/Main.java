import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strArr = new String[n];

        for (int i = 0; i < n; i++) {
            strArr[i] = br.readLine();
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            boolean[] word = new boolean[26];
            int prev = 0;
            for (int j = 0; j < strArr[i].length(); j++) {
                char c = strArr[i].charAt(j); // 첫 글자 가져오기
                if (prev != c) { // 글자가 틀린 경우 1. 틀린 글자가 true라면 그룹단어가 아님 2. 틀린 글자가 false라면 true로 바꿈
                    if (word[c - 'a']) {
                        cnt++;
                        break;
                    } else {
                        word[c - 'a'] = true;
                    }
                }

                prev = strArr[i].charAt(j);
            }
        }

        System.out.println(n - cnt);
    }
}