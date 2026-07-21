public class SpecificGreaterLessThanClue extends Clue {

    // "X is N steps greater/less than Y" clues

    private final int steps;
    private final double difference;

    private final int[] valueA;
    private final int[] valueB;

    // --- CONSTRUCTORS ---

    public SpecificGreaterLessThanClue(double stepValue, int steps, int[] valueA, String clueTextA, int[] valueB, String clueTextB) {
        if (!Utils.isValidValueReference(valueA) || !Utils.isValidValueReference(valueB)) {
            throw new IllegalArgumentException("Value references must be pairs");
        } else if (valueA[0] == 0 || valueB[0] == 0) {
            throw new IllegalArgumentException("Greater/less than clues cannot include values in the numerical category");
        } else if (steps == 0) {
            throw new IllegalArgumentException("Values cannot be 0 steps apart");
        }

        this.steps = steps;
        this.difference = steps * stepValue;
        this.valueA = valueA;
        this.valueB = valueB;

        // TODO: fix clue template
        if (steps > 0) {
            setDisplayText(clueTextA + " is greater than " + clueTextB + ".");
        } else {
            setDisplayText(clueTextA + " is less than " + clueTextB + ".");
        }
    }

    public SpecificGreaterLessThanClue(int stepValue, int steps, int[] valueA, String clueTextA, int[] valueB, String clueTextB) {
        if (!Utils.isValidValueReference(valueA) || !Utils.isValidValueReference(valueB)) {
            throw new IllegalArgumentException("Value references must be pairs");
        } else if (valueA[0] == 0 || valueB[0] == 0) {
            throw new IllegalArgumentException("Greater/less than clues cannot include values in the numerical category");
        } else if (steps == 0) {
            throw new IllegalArgumentException("Values cannot be 0 steps apart");
        }

        this.steps = steps;
        this.difference = steps * stepValue;
        this.valueA = valueA;
        this.valueB = valueB;

        if (steps > 0) {
            setDisplayText(clueTextA + " is greater than " + clueTextB + ".");
        } else {
            setDisplayText(clueTextA + " is less than " + clueTextB + ".");
        }
    }

    public SpecificGreaterLessThanClue(String overrideDisplayText, double stepValue, int steps, int[] valueA, int[] valueB) {
        super(overrideDisplayText);

        if (!Utils.isValidValueReference(valueA) || !Utils.isValidValueReference(valueB)) {
            throw new IllegalArgumentException("Value references must be pairs");
        } else if (valueA[0] == 0 || valueB[0] == 0) {
            throw new IllegalArgumentException("Greater/less than clues cannot include values in the numerical category");
        } else if (steps == 0) {
            throw new IllegalArgumentException("Values cannot be 0 steps apart");
        }

        this.steps = steps;
        this.difference = steps * stepValue;
        this.valueA = valueA;
        this.valueB = valueB;
    }

    public SpecificGreaterLessThanClue(String overrideDisplayText, int stepValue, int steps, int[] valueA, int[] valueB) {
        super(overrideDisplayText);

        if (!Utils.isValidValueReference(valueA) || !Utils.isValidValueReference(valueB)) {
            throw new IllegalArgumentException("Value references must be pairs");
        } else if (valueA[0] == 0 || valueB[0] == 0) {
            throw new IllegalArgumentException("Greater/less than clues cannot include values in the numerical category");
        } else if (steps == 0) {
            throw new IllegalArgumentException("Values cannot be 0 steps apart");
        }

        this.steps = steps;
        this.difference = steps * stepValue;
        this.valueA = valueA;
        this.valueB = valueB;
    }

    public SpecificGreaterLessThanClue(NumericalCategory category, int steps, int[] valueA, String clueTextA, int[] valueB, String clueTextB) {
        if (!Utils.isValidValueReference(valueA) || !Utils.isValidValueReference(valueB)) {
            throw new IllegalArgumentException("Value references must be pairs");
        } else if (valueA[0] == 0 || valueB[0] == 0) {
            throw new IllegalArgumentException("Greater/less than clues cannot include values in the numerical category");
        } else if (steps == 0) {
            throw new IllegalArgumentException("Values cannot be 0 steps apart");
        }

        double stepValue = category.getStep();
        this.steps = steps;
        this.difference = steps * stepValue;
        this.valueA = valueA;
        this.valueB = valueB;

        if (steps > 0) {
            setDisplayText(clueTextA + " is greater than " + clueTextB + ".");
        } else {
            setDisplayText(clueTextA + " is less than " + clueTextB + ".");
        }
    }

    public SpecificGreaterLessThanClue(String overrideDisplayText, NumericalCategory category, int steps, int[] valueA, int[] valueB) {
        super(overrideDisplayText);

        if (!Utils.isValidValueReference(valueA) || !Utils.isValidValueReference(valueB)) {
            throw new IllegalArgumentException("Value references must be pairs");
        } else if (valueA[0] == 0 || valueB[0] == 0) {
            throw new IllegalArgumentException("Greater/less than clues cannot include values in the numerical category");
        } else if (steps == 0) {
            throw new IllegalArgumentException("Values cannot be 0 steps apart");
        }

        double stepValue = category.getStep();
        this.steps = steps;
        this.difference = steps * stepValue;
        this.valueA = valueA;
        this.valueB = valueB;
    }

    public SpecificGreaterLessThanClue(double stepValue, int steps, int catA, int valA, String clueTextA, int catB, int valB, String clueTextB) {
        if (catA == 0 || catB == 0) {
            throw new IllegalArgumentException("Greater/less than clues cannot include values in the numerical category");
        } else if (steps == 0) {
            throw new IllegalArgumentException("Values cannot be 0 steps apart");
        }

        int[] a = {catA, valA};
        int[] b = {catB, valB};
        this.steps = steps;
        this.difference = steps * stepValue;
        this.valueA = a;
        this.valueB = b;

        if (steps > 0) {
            setDisplayText(clueTextA + " is greater than " + clueTextB + ".");
        } else {
            setDisplayText(clueTextA + " is less than " + clueTextB + ".");
        }
    }

    public SpecificGreaterLessThanClue(int stepValue, int steps, int catA, int valA, String clueTextA, int catB, int valB, String clueTextB) {
        if (catA == 0 || catB == 0) {
            throw new IllegalArgumentException("Greater/less than clues cannot include values in the numerical category");
        } else if (steps == 0) {
            throw new IllegalArgumentException("Values cannot be 0 steps apart");
        }

        int[] a = {catA, valA};
        int[] b = {catB, valB};
        this.steps = steps;
        this.difference = steps * stepValue;
        this.valueA = a;
        this.valueB = b;

        if (steps > 0) {
            setDisplayText(clueTextA + " is greater than " + clueTextB + ".");
        } else {
            setDisplayText(clueTextA + " is less than " + clueTextB + ".");
        }
    }

    public SpecificGreaterLessThanClue(String overrideDisplayText, double stepValue, int steps, int catA, int valA, int catB, int valB) {
        super(overrideDisplayText);

        if (catA == 0 || catB == 0) {
            throw new IllegalArgumentException("Greater/less than clues cannot include values in the numerical category");
        } else if (steps == 0) {
            throw new IllegalArgumentException("Values cannot be 0 steps apart");
        }

        int[] a = {catA, valA};
        int[] b = {catB, valB};
        this.steps = steps;
        this.difference = steps * stepValue;
        this.valueA = a;
        this.valueB = b;
    }

    public SpecificGreaterLessThanClue(String overrideDisplayText, int stepValue, int steps, int catA, int valA, int catB, int valB) {
        super(overrideDisplayText);

        if (catA == 0 || catB == 0) {
            throw new IllegalArgumentException("Greater/less than clues cannot include values in the numerical category");
        } else if (steps == 0) {
            throw new IllegalArgumentException("Values cannot be 0 steps apart");
        }

        int[] a = {catA, valA};
        int[] b = {catB, valB};
        this.steps = steps;
        this.difference = steps * stepValue;
        this.valueA = a;
        this.valueB = b;
    }

    public SpecificGreaterLessThanClue(NumericalCategory category, int steps, int catA, int valA, String clueTextA, int catB, int valB, String clueTextB) {
        if (catA == 0 || catB == 0) {
            throw new IllegalArgumentException("Greater/less than clues cannot include values in the numerical category");
        } else if (steps == 0) {
            throw new IllegalArgumentException("Values cannot be 0 steps apart");
        }

        double stepValue = category.getStep();
        int[] a = {catA, valA};
        int[] b = {catB, valB};
        this.steps = steps;
        this.difference = steps * stepValue;
        this.valueA = a;
        this.valueB = b;

        if (steps > 0) {
            setDisplayText(clueTextA + " is greater than " + clueTextB + ".");
        } else {
            setDisplayText(clueTextA + " is less than " + clueTextB + ".");
        }
    }

    public SpecificGreaterLessThanClue(String overrideDisplayText, NumericalCategory category, int steps, int catA, int valA, int catB, int valB) {
        super(overrideDisplayText);

        if (catA == 0 || catB == 0) {
            throw new IllegalArgumentException("Greater/less than clues cannot include values in the numerical category");
        } else if (steps == 0) {
            throw new IllegalArgumentException("Values cannot be 0 steps apart");
        }

        double stepValue = category.getStep();
        int[] a = {catA, valA};
        int[] b = {catB, valB};
        this.steps = steps;
        this.difference = steps * stepValue;
        this.valueA = a;
        this.valueB = b;
    }

    // --- GETTERS ---

    public boolean isGreaterThan() {
        return steps > 0;
    }

    public int getSteps() {
        return steps;
    }

    public double getDifference() {
        return difference;
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
