import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] arr = new int[str.length()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i) - '0';
        }

        int count = getCount(arr, arr[0]);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(arr[i] - 1);
        }

        System.out.println(Math.min(count, getCount(arr, arr[0])));
    }

    private static int getCount(int[] arr, int init) {
        int count = 0;
        boolean flag = false;

        for (int i : arr) {
            if (flag && i == init) {
                flag = false;
                count++;
                continue;
            }

            if (!flag && i != init) {
                flag = true;
            }
        }

        return flag ? count + 1 : count;
    }
}
