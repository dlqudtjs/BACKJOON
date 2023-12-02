import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[3];

        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        if (arr[0] + arr[1] > arr[2]) {
            System.out.println(arr[0] + arr[1] + arr[2]);
        } else {
            arr[2] = arr[0] + arr[1] - 1;
            System.out.println(arr[0] + arr[1] + arr[2]);
        }
    }
}

/*
 * 2 1 1 / 2 3 5 / 3 5 10 의 경우
 * 1 1 1 / 2 3 4 / 3 5 7 로 바꾼다면 삼각형을 만들 수 있다.
 * 가장 긴 arr[2]를 arr[0] + arr[1] 을 하여 -1한 후 세 변을 더하면 값이 나온다.
 * System.out.println((arr[0] + arr[1]) * 2 - 1) <- 처럼 코드를 줄일 수 있다.
 */
