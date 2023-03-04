import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] seq = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        seq[0] = arr[0]; // seqLiength가 1부터 시작해야 하기 때문에 0인덱스는 초기화한다.
        int seqLength = 1; // 26번줄 조건에서 seqLength - 1을 통해 마지막 숫자의 크기를 비교하기 위해 1로 시작한다. (0으로 시작하면 -1이 됨)

        for (int i = 1; i < N; i++) { // 1부터 시작(arr[0]은 seq[0]에 이미 할당함)
            int key = arr[i]; // key = 현재 수 (붙일지, 버릴지, 대치할지)

            if (key > seq[seqLength - 1]) { // 마지막 수보다 크다면
                seq[seqLength] = key; // 마지막 뒤에 붙인다. (- 1을 하지 않음)
                seqLength++; // 그 후 마지막 수를 ++로 다시 가리킴
            } else {
                int low = 0;
                int high = seqLength; // 지금 까지 붙은 수열의 크기

                while (low < high) { // key보다 큰 가장 가까운 값 찾기
                    int mid = (low + high) >>> 1; // 나누기 2의 몫

                    if (key > seq[mid]) {
                        low = mid + 1;
                    } else {
                        // 가장 가까운 큰 값을 찾기 때문에 위에 조건문 > 에서 걸린다면 mid는 필요 없기에 + 1을 하지만
                        // ex) key = 50, seq[mid] = 51 이라면 mid까지 범위를 잡아야 하기 때문에 high = mid가 된다.
                        high = mid;
                    }
                }

                seq[low] = key;
            }
        }

        System.out.println(seqLength);
    }
}
