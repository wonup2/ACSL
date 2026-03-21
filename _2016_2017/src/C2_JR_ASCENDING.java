import java.util.*;

public class C2_JR_ASCENDING {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Process 5 lines of input
        for (int t = 0; t < 5; t++) {
            String s = sc.nextLine();

            List<Integer> result = new ArrayList<>();

            int i = 0;

            // Step 1: The first number is always the first digit
            int prev = s.charAt(i) - '0';
            result.add(prev);
            i++;

            // Step 2: Build the rest of the sequence
            while (i < s.length()) {
                int num = 0;
                boolean found = false;

                // Try forming numbers by extending digits one by one
                for (int j = i; j < s.length(); j++) {
                    num = num * 10 + (s.charAt(j) - '0');

                    // If the current number is greater than the previous one,
                    // accept it and move forward
                    if (num > prev) {
                        result.add(num);
                        prev = num;
                        i = j + 1; // move index forward
                        found = true;
                        break;
                    }
                }

                // If no valid number can be formed, stop processing
                if (!found) break;
            }

            // Step 3: Print the result sequence
            for (int k = 0; k < result.size(); k++) {
                System.out.print(result.get(k));
                if (k < result.size() - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}