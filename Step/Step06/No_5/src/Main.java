import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toUpperCase();
        int[] alphabet = new int[26];

        for (int i = 0; i < str.length(); i++) {
            alphabet[str.charAt(i) - 'A']++;
        }

        int maxValue = 0; // 최대 값
        char result = '?';

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] > maxValue) {
                maxValue = alphabet[i];
                result = (char) (i + 'A');
            } else if (alphabet[i] == maxValue) {
                result = '?';
            }
        }

        System.out.println(result);
        br.close();
    }
}
