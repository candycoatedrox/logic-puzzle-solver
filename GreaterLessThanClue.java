public class GreaterLessThanClue extends Clue {

    // "X is somewhat greater/less than Y" clues

    private final boolean isGreater;

    private final int[] valueA;
    private final int[] valueB;

    // --- CONSTRUCTORS ---

    public GreaterLessThanClue(boolean isGreater, int[] valueA, String clueTextA, int[] valueB, String clueTextB) {
        if (!Utils.isValidValueReference(valueA) || !Utils.isValidValueReference(valueB)) {
            throw new IllegalArgumentException("Value references must be pairs");
        } else if (valueA[0] == 0 || valueB[0] == 0) {
            throw new IllegalArgumentException("Greater/less than clues cannot include values in the numerical category");
        }

        this.isGreater = isGreater;
        this.valueA = valueA;
        this.valueB = valueB;

        if (isGreater) {
            setDisplayText(clueTextA + " is greater than " + clueTextB + ".");
        } else {
            setDisplayText(clueTextA + " is less than " + clueTextB + ".");
        }
    }

    public GreaterLessThanClue(String overrideDisplayText, boolean isGreater, int[] valueA, int[] valueB) {
        super(overrideDisplayText);

        if (!Utils.isValidValueReference(valueA) || !Utils.isValidValueReference(valueB)) {
            throw new IllegalArgumentException("Value references must be pairs");
        } else if (valueA[0] == 0 || valueB[0] == 0) {
            throw new IllegalArgumentException("Greater/less than clues cannot include values in the numerical category");
        }

        this.isGreater = isGreater;
        this.valueA = valueA;
        this.valueB = valueB;
    }

    public GreaterLessThanClue(boolean isGreater, int catA, int valA, String clueTextA, int catB, int valB, String clueTextB) {
        if (catA == 0 || catB == 0) {
            throw new IllegalArgumentException("Greater/less than clues cannot include values in the numerical category");
        }

        int[] a = {catA, valA};
        int[] b = {catB, valB};
        this.isGreater = isGreater;
        this.valueA = a;
        this.valueB = b;

        if (isGreater) {
            setDisplayText(clueTextA + " is greater than " + clueTextB + ".");
        } else {
            setDisplayText(clueTextA + " is less than " + clueTextB + ".");
        }
    }

    public GreaterLessThanClue(String overrideDisplayText, boolean isGreater, int catA, int valA, int catB, int valB) {
        super(overrideDisplayText);

        if (catA == 0 || catB == 0) {
            throw new IllegalArgumentException("Greater/less than clues cannot include values in the numerical category");
        }

        int[] a = {catA, valA};
        int[] b = {catB, valB};
        this.isGreater = isGreater;
        this.valueA = a;
        this.valueB = b;
    }

    // --- GETTERS ---

    public boolean isGreaterThan() {
        return isGreater;
    }

    public boolean valuesShareCategory() {
        return valueA[0] == valueB[0];
    }

    public int[][] getValueReferences() {
        int[][] refs = {valueA, valueB};
        return refs;
    }

    public int[] getReferenceA() {
        return valueA;
    }

    public int getCategoryA() {
        return valueA[0];
    }

    public int getValueA() {
        return valueA[1];
    }

    public int[] getReferenceB() {
        return valueB;
    }

    public int getCategoryB() {
        return valueB[0];
    }

    public int getValueB() {
        return valueB[1];
    }
    
}
