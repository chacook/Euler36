public class Euler36 {
    public static void main(String[] args) {
        doublePals(1,999999);
    }

    //prints out all numbers that are decimal and binary palindromes
    public static void doublePals(int min, int max) {
        String decimal;
        String binary;
        int sum = 0;
        int start = min;

        //starting number must be odd
        if (start % 2 == 0) start++;

        //increment by 2 since only odd numbers can be palindromes in binary
        for (int i = start; i <= max; i += 2) {
            decimal = Integer.toString(i);

            if (isPalindrome(decimal)){
                binary = decimalToBinary(i);

                if (isPalindrome(binary)){
                    System.out.println(decimal + " - " + binary);
                    sum += i;
                }
            }
        }

        System.out.format("Sum of all double palindromes between %d and %d: %d\n", min, max, sum);
    }

    //converts a decimal integer to a binary string
    public static String decimalToBinary(int n) {
        //works for n > 0
        String result = "";
        int r;

        while (n > 0) {
            r = n % 2;
            result = Integer.toString(r) + result;
            n /= 2;
        }

        return result;
    }

    //checks if a string is a palindrome
    public static boolean isPalindrome(String s) {
        boolean palindrome = true;
        int len = s.length();

        for (int i = 0; i < len/2; i++) {
            if (s.charAt(i) != s.charAt(len-i-1)) {
                palindrome = false;
                break;
            }
        }

        return palindrome;
    }
}//Euler36
