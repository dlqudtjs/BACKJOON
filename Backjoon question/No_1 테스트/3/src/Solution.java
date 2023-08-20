import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    static int Answer;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            int binaryLength = Integer.parseInt(br.readLine());
            String input = br.readLine().replace(" ", "");

            long inputBinary;
            try {
                inputBinary = Long.parseLong(input, 2);
            } catch (NumberFormatException e) {
                sb.append("Case #").append(test_case + 1).append("\n").append(0).append("\n");
                continue;
            }
            long shiftedBinary = inputBinary;

            int count = 0;
            while (true) {
                count++;
                if (shiftedBinary % 2 == 0) {
                    shiftedBinary = shiftedBinary >> 1;
                } else {
                    shiftedBinary = shiftedBinary >> 1;
                    shiftedBinary += (long) Math.pow(2, binaryLength - 1);
                }

                if (inputBinary == shiftedBinary) {
                    Answer = count;
                    break;
                }

                if (count > binaryLength) {
                    break;
                }
            }

            sb.append("Case #").append(test_case + 1).append("\n").append(Answer).append("\n");
        }

        System.out.println(sb);
    }
}
