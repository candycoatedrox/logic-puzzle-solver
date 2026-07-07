public class BetweenClue extends Clue {

    // "Of X and Y, one is A and the other is B" clues

    private final int[] valueA;
    private final int[] valueB;

    private final int[] valueX;
    private final int[] valueY;

    // --- CONSTRUCTORS ---

    public BetweenClue(int[] valueA, String clueTextA, int[] valueB, String clueTextB, int[] valueX, String clueTextX, int[] valueY, String clueTextY) {
        if (!Utils.isValidValueReference(valueA) || !Utils.isValidValueReference(valueB) || !Utils.isValidValueReference(valueX) || !Utils.isValidValueReference(valueY)) {
            throw new IllegalArgumentException("Value references must be pairs");
        }

        this.valueA = valueA;
        this.valueB = valueB;
        this.valueX = valueX;
        this.valueY = valueY;

        setDisplayText("Of " + clueTextA + " and " + clueTextB + ", one is " + clueTextX + " and the other is " + clueTextY + ".");
    }

    public BetweenClue(String overrideDisplayText, int[] valueA, int[] valueB, int[] valueX, int[] valueY, String clueTextY) {
        super(overrideDisplayText);

        if (!Utils.isValidValueReference(valueA) || !Utils.isValidValueReference(valueB) || !Utils.isValidValueReference(valueX) || !Utils.isValidValueReference(valueY)) {
            throw new IllegalArgumentException("Value references must be pairs");
        }

        this.valueA = valueA;
        this.valueB = valueB;
        this.valueX = valueX;
        this.valueY = valueY;
    }

    public BetweenClue(int catA, int valA, String clueTextA, int catB, int valB, String clueTextB, int catX, int valX, String clueTextX, int catY, int valY, String clueTextY) {
        int[] a = {catA, valA};
        int[] b = {catB, valB};
        int[] x = {catX, valX};
        int[] y = {catY, valY};
        this.valueA = a;
        this.valueB = b;
        this.valueX = x;
        this.valueY = y;

        setDisplayText("Of " + clueTextA + " and " + clueTextB + ", one is " + clueTextX + " and the other is " + clueTextY + ".");
    }

    public BetweenClue(String overrideDisplayText, int catA, int valA, int catB, int valB, int catX, int valX, int catY, int valY) {
        super(overrideDisplayText);
        
        int[] a = {catA, valA};
        int[] b = {catB, valB};
        int[] x = {catX, valX};
        int[] y = {catY, valY};
        this.valueA = a;
        this.valueB = b;
        this.valueX = x;
        this.valueY = y;
    }

    // --- GETTERS ---

    public boolean pairABShareCategory() {
        return valueA[0] == valueB[0];
    }

    public boolean pairXYShareCategory() {
        return valueX[0] == valueY[0];
    }

    public int[][] getValueReferences() {
        int[][] refs = {valueA, valueB, valueX, valueY};
        return refs;
    }

    public int[][] getPairAB() {
        int[][] refs = {valueA, valueB};
        return refs;
    }

    public int[][] getPairXY() {
        int[][] refs = {valueX, valueY};
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

    public int[] getReferenceX() {
        return valueX;
    }

    public int getCategoryX() {
        return valueX[0];
    }

    public int getValueX() {
        return valueX[1];
    }

    public int[] getReferenceY() {
        return valueY;
    }

    public int getCategoryY() {
        return valueY[0];
    }

    public int getValueY() {
        return valueY[1];
    }
    
}
