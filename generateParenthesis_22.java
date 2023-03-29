import java.util.ArrayList;
import java.util.List;
public class generateParenthesis_22 {
    /**
     * 22. 括号生成
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     * 解法：
     *      回溯。
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, "", 0, 0, n);
        return result;
    }

    public void helper(List<String> result, String str, int open, int close, int n) {
        if (open == n && close == n) {
            result.add(str);
            return;
        }

        if (open < n) {
           helper(result, str + "(", open + 1, close, n);
        }

        if (open > close) {
            helper(result, str + ")", open, close + 1, n);
        }
    }
}
