
public class Palindrome {

    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        return new StringBuilder(s).reverse().toString().toLowerCase().equals(s.toLowerCase());
    }
}
