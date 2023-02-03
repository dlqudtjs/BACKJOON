import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[26]; // A - Z 총 26개의 알파벳을 저장하기 위한 배열

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            // ABC 라면 base는 100이 된다. 10의 ABC.length(3)승
            int base = (int) Math.pow(10, line.length() - 1);

            for (int j = 0; j < line.length(); j++) {
                // 해당 알파벳 인덱스에 해당하는 곳에 자신의 자리 값을 넣는다.
                // ex) ABC라면 A일 땐 100, B일땐 10, C일 땐 1
                arr[line.charAt(j) - 'A'] += base;
                base /= 10;
            }
        }

        // 내림차순으로 정렬하면 편하긴 하지만 내림차순으로 정렬하기 위해서는
        // Integer[] 배열 형태여야 하기 때문에 오름차순으로 정렬한다.
        Arrays.sort(arr);

        int sum = 0;

        for (int i = 25; i >= 17; i--) { // 25 ~ 17 까지 1 ~ 9 까지 오름차순이기때문에 끝에서부터 순회한다.
            // 배열에 저장된 값을 (i - 16)즉 9 -> 1 순으로 곱해준다. (맨 뒤에 수가 가장 크기 때문에)
            sum += arr[i] * (i - 16);
        }

        System.out.println(sum);
    }
}

/*
 * ABCD, ABC라는 2개의 단어가 주어졌다고 하자.
 * ABCD = A * 1000 + B * 100 + C * 10 + D * 1
 * ABC = A * 100 + B * 10 + C * 1 으로 표현할 수 있다.
 * 그렇기에 위에 수를 다 더한 후 A = 1100, B = 110, C = 11, D = 1가 나오게 된다.
 */