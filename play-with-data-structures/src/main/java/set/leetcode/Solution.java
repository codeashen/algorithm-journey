package set.leetcode;

import com.journey.algorithm.common.annotation.LeetCode;

import java.util.HashSet;

@LeetCode(id = 804, title = "唯一摩尔斯密码词")
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", 
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                res.append(codes[word.charAt(i) - 'a']);
            }
            set.add(res.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        
    }
}