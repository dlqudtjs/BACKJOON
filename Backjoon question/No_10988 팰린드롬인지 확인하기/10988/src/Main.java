import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int first = 0;
        int end = str.length() - 1;

        boolean flag = false;
        while (first <= end) {
            if (str.charAt(first++) != str.charAt(end--)) {
                flag = true;
                break;
            }
        }

        System.out.println(flag ? 0 : 1);
    }
}
