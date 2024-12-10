package org.example.task1;

public record BracketCounter(int pairs) {

    public int calculateValidCombinations() {
        return countParentheses(pairs, pairs);
    }

    private int countParentheses(int open, int close) {
        if (close < open) {
            return 0;
        }

        if (open == 0 && close == 0) {
            return 1;
        }

        int count = 0;

        if (open > 0) {
            count += countParentheses(open - 1, close);
        }

        if (close > 0) {
            count += countParentheses(open, close - 1);
        }

        return count;
    }

}
