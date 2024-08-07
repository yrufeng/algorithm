package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定括号对数，打印所有合法括号配对case
 */

public class LegalBraceNum {

    public static void main(String[] args) {
        LegalBraceNum solution = new LegalBraceNum();
        System.out.println(solution.generateParenthesis(4));
    }

    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }
}
