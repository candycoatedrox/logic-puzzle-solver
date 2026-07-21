public class NeitherClue extends Clue {

    // "Neither X nor Y is Z" clues

    private final int[] valueA;
    private final int[] valueB;
    private final int[] valueC;

    // --- CONSTRUCTORS ---

    public NeitherClue(int[] valueA, String clueTextA, int[] valueB, String clueTextB, int[] valueC, String clueTextC) {
        if (!Utils.isValidValueReference(valueA) || !Utils.isValidValueReference(valueB) || !Utils.isValidValueReference(valueC)) {
            throw new IllegalArgumentException("Value references must be pairs");
        }

        this.valueA = valueA;
        this.valueB = valueB;
        this.valueC = valueC;

        setDisplayText("Neither " + clueTextA + " nor " + clueTextB + " is " + clueTextC + ".");
    }

    public NeitherClue(String overrideDisplayText, int[] valueA, int[] valueB, int[] valueC) {
        super(overrideDisplayText);

        if (!Utils.isValidValueReference(valueA) || !Utils.isValidValueReference(valueB) || !Utils.isValidValueReference(valueC)) {
            throw new IllegalArgumentException("Value references must be pairs");
        }

        this.valueA = valueA;
        this.valueB = valueB;
        this.valueC = valueC;
    }

    public NeitherClue(int catA, int valA, String clueTextA, int catB, int valB, String clueTextB, int catC, int valC, String clueTextC) {
        int[] a = {catA, valA};
        int[] b = {catB, valB};
        int[] c = {catC, valC};
        this.valueA = a;
        this.valueB = b;
        this.valueC = c;

        setDisplayText("Neither " + clueTextA + " nor " + clueTextB + " is " + clueTextC + ".");
    }

    public NeitherClue(String overrideDisplayText, int catA, int valA, int catB, int valB, int catC, int valC) {
        super(overrideDisplayText);
        
        int[] a = {catA, valA};
        int[] b = {catB, valB};
        int[] c = {catC, valC};
        this.valueA = a;
        this.valueB = b;
        this.valueC = c;
    }

    // --- GETTERS ---

    public int[][] getValueReferences() {
        int[][] refs = {valueA, valueB, valueC};
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

    public int[] getReferenceC() {
        return valueC;
    }

    public int getCategoryC() {
        return valueC[0];
    }

    public int getValueC() {
        return valueC[1];
    }

    // --- RESOLVE ---

    @Override
    public boolean resolve(LogicPuzzleGrid grid) {
        // returns true if anything changed, false otherwise

        // TODO


        return false;
    }
    
}
