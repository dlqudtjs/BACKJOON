import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String find = br.readLine();
        int answer = 0;

        for (int i = 0; i < str.length() - find.length() + 1; i++) {
            if (str.substring(i, i + find.length()).equals(find)) {
                answer++;
                i += find.length() - 1; // - 1의 이유: for문에서 i++을 한 번 더 하기 때문
            }
        }

        System.out.println(answer);
    }
}
