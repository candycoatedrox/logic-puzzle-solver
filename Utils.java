public class Utils {
    
    public static String toSentenceCase(String s) {
        String str = "" + Character.toUpperCase(s.charAt(0));
        
        char c;
        boolean afterPeriod = false;
        for (int i = 1; i < s.length(); i++) {
            c = s.charAt(i);
            if (afterPeriod && c != ' ' && !isPunctuation(c)) {
                s += Character.toUpperCase(c);
                afterPeriod = false;
            } else {
                s += c;
                if (isSentenceEndingPunctuation(c)) afterPeriod = true;
            }
        }

        return str;
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

}
