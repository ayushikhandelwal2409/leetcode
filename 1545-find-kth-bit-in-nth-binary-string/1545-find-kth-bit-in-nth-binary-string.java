class Solution {

    public char findKthBit(int n, int k) {
        String result = build(n);
        return result.charAt(k - 1);   // k is 1-based
    }

    private String build(int n) {
        if (n == 1) {
            return "0";
        }

        String prev = build(n - 1);

        StringBuilder inverted = new StringBuilder();

        // Invert
        for (int i = 0; i < prev.length(); i++) {
            char ch = prev.charAt(i);
            inverted.append(ch == '0' ? '1' : '0');
        }

        // Reverse
        inverted.reverse();

        return prev + "1" + inverted.toString();
    }
}