import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // array 크기 지정
        // int[] array = new int[Integer.parseInt(st.nextToken())];
        int n = Integer.parseInt(st.nextToken());
        int[] array = new int[n];

        // 보다 작은 값 입력, 수열 입력
        int num = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        // 배열에 값 넣기
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 배열에서 작은 값 찾기
        for (int i = 0; i < array.length; i++) {
            if (array[i] < num) {
                sb.append(array[i]).append(" ");
            }
        }

        System.out.println(sb);

        br.close();
    }
}
