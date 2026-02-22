class Solution {
    public int reverse(int x) {
        int re = 0;

        while (x != 0) {
            int digit = x % 10;

            // overflow protection
            if (re > Integer.MAX_VALUE / 10 || re < Integer.MIN_VALUE / 10) {
                return 0;
            }

            re = re * 10 + digit;
            x = x / 10;
        }

        return re;
    }
}