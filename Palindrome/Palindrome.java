
public class Palindrome {

    public static boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().toLowerCase().equals(s.toLowerCase());
    }
}
