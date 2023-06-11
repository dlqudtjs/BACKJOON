import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            sb.append(recursion(str, 0, str.length() - 1, false)).append("\n");
        }

        System.out.println(sb);
    }

    private static int recursion(String str, int start, int end, boolean remove) {
        while (start <= end) {
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
                continue;
            }

            // 재귀로 들어온 함수는 더이상 삭제할 수 없기 때문에 return 2를 해준다.
            if (remove) {
                return 2;
            }

            // 양 끝의 포인터가 서로 같은 문자가 아니라면 포인터를 한 칸 움직인 후 확인한다.
            int result = Math.min(recursion(str, start + 1, end, true), recursion(str, start, end - 1, true));

            return result != 2 ? 1 : result;
        }

        // 첫 번째 if문에서 끝났을 경우 (회문)
        return 0;
    }
}
