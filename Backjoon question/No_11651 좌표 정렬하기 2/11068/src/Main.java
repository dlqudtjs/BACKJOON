import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            boolean isPalindrome = false;

            for (int radix = 2; radix <= 64; radix++) {
                if (checkPalindrome(num, radix)) {
                    isPalindrome = true;
                    break;
                }
            }

            sb.append(isPalindrome ? "1" : "0").append("\n");
        }

        System.out.println(sb);
    }

    private static boolean checkPalindrome(int num, int radix) {
        ArrayList<Integer> numList = new ArrayList<>();

        while (num > 0) {
            numList.add(num % radix);
            num /= radix;
        }

        int start = 0;
        int end = numList.size() - 1;

        while (start <= end) {
            if (numList.get(start) != numList.get(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
