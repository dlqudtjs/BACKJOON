import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] seq = new int[N];
        int[] arrValue = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        seq[0] = arr[0];
        int seqLength = 1;

        for (int i = 1; i < N; i++) {
            int key = arr[i];

            if (key > seq[seqLength - 1]) {
                seq[seqLength] = key;
                arrValue[i] = seqLength; // key가 저장되는 순서 저장한다.
                seqLength++;
            } else {
                int low = 0;
                int high = seqLength;

                while (low < high) {
                    int mid = (low + high) >>> 1;

                    if (key > seq[mid]) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }

                seq[low] = key;
                arrValue[i] = low; // key가 저장되는 순서 저장한다. (low가 대체되는 위치이다.)
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(seqLength).append('\n');

        /*
         * 만약 위치를 기록하지 않고 seq 배열에 있는 값을 출력하게 된다면
         * 1 3 4 5 2 3 의 수열을 1 2 3 5로 저장한 값을 출력하게 된다. (답은 1 3 4 5)
         * lower bound로 값을 찾아 대채하는 경우는 순서는 다르다. (최장 길이의 문제일 때는 상관없음)
         * 그렇기 때문에 저장되는 순서인 arrValue 배열을 만들어 순서를 저장하고 가장 높은 수(seqLength)부터
         * 앞으로 순회하며 출력한다.
         */
        Stack<Integer> stack = new Stack<>();

        for (int i = N - 1; i >= 0; i--) {
            if (arrValue[i] == seqLength - 1) {
                stack.add(arr[i]);
                seqLength--;
            }

        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }

        System.out.println(sb);
    }
}