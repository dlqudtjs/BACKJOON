import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];

        arr[0] = 1; // n이 1이 나올 때 인덱스 아웃 오류 나옴(n + 2로 선언해서 1부터 쓰는 방법도 있음)
        arr[1] = 2;

        for (int i = 2; i < n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
        }

        System.out.println(arr[n - 1]);
    }
}

/*
 * 1 = 1개
 * 2 = 2개
 * 3 = 3개
 * 4 = 5개
 * 5 = 8개가 나옴 규칙을 찾으면 되는 간단한 문제
 */