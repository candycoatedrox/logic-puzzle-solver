public class AllDifferentClue extends Clue {

    // "X, Y, and Z are all different" clues
    
    private final int[][] values;

    // --- CONSTRUCTORS ---

    public AllDifferentClue(int[][] values, String[] clueText) {
        if (values.length < 3) {
            throw new IllegalArgumentException("Must provide at least 3 values");
        } else if (!Utils.areValidValueReferences(values)) {
            throw new IllegalArgumentException("Value references must be pairs");
        } else if (values.length > clueText.length) {
            throw new IndexOutOfBoundsException("Clue text must be provided for each value");
        }

        this.values = values;

        String display = clueText[0];
        for (int i = 1; i < values.length; i++) {
            display += ", ";
            if (i == values.length - 1) display += "and ";
            display += clueText[i];
        }
        display += " are all different.";
        setDisplayText(display);
    }

    public AllDifferentClue(String overrideDisplayText, int[][] values) {
        super(overrideDisplayText);

        if (values.length < 3) {
            throw new IllegalArgumentException("Must provide at least 3 values");
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

    // --- RESOLVE ---

    @Override
    public boolean resolve(LogicPuzzleGrid grid) {
        // returns true if anything changed, false otherwise

        // TODO


        return false;
    }

}
