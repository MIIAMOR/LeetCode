package com.yubin.easy.part1;

/**
 * @author MIIAMOR
 * @date 2021/7/3 14:38
 */
public class FirstBadVersion extends VersionControl {
    public FirstBadVersion(int version) {
        super(version);
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        int mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (!isBadVersion(mid)) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        FirstBadVersion f = new FirstBadVersion(1702766719);
        System.out.println(f.firstBadVersion(2126753390));
    }
}

class VersionControl {
    protected int version;

    public VersionControl(int version) {
        this.version = version;
    }

    public boolean isBadVersion(int n) {
        return n >= version;
    }
}