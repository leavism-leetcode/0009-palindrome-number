public class Solution {

    public static boolean isPalindrome(int x) {
        if (x < 0) { return false; }

        String number = String.valueOf(x);
        int j = number.length();
        for(int i = 0; i < number.length() / 2; i++) {
            String first = number.substring(i, i+1);
            String second = number.substring(j-1, j);
            if (!first.equals(second)) { return false; }
            j -= 1;
        }
        return true;
    }

    // Lmao this is a worse solution
    public static boolean halfIsPalindrome(int x) {
        if (x < 0) { return false; }

        String number = String.valueOf(x);
        String second;
        String reverseHalf = "";
        int half;

        if (number.length() % 2 == 0) {
            half = number.length() / 2;
            second = number.substring(half);
            number = number.substring(0, half);
        } else {
            half = (number.length() / 2) + 1;
            second = number.substring(half);
            number = number.substring(0, half - 1);
        }

        for(int i = second.length() - 1; i >= 0; i--) {
            reverseHalf += second.charAt(i);
        }

        if (number.equals(reverseHalf)) { return true; }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(halfIsPalindrome(12521));

        // 12 3 21
        // 123 321
        // 123 123
    }
}
