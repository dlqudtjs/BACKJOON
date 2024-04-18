import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String word = br.readLine();
        String result = null;

        // 범위 설명
        for (int i = 1; i < word.length(); i++) {
            for (int j = i + 1; j < word.length(); j++) {
                sb = new StringBuilder();

                sb.append(getReversString(word.substring(0, i)));
                sb.append(getReversString(word.substring(i, j)));
                sb.append(getReversString(word.substring(j)));

                if (result == null) {
                    result = sb.toString();
                }

                result = result.compareTo(sb.toString()) < 0 ? result : sb.toString();
            }
        }

        System.out.println(result);
    }

    private static String getReversString(String str) {
        StringBuilder sb = new StringBuilder();
    }
}
