package com.yubin.medium.part2;

import java.util.*;

/**
 * @author MIIAMOR
 * @date 2021/7/9 12:27
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        char[] c = s1.toCharArray();
        Arrays.sort(c);
        String target = String.valueOf(c);
        int len = s2.length();
        int left = 0, right = s1.length();
        while (right <= len) {
            String s = s2.substring(left, right);
            c = s.toCharArray();
            Arrays.sort(c);
            s = String.valueOf(c);
            if (target.equals(s)) return true;
            left++;
            right++;
        }
        return false;
    }

    public boolean checkInclusion1(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        char[] chars1 = s1.toCharArray(), chars2 = s2.toCharArray();
        int[] count1 = new int[26], count2 = new int[26];
        for (int i = 0; i < chars1.length; i++) {
            count1[chars1[i] - 'a']++;
            count2[chars2[i] - 'a']++;
        }
        int left = 0, right = chars1.length;
        int len = chars2.length;
        while (right <= len) {
            int count = 0;
            for (int i = 0; i < 26; i++) {
                if (count1[i] != count2[i]) break;
                count++;
            }
            if (count == 26) return true;
            if (right == len) break;
            count2[chars2[left] - 'a']--;
            count2[chars2[right] - 'a']++;
            left++;
            right++;
        }
        return false;
    }
}
