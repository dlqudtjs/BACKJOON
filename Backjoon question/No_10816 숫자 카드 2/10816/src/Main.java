import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());

            // upperBound와 lowerBound의 차이 값을 구한다.
            sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
        }
        System.out.println(sb);
    }

    private static int lowerBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;

        // lo가 hi랑 같아질 때 까지 반복
        while (lo < hi) {
            int mid = (lo + hi) / 2; // 중간위치를 구한다.

            /*
             * key 값이 중간 위치의 값보다 작거나 같을 경우
             * 
             * (중복 원소에 대해 왼쪽으로 탐색하도록 상계를 내린다.)
             */
            if (key <= arr[mid]) {
                hi = mid;
            }

            else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private static int upperBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;

        // lo가 hi랑 같아질 때 까지 반복
        while (lo < hi) {
            int mid = (lo + hi) / 2; // 중간위치를 구한다.

            // key값이 중간 위치의 값보다 작을 경우
            if (key < arr[mid]) {
                hi = mid;
            }
            // 중복원소의 경우 else에서 처리된다.
            else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}

/*
 * Lower 메서드를 한 번씩 실행해보자.
 * 1, 3, 3, 5, 5, 7, 9의 배열이 있을 때, (lenght = 7, target = 3)
 * 1번 => mid = 인덱스3이며, target <= arr[mid] 이기 때문에
 * mid = high가 되고 mid는 2가 된다. 계속 하다보면
 * mid는 0이 되고 high는 1이 되는데 이때 target <= arr[mid] 이 성립하지 않기 때문에 lo = mid + 1를 해주고
 * lo = 1, high = 1가 되며 while문을 탈출한다. (즉 돌려보면 된다~)
 * 
 * Upper도 비슷하게 흘러가지만 가장 큰 차이는 target <= arr[mid]와(lower)
 * target < arr[mid](upper)차이가 가장 크다.
 * 이유는 <= 일땐 target이 mid에 같아져도 계속 hi를 mid로 바꾸며 상한선을 줄여나가지만
 * < 일땐 target이 mid와 같아지면 하한선을 올려 처음 큰 값이 나오는 위치를 반환한다.
 */

// 참고 블로그 : https://st-lab.tistory.com/267

// HashMap 해결
// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.util.HashMap;
// import java.util.StringTokenizer;

// public class Main {
// public static void main(String[] args) throws Exception {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// StringBuilder sb = new StringBuilder();
// HashMap<Integer, Integer> hash = new HashMap<>();

// int N = Integer.parseInt(br.readLine());

// StringTokenizer st = new StringTokenizer(br.readLine());
// for (int i = 0; i < N; i++) {
// int num = Integer.parseInt(st.nextToken());
// // hash에 값이 없으면 0을 반환함.
// hash.put(num, hash.getOrDefault(num, 0) + 1);
// }

// int M = Integer.parseInt(br.readLine());
// st = new StringTokenizer(br.readLine());
// for (int i = 0; i < M; i++) {
// int num = Integer.parseInt(st.nextToken());
// sb.append(hash.getOrDefault(num, 0)).append(" ");
// }

// System.out.println(sb);
// }
// }
