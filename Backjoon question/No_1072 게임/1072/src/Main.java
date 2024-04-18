import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = calculatePercentage(x, y);

        int answer = -1;
        int min = 0;
        int max = x;
        while (min <= max) {
            int mid = (min + max) / 2;

            if (calculatePercentage(x + mid, y + mid) != z) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static int calculatePercentage(int x, int y) {
        return (int) ((long) y * 100 / x);
    }
}
