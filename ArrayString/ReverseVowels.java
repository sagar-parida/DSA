package DSA.ArrayString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 345. Reverse Vowels of a String
// Given a string s, reverse only all the vowels in the string and return it.

// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

// Example 1:

// Input: s = "hello"
// Output: "holle"
// Example 2:

// Input: s = "leetcode"
// Output: "leotcede"

// Constraints:

// 1 <= s.length <= 3 * 105
// s consist of printable ASCII characters.

public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("leetcode"));
    }

    public static String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A',
                'E', 'I', 'O', 'U'));

        char[] chars = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }

            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }

            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;
            }
        }

        return new String(chars);
    }

    // Brute Forcer
    // public static String reverseVowels(String s) {
    // StringBuilder sb = new StringBuilder(s);
    // List<Character> vowels = new ArrayList<>();
    // List<Integer> indexs = new ArrayList<>();
    // List targets = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A',
    // 'E', 'I', 'O', 'U'));
    // for (int i = 0; i < s.length(); i++) {
    // if (targets.contains(s.charAt(i))) {
    // vowels.add(s.charAt(i));
    // indexs.add(i);
    // }
    // }

    // for (int i = 0; i < vowels.size(); i++) {
    // sb.setCharAt(indexs.get(i), vowels.get(vowels.size() - 1 - i));
    // }
    // return sb.toString();
    // }
}
