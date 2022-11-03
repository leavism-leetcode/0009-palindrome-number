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

    public static boolean mathIsPalindrome(int x) {
        int length = String.valueOf(x).length();
        int original = x;
        int rem = 0;
        double dec = Math.pow(10, length - 1);
        while ( x > 0) {
            rem += (x % 10) * dec;
            dec /= 10;
            x /= 10;
        }
        return rem == original;
    }

    public static void main(String[] args) {
        System.out.println(mathIsPalindrome(
                2147483647));

        // 1234 || 0
        // 123 R 4 || 4
        // 123 R 3 || 34 43

        // 12321 || 0
        // 1232 R 1 || 1
        // 123 R 2 || 21
        // 12 R 3 || 321
        // 1 R 2 || 2321
        // 0 R 1 || 12321

        // 1221
        // 122 R 1
        // 12 R 2
        // 1 R 2
        // 0 R 1
    }
}
