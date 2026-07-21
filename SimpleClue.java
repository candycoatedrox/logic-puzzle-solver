public class SimpleClue extends Clue {

    // "X is/is not Y" clues
    
    private final boolean isEqual;
    
    private final int[] valueA;
    private final int[] valueB;

    // --- CONSTRUCTORS ---

    public SimpleClue(boolean isEqual, int[] valueA, String clueTextA, int[] valueB, String clueTextB) {
        if (!Utils.isValidValueReference(valueA) || !Utils.isValidValueReference(valueB)) {
            throw new IllegalArgumentException("Value references must be pairs");
        }

        this.isEqual = isEqual;
        this.valueA = valueA;
        this.valueB = valueB;

        if (isEqual) {
            setDisplayText(clueTextA + " is " + clueTextB + ".");
        } else {
            setDisplayText(clueTextA + " is not " + clueTextB + ".");
        }
    }

    public SimpleClue(String overrideDisplayText, boolean isEqual, int[] valueA, int[] valueB) {
        super(overrideDisplayText);

        if (!Utils.isValidValueReference(valueA) || !Utils.isValidValueReference(valueB)) {
            throw new IllegalArgumentException("Value references must be pairs");
        }

        this.isEqual = isEqual;
        this.valueA = valueA;
        this.valueB = valueB;
    }

    public SimpleClue(boolean isEqual, int catA, int valA, String clueTextA, int catB, int valB, String clueTextB) {
        int[] a = {catA, valA};
        int[] b = {catB, valB};
        this.isEqual = isEqual;
        this.valueA = a;
        this.valueB = b;

        if (isEqual) {
            setDisplayText(clueTextA + " is " + clueTextB + ".");
        } else {
            setDisplayText(clueTextA + " is not " + clueTextB + ".");
        }
    }

    public SimpleClue(String overrideDisplayText, boolean isEqual, int catA, int valA, int catB, int valB) {
        super(overrideDisplayText);

        int[] a = {catA, valA};
        int[] b = {catB, valB};
        this.isEqual = isEqual;
        this.valueA = a;
        this.valueB = b;
    }

    // --- GETTERS ---

    public boolean valuesAreEqual() {
        return isEqual;
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

    // --- RESOLVE ---

    @Override
    public boolean resolve(LogicPuzzleGrid grid) {
        // returns true if anything changed, false otherwise

        // TODO


        return false;
    }

}
