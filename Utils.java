public class Utils {

    // --- CHECK VALUE REFERENCES ---

    public static boolean isValidValueReference(int[] ref) {
        return ref.length == 2;
    }

    public static boolean areValidValueReferences(int[][] refs) {
        for (int[] r : refs) {
            if (!isValidValueReference(r)) return false;
        }
        return true;
    }

    // --- ARRAY COMPARISON ---

    public static boolean arraysAreEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static boolean arraysAreEqual(int[][] a, int[][] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!arraysAreEqual(a[i], b[i])) return false;
        }
        return true;
    }

    // --- STRING MANAGEMENT ---

    public static String arrayToString(int[] arr) {
        String s = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) s += ",";
            s += arr[i];
        }
        s += "]";
        return s;
    }

    public static String arrayToString(int[][] arr) {
        String s = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) s += ", ";
            s += arrayToString(arr[i]);
        }
        s += "]";
        return s;
    }

    public static String numWithCommas(int n) {
        boolean negative = n < 0;
        if (negative) n *= -1;

        String s = String.valueOf(n);
        if (s.length() <= 3) {
            if (negative) s = "-" + s;
            return s;
        }

        String output = s.substring(s.length() - 3);
        
        int i;
        for (i = s.length() - 6; i > 0; i -= 3) {
            output = s.substring(i, i+3) + "," + output;
        }
        output = s.substring(0, i+3) + "," + output;

        if (negative) output = "-" + output;
        return output;
    }

    public static String numWithCommas(double n) {
        String integer = numWithCommas((int)n);
        if (n % 1 == 0) return integer; // double is functionally an integer

        String s = String.valueOf(n);
        String decimal = s.split("\\.")[1];
        return integer + "." + decimal;
    }
    
    public static String toSentenceCase(String s) {
        String str = "";
        
        char c;
        boolean afterPeriod = true;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (afterPeriod && c != ' ' && !isPunctuation(c)) {
                str += Character.toUpperCase(c);
                afterPeriod = false;
            } else {
                str += c;
                if (isSentenceEndingPunctuation(c)) afterPeriod = true;
            }
        }

        return str;
    }

    public static String numToString(int n) {
        switch (n) {
            case 0: return "zero";
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            case 10: return "ten";
            case 11: return "eleven";
            case 12: return "twelve";
            case 13: return "thirteen";
            case 14: return "fourteen";
            case 15: return "fifteen";
            case 16: return "sixteen";
            case 17: return "seventeen";
            case 18: return "eighteen";
            case 19: return "nineteen";
            case 20: return "twenty";

            case 30: return "thirty";
            case 40: return "fourty";
            case 50: return "fifty";
            case 60: return "sixty";
            case 70: return "seventy";
            case 80: return "eighty";
            case 90: return "ninety";
            case 100: return "one hundred";

            default: return String.valueOf(n);
        }
    }

    public static boolean isPunctuation(char c) {
        switch (c) {
            case ',':
            case '.':
            case '?':
            case '!':
            case ':':
            case ';':
            case '-': return true;
            default: return false;
        }
    }

    public static boolean isSentenceEndingPunctuation(char c) {
        switch (c) {
            case '.':
            case '?':
            case '!': return true;
            default: return false;
        }
    }

    // --- MISC ---

    public static int additionFactorial(int n) {
        if (n <= 1) {
            return n;
        } else {
            return n + additionFactorial(n-1);
        }
    }

}
