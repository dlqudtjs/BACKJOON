import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] temp;
    static int K;
    static int count = 0;
    static int result = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        temp = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(A, 0, A.length - 1);

        System.out.println(result);
    }

    public static void merge_sort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2; // mid는 start와 end의 중간 지점

        merge_sort(A, start, mid); // 전반부 정렬
        merge_sort(A, mid + 1, end); // 후반부 정렬
        merge(A, start, mid, end); // 병합
    }

    public static void merge(int[] A, int start, int mid, int end) {
        int i = start; // 병합할 배열의 시작 지점
        // i부터 mid 까지 정렬하고, j부터 (mid + 1) end까지 정렬하면서 i, j 둘중 하나라도
        // 끝지점 (mid, end)에 닿게되면 정렬이 완료된다. (정렬을 하지 않은 부분은 "정렬이 완료 된 큰 수" 라고 판단하여 뒤에 붙인다.)
        int j = mid + 1;
        // t는 temp의 인덱스 증가값이다.
        int t = 0;

        while (i <= mid && j <= end) { // 둘중 하나라도 조건이 맞지 않으면 전면부, 후면부 중 하나가 정렬이 완료 되었다고 판단
            if (A[i] <= A[j]) {
                temp[t++] = A[i++];
            } else {
                temp[t++] = A[j++];
            }
        }

        // 그냥 털어줄 수 있는 이유는 앞에서 이미 정렬이 되었기 때문이다.
        while (i <= mid) { // i가 mid와 맞닿지 않았다면 mid까지 털어주기
            temp[t++] = A[i++];
        }

        while (j <= end) { // j 가 end와 맞닿지 않았다면 end까지 털어주기
            temp[t++] = A[j++];
        }

        /*
         * temp는 매 정렬하다 초기화(초기화는 하지 않지만 tmep[0]부터 계속 새로 쓰여지기 때문에 초기화로 가정)되기 때문에
         * temp는 0부터 증가하게 되고 A의 정렬 범위는 start부터 end이기 때문에 정렬이 된 temp에서 A[satrt]부터
         * A[end]범위 까지 덮여 쓰이게 된다.
         */
        i = start;
        t = 0;

        while (i <= end) {
            count++;

            if (count == K) { // 저장이 발생하는 횟수(K)에 저장되는 수를 저장한다.
                result = temp[t];
                break;
            }

            A[i++] = temp[t++];
        }
    }
}
