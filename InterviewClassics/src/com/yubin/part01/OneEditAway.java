package com.yubin.part01;

/**
 * @author MIIAMOR
 * @date 2021/6/24 8:58
 * medium
 */
public class OneEditAway {
    public boolean oneEditAway(String first, String second) {
        int len1 = first.length(), len2 = second.length();
        if (Math.abs(len1 - len2) > 1) return false;
        if ((len1 == 1 && len2 == 0) || (len1 == 0 && len2 == 1) || (len1 == 1 && len2 == 1) || (len1 == 0 && len2 == 0))
            return true;
        char[] firstC = first.toCharArray(), secondC = second.toCharArray();
        int count = 0;
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (count > 1) break;
            if (firstC[i] == secondC[j]) {
                i++;
                j++;
            } else {
                if (len1 < len2) {
                    // len1小 选择在first上添加一个字符
                    count++;
                    j++;
                } else if (len1 > len2) {
                    // len1大 选择在first上删除一个字符
                    count++;
                    i++;
                } else {
                    // 一样大 选择在first上替换一个字符
                    count++;
                    i++;
                    j++;
                }
            }
        }
        return count <= 1;
    }
}
