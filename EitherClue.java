public class EitherClue extends Clue {

    // "X is either Y or Z" clues

    private final int[] valueA;
    private final int[] eitherOrA;
    private final int[] eitherOrB;

    // --- CONSTRUCTORS ---

    public EitherClue(int[] valueA, String clueTextA, int[] valueB, String clueTextB, int[] valueC, String clueTextC) {
        if (!Utils.isValidValueReference(valueA) || !Utils.isValidValueReference(valueB) || !Utils.isValidValueReference(valueC)) {
            throw new IllegalArgumentException("Value references must be pairs");
        }

        this.valueA = valueA;
        eitherOrA = valueB;
        eitherOrB = valueC;

        setDisplayText(clueTextA + " is either " + clueTextB + " or " + clueTextC + ".");
    }

    public EitherClue(String overrideDisplayText, int[] valueA, int[] valueB, int[] valueC) {
        super(overrideDisplayText);

        if (!Utils.isValidValueReference(valueA) || !Utils.isValidValueReference(valueB) || !Utils.isValidValueReference(valueC)) {
            throw new IllegalArgumentException("Value references must be pairs");
        }

        this.valueA = valueA;
        eitherOrA = valueB;
        eitherOrB = valueC;
    }

    public EitherClue(int catA, int valA, String clueTextA, int catB, int valB, String clueTextB, int catC, int valC, String clueTextC) {
        int[] a = {catA, valA};
        int[] b = {catB, valB};
        int[] c = {catC, valC};
        this.valueA = a;
        eitherOrA = b;
        eitherOrB = c;

        setDisplayText(clueTextA + " is either " + clueTextB + " or " + clueTextC + ".");
    }

    public EitherClue(String overrideDisplayText, int catA, int valA, int catB, int valB, int catC, int valC) {
        super(overrideDisplayText);
        
        int[] a = {catA, valA};
        int[] b = {catB, valB};
        int[] c = {catC, valC};
        this.valueA = a;
        eitherOrA = b;
        eitherOrB = c;
    }

    // --- GETTERS ---

    public boolean eitherOrShareCategory() {
        return eitherOrA[0] == eitherOrB[0];
    }

    public int[][] getValueReferences() {
        int[][] refs = {valueA, eitherOrA, eitherOrB};
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
        return eitherOrA;
    }

    public int getCategoryB() {
        return eitherOrA[0];
    }

    public int getValueB() {
        return eitherOrA[1];
    }

    public int[] getReferenceC() {
        return eitherOrB;
    }

    public int getCategoryC() {
        return eitherOrB[0];
    }

    public int getValueC() {
        return eitherOrB[1];
    }

    // --- RESOLVE ---

    @Override
    public boolean resolve(LogicPuzzleGrid grid) {
        // returns true if anything changed, false otherwise

        // TODO


        return false;
    }
    
}
