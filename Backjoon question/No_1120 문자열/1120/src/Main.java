import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < (b.length() - a.length()) + 1; i++) {
            String subString = b.substring(i, i + a.length());

            int count = 0;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) != subString.charAt(j)) {
                    count++;
                }
            }

            answer = Math.min(answer, count);
        }

        System.out.println(answer);
    }
}
/*
 * 앞 뒤 하나씩 추가할 필요없이, b 문자열에 a를 맞춰보면서 비교하여
 * 가장 차이가 적은 값을 찾으면 된다. (아무 알파벳이나 추가할 수 있으니)
 */
