public class Main {
    public static void main(String[] args) throws Exception {
        int count = 0;
        int pre_str = 32; // 공백을 의미한다.
        int str;

        while (true) {
            str = System.in.read();

            // 입력받은 문자가 공백일 때,
            if (str == 32) {
                // 이전의 문자가 공백이 아니면
                if (pre_str != 32)
                    count++;
            } else if (str == 10) { // 입력받은 문자가 개행일때 ('\n')
                // 이전의 문자가 공백이 아니면
                if (pre_str != 32)
                    count++;
                break;
            }

            pre_str = str;
        }

        System.out.println(count);
    }
}

// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// StringTokenizer st = new StringTokenizer(br.readLine());
// br.close();

// System.out.println(st.countTokens());