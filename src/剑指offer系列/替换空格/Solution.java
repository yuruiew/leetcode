package 剑指offer系列.替换空格;

public class Solution {

    /**
     * 调用库方法
     * @param s
     * @return
     */
    public String replaceSpaceS1(String s) {
        return s.replaceAll(" ", "%20");
    }

    /**
     * StringBuilder拼接
     * @param s
     * @return
     */
    public String replaceSpaceS2(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                res.append("%20");
            }else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
