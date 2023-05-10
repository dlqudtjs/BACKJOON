import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 이분탐색은 배열이 정렬이 돼있어야 한다.
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int findNum = Integer.parseInt(st.nextToken());
            sb.append(find(arr, findNum)).append(" ");
        }

        System.out.println(sb);
    }

    public static int find(int[] arr, int findNum) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        // if, else 모두 low를 올리거나, high를 내리기 때문에 low와 high를 좁혀가며 찾는 구조이다.
        // 따라서 low가 high보다 커지면 찾지 못한 걸로 간주하고 while문을 탈출한다.
        while (low <= high) {
            mid = (low + high) >>> 1;
            if (arr[mid] == findNum) {
                return 1;
            }

            /*
             * mid보다 findNum이 크다면 low를 mid + 1로 하한선을 올린다.
             * mid보다 find이 작다면 high를 mid - 1로 상한선을 내린다.
             */
            if (arr[mid] < findNum) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return 0;
    }
}

// Counting 정렬을 이용한? (정렬은 아니고 boolean check) 코드
// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.util.StringTokenizer;

// public class Main {
// public static void main(String[] args) throws Exception {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// StringBuilder sb = new StringBuilder();
// StringTokenizer st;

// boolean[] countingSort = new boolean[20000000];

// int N = Integer.parseInt(br.readLine());

// st = new StringTokenizer(br.readLine());
// for (int i = 0; i < N; i++) {
// int num = Integer.parseInt(st.nextToken());
// countingSort[num + 10000000] = true;
// }

// int M = Integer.parseInt(br.readLine());
// st = new StringTokenizer(br.readLine());
// for (int i = 0; i < M; i++) {
// int num = Integer.parseInt(st.nextToken());
// if (countingSort[num + 10000000]) {
// sb.append("1").append(" ");
// } else {
// sb.append("0").append(" ");
// }
// }

// System.out.println(sb);
// }
// }
