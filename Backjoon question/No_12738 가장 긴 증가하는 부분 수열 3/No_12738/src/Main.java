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

        seq[0] = arr[0];
        int seqLength = 1;

        for (int i = 1; i < N; i++) {
            int key = arr[i];

            if (key > seq[seqLength - 1]) {
                seq[seqLength] = key;
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
            }
        }

        System.out.println(seqLength);
    }
}

// 가장 긴 증가하는 부분 수열 2 문제와 같다.