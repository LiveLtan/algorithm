package com.ltan.algorithm.session;

import java.util.HashMap;

/**
 * Detail: Leetcode 299
 * <p>
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask
 * your friend to guess what the number is.
 * <p>
 * Each time your friend makes a guess, you provide a hint that
 * indicates how many digits in said guess match your secret number exactly in both digit and position
 * (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows").
 * <p>
 * Your friend will use successive guesses and hints to eventually derive the secret number.
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate
 * the bulls and B to indicate the cows.
 * <p>
 * Please note that both secret number and friend's guess may contain duplicate digits.
 *
 * <p>
 * Example:
 * Input: secret = "1807", guess = "7810"
 * Output: "1A3B"
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * <p>
 * Input: secret = "1123", guess = "0111"
 * Output: "1A1B"
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 * <p>
 * Added by ltan on 2018/8/21
 */
public class AlgorithmBullsCrows {

    /**
     * look up for {@link #getHint3(String, String)}
     * but speed is too slow
     * @param secret secret
     * @param guess  guess
     * @return  tips string
     */
    public String getHint(String secret, String guess) {
        if (secret == null || guess == null || secret.length() != guess.length()) {
            return "";
        }
        int bullsNum = 0, cowNum = 0;
        int length = secret.length();
        HashMap<Character, Integer> map = new HashMap<>(length);

        for (char s : secret.toCharArray()) {
            if(map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        for (int i = 0; i < length; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(!map.containsKey(g)) {
                continue;
            }
            if (map.get(g) > 0) {
                cowNum++;
            }
            if (g == s) {
                bullsNum++;
                cowNum--;
            }
            map.put(g, map.get(g) - 1);
        }

        return String.valueOf(bullsNum) + "A" + cowNum + "B";
    }

    /**
     * Individual calculate the bull and cow
     *
     * @param secret secret
     * @param guess  guess
     * @return  tips string
     */
    public String getHint2(String secret, String guess) {
        HashMap<Character, Integer> map = new HashMap<>();
        int bull = 0, cow = 0;
        for (char s : secret.toCharArray()) {
            map.put(s, 0);
        }
        for (int i = 0; i < secret.length(); i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                bull++;
                continue;
            }
            // maybe a cow
            char secChar = secret.charAt(i);
            map.put(secChar, map.get(secChar) + 1);
        }

        for (int i = 0; i < guess.length(); i++) {
            // bull calculated...
            if (guess.charAt(i) == secret.charAt(i)) {
                continue;
            }
            char guessChar = guess.charAt(i);
            // the sec char equal guess char, it's really a crow, set the count - 1 incase of same number
            if (map.containsKey(guessChar) && map.get(guessChar) > 0) {
                map.put(guessChar, map.get(guessChar) - 1);
                cow++;
            }
        }
        return (bull + "A" + cow + "B");
    }

    /**
     * Maybe the best way of this algorithm
     * O(1) space, O(n) complexity
     *
     * @param secret secret
     * @param guess  guess
     * @return  tips string
     */
    public String getHint3(String secret, String guess) {
        if (secret == null || guess == null || secret.length() != guess.length()) {
            return "";
        }
        int len = guess.length();
        // how many char are same in the secret string
        int[] secretSameCountArray = new int[10];
        int bull = 0, cow = 0;
        for (int i = 0; i < len; i++) {
            int arrayIndex = secret.charAt(i) - '0';
            secretSameCountArray[arrayIndex]++;
        }

        for (int i = 0; i < len; i++) {
            char g = guess.charAt(i);
            char s = secret.charAt(i);
            int index = g - '0';
            if (secretSameCountArray[index]-- > 0) {
                cow++;
            }
            // indicate a cow before some step at the same guess, but it is a bull actually, ignore the cow.
            if (g == s) {
                bull++;
                cow--;
            }
        }
        return (bull + "A" + cow + "B");
    }
}
