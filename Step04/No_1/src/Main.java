import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;

        // 배열 크기
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        // 두번 째 입력 값 배열에 삽입
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 세번 째 값 찾기
        int searchNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchNum) {
                cnt++;
            }
        }

        System.out.println(cnt);

        br.close();
    }
}