public class Solution {

    public static boolean isPalindrome(int x) {
        if (x < 0) { return false; }

        String number = String.valueOf(x);
        int length = number.length();
        for(int i = 0; i < number.length() / 2; i++) {
            String first = number.substring(i, i+1);
            String second = number.substring(length-1, length);
            if (!first.equals(second)) { return false; }
            length -= 1;
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

    public static boolean mathIsPalindrome(int x) {
        int original = x;
        int remainder = 0;
        while ( x > 0) {
            /*
            remainder * 10 gets the current remainder value and bumps it up one digit. Ex: 1 -> 10 | 10 -> 100 | 100 -> 1000
            x % 10 gets the value of the lowest/ones digit. Ex: 12 -> 2 | 146 -> 6 | 4837 -> 7
            Add them together to get the reverse of x
            Ex: 123 | 0
                12  | 3
                1   | 32
                0   | 321
             */
            remainder = (remainder * 10) + (x % 10);
            x /= 10;
        }
        return remainder == original;
    }

    public static void main(String[] args) {
        System.out.println(mathIsPalindrome(
                2147483647));
    }
}
