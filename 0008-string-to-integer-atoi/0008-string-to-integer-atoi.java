class Solution {
    public int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        boolean signFound = false, digitStarted = false;

        for (char ch : s.toCharArray()) {
            //  Skip leading spaces until something starts
            if (!digitStarted && !signFound && ch == ' ') {
                continue;
            }

            // Handle sign (only once, and only before digits)
            if (!digitStarted && !signFound && (ch == '-' || ch == '+')) {
                sb.append(ch);
                signFound = true;
                continue;
            }

            // Handle digits
            if (Character.isDigit(ch)) {
                sb.append(ch);
                digitStarted = true;
                continue;
            }
            break;// end if any other character comes
        }

        //If no digits or just sign, return 0
        if (sb.length() == 0 || sb.toString().equals("-") || sb.toString().equals("+")) {
            return 0;
        }

        //parsing safely (handle overflow)
        try {
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return (sb.charAt(0) == '-') ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }
}
