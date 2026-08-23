
public class Palindrome {

    public static boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        return new StringBuilder(s).reverse().toString().toLowerCase().equals(s.toLowerCase());
    }
}
