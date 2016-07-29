public class Solution {
        public List<Integer> diffWaysToCompute(String input) {
        // separate all numbers and operators from the input string
        List<String> element = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                element.add(input.substring(start, i));
                element.add(input.substring(i, i + 1));
                start = i + 1;
            }
        }
        element.add(input.substring(start));
        // f[i][j] represents all results from number i to number j
        // initiate
        int numCount = (element.size() + 1) / 2; // there are k numbers and k-1 operators in total.
        List<Integer>[][] results = new ArrayList[numCount][numCount];

        // state
        // from number i to i, result equals itself
        for (int i = 0; i < numCount; i++) {
            results[i][i] = new ArrayList<>();
            results[i][i].add(Integer.valueOf(element.get(i * 2)));
        }

        // function
        // f[i][j] = f[i~k][j] && f[i][k~j]
        for (int len = 2; len <= numCount; len++) { // th of i ~ j
            for (int i = 0; i + len <= numCount; i++) {
                int j = i + len - 1;
                results[i][j] = new ArrayList<>();
                for (int k = i; k < j; k++) { // k is splitting line between i and j
                    String operator = element.get(2 * k + 1);
                    for (Integer num1 : results[i][k]) {
                        for (Integer num2 : results[k + 1][j]) {
                            if (operator.equals("+")) {
                                results[i][j].add(num1 + num2);
                            } else if (operator.equals("-")) {
                                results[i][j].add(num1 - num2);
                            } else {
                                results[i][j].add(num1 * num2);
                            }
                        }
                    }
                }
            }
        }
        return results[0][numCount - 1];
    }
}