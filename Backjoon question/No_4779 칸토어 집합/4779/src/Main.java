import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            answer = new StringBuilder();

            int startSize = (int) Math.pow(3, n);
            answer.append("-".repeat(startSize));

            recursion(0, startSize, n);

            System.out.println(answer);
        }
    }

    public static void recursion(int start, int size, int n) {
        if (size == 1) {
            return;
        }

        int newSize = size / 3;

        // 두번째 공백처리
        for (int i = start + newSize; i < start + (2 * newSize); i++) {
            answer.setCharAt(i, ' ');
        }

        recursion(start, newSize, n); // 첫번째
        recursion(start + (2 * newSize), newSize, n); // 세번째
    }
}
