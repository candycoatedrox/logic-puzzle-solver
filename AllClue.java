public class AllClue extends Clue {

    // "The N options were X, Y, Z, W, and V" clues

    private final int[][] values;

    // --- CONSTRUCTORS ---

    public AllClue(int[][] values, String[] clueText) {
        if (values.length < 4) {
            throw new IllegalArgumentException("Must provide at least 4 values");
        } else if (!Utils.areValidValueReferences(values)) {
            throw new IllegalArgumentException("Value references must be pairs");
        } else if (values.length > clueText.length) {
            throw new IndexOutOfBoundsException("Clue text must be provided for each value");
        }

        this.values = values;

        String display = "The " + Utils.numToString(values.length) + " values are " + clueText[0];
        for (int i = 1; i < values.length; i++) {
            display += ", ";
            if (i == values.length - 1) display += "and ";
            display += clueText[i];
        }
        display += ".";
        setDisplayText(display);
    }

    public AllClue(String overrideDisplayText, int[][] values) {
        super(overrideDisplayText);

        if (values.length < 4) {
            throw new IllegalArgumentException("Must provide at least 4 values");
        } else if (!Utils.areValidValueReferences(values)) {
            throw new IllegalArgumentException("Value references must be pairs");
        }

        this.values = values;
    }

    // --- GETTERS ---

    public int[][] getValueReferences() {
        return values;
    }

    public int[] getReference(int i) {
        return values[i];
    }

    public int getCategory(int i) {
        return values[i][0];
    }

    public int getValue(int i) {
        return values[i][1];
    }
    
}
