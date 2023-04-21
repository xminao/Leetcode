public class lengthODLastWord_58 {
    /**
     * 58. 最后一个单词的长度
     * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
     *
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     *
     * 解法：
     *      从最后一个字符往前遍历，维护一个长度值，如果字符为空且维护的长度为0，则是末尾的空格，继续遍历；如果字符为空，维护的
     *      长度不为0，则最后一个单词的长度为length，返回。
     */
    public int lengthOfLastWord(String s) {
        int length = 0;
        char[] str_arr = s.toCharArray();
        for (int i = str_arr.length - 1; i >= 0 ; i -= 1) {
            if (str_arr[i] == ' ' && length != 0) {
                return length;
            } else if (str_arr[i] != ' ') {
                length += 1;
            }
        }
        return length;
    }
}
