package DSA.ArrayString;

public class GCDString {

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC", "ABC"));
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(gcdOfStrings("LEET", "CODE"));
    }

    public static String gcdOfStrings(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();

        int gcdLength = gcd(n1, n2);

        for (int i = gcdLength; i >= 1; i--) {

            String candidate = str1.substring(0, i);

            if (divides(str1, candidate) && divides(str2, candidate)) {
                return candidate;
            }
        }

        return "";
    }

    public static boolean divides(String p, String q) {
        if (p.length() % q.length() != 0) {
            return false;
        }

        int repeatCount = p.length() / q.length();

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < repeatCount; i++) {
            str.append(q);
        }

        return str.toString().equals(p);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}

// 1071. Greatest Common Divisor of Strings
// For two strings s and t, we say "t divides s" if and only if s = t + t + t +
// ... + t + t (i.e., t is concatenated with itself one or more times).

// Given two strings str1 and str2, return the largest string x such that x
// divides both str1 and str2.

// Example 1:

// Input: str1 = "ABCABC", str2 = "ABC"
// Output: "ABC"
// Example 2:

// Input: str1 = "ABABAB", str2 = "ABAB"
// Output: "AB"
// Example 3:

// Input: str1 = "LEET", str2 = "CODE"
// Output: ""

// Constraints:

// 1 <= str1.length, str2.length <= 1000
// str1 and str2 consist of English uppercase letters.