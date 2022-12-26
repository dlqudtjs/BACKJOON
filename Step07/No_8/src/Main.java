import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String str_A = st.nextToken();
        String str_B = st.nextToken();

        int max_length = str_A.length() > str_B.length() ? str_A.length() : str_B.length();

        int[] A = new int[max_length + 1]; // 마지막 자리수 올림이 있을 경우를 대비해 + 1
        int[] B = new int[max_length + 1]; // 마지막 자리수 올림이 있을 경우를 대비해 + 1

        // A배열 초기화
        for (int i = str_A.length() - 1, idx = 0; i >= 0; i--, idx++) {
            A[idx] = str_A.charAt(i) - '0';
        }

        // B배열 초기화
        for (int i = str_B.length() - 1, idx = 0; i >= 0; i--, idx++) {
            B[idx] = str_B.charAt(i) - '0';
        }

        for (int i = 0; i < max_length; i++) {
            int result = A[i] + B[i]; // 배열의 자리수 끼리 더함.
            A[i] = result % 10; // 더한 result을 10으로 나눈 나머지의 값을 A 배열에 저장 (나머지가 자리값)
            A[i + 1] += result / 10; // 만약 result가 10이 넘었다면 그 다음 인덱스에 몫을 더함 (자리 올림)
        }

        StringBuilder sb = new StringBuilder();

        if (A[max_length] != 0) { // 0이 아닐 때는 자리올림이 발생했기 때문에 sb에 자리 올림 수를 넣는다 (덧셈이기에 1이 올라갈 것이다.)
            sb.append(A[max_length]);
        }

        for (int i = max_length - 1; i >= 0; i--) { // max_length - 1로 돌리는 이유는 자리올림이 발생하지 않았을 경우 0을 포함하지 않기 위해서이다.
                                                    // (첫 배열을 max_length + 1로 잡았기 때문)
            sb.append(A[i]);
        }

        System.out.println(sb);
    }
}
