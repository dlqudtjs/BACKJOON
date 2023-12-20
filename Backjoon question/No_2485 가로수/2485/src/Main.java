import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] trees = new int[n];
        int[] distance = new int[n - 1];
        int treeCount = 0;
        int gcd = 0;

        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n - 1; i++) {
            distance[i] = Math.abs(trees[i] - trees[i + 1]);

            gcd = gcd(distance[i], gcd);
        }

        for (int i = 0; i < n - 1; i++) {
            treeCount += (distance[i] / gcd) - 1;
        }

        System.out.println(treeCount);
    }

    private static int gcd(int bigNum, int smallNum) {
        if (smallNum == 0) {
            return bigNum;
        }

        if (bigNum % smallNum == 0) {
            return smallNum;
        }

        return gcd(smallNum, bigNum % smallNum);
    }
}
