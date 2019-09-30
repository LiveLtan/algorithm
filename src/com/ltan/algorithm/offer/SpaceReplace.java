package com.ltan.algorithm.offer;

/**
 * Detail: from For-offer space-replace
 * <p>
 * Created by tanlin on 2019-09-30
 */
public class SpaceReplace {
    public String replaceSpace(StringBuffer str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        String string = str.toString();
        string = string.replaceAll("\\s", "%20");
        // str.replaceAll("\\s+", "%20");
        return string;
    }

    public static void run() {
        SpaceReplace sr = new SpaceReplace();
        String rst = sr.replaceSpace(new StringBuffer("We Are Happy"));
        System.out.println("rst is:" + rst);
    }
}
