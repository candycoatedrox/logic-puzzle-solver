public class LogicPuzzleGrid {

    // TODO:
    // THIS CLASS contains the "table" of true/false/null values, checks clues, etc.
    // 0 = unfilled
    // 1 = true
    // -1 = false (manual)
    // -2 = false (ONLY because a value in the row/column is true)
    // -3 = false (manual & value in row/column is true)

    // Settings
    protected int autoResolve = 1; // TODO: if true, resolveGrid() every time player changes something; include "resolve" command/button as well
    // 0 = no auto-resolve; 1 = sync values linked to true marks in diff. categories; 2 = all auto-resolve

    protected final GridFrame frame;
    protected int[] cursor; // indices of user's currently selected square

    protected final int categoryCount;
    protected final int valueCount;

    protected final int[][][][] grid;
    // accessed via category and value indices
    // access an individual square with:
    // grid [category A] [category B] [value row] [value column]
    // A should ALWAYS be less than B; will be automatically converted

    private final int[][] subgridIndices;

    // --- CONSTRUCTOR ---

    public LogicPuzzleGrid(int categoryCount, int valueCount) {
        frame = new GridFrame(this);
        this.categoryCount = categoryCount;
        this.valueCount = valueCount;

        int n = categoryCount - 1;
        grid = new int[n][][][];
        subgridIndices = new int[Utils.additionFactorial(n)][2];

        int indexN = 0;
        for (int i = 0; i < n; i++) {
            grid[i] = new int[n-i][valueCount][valueCount];
            for (int j = 0; j < n-i; j++) {
                subgridIndices[indexN][0] = i;
                subgridIndices[indexN][1] = j;
                indexN += 1;
            }
        }
    }

    // --- GETTERS & SETTERS ---

    public boolean autoResolveEnabled() {
        return autoResolve != 0;
    }

    public int autoResolveLevel() {
        return autoResolve;
    }

    public void setAutoResolve(int level) {
        if (level >= 0 && level <= 2) autoResolve = level;
    }

    public void setAutoResolve(boolean value) {
        if (value) autoResolve = 1;
        else autoResolve = 0;
    }

    public GridFrame getFrame() {
        return frame;
    }

    public int[][][][] getFullGrid() {
        return grid;
    }

    private int[] getTrueIndices(int catA, int catB) {
        if (catA > catB) { // swap the indices so that catA is the smaller index
            int[] indices = {catB,catA};
            return indices;
        } else {
            int[] indices = {catA,catB};
            return indices;
        }
    }

    private int[] getTrueIndices(int catA, int catB, int valA, int valB) {
        if (catA > catB) { // swap the indices so that catA is the smaller index
            int[] indices = {catB,catA,valB,valA};
            return indices;
        } else {
            int[] indices = {catA,catB,valA,valB};
            return indices;
        }
    }

    /* Get subgrid between categories catA and catB */
    public int[][] getSubgrid(int catA, int catB) {
        if (catA == catB) throw new IllegalArgumentException("No subgrid exists between a category and itself");
        if (!isValidCategory(catA) || !isValidCategory(catB)) throw new IndexOutOfBoundsException("Invalid category");
        
        int[] indices = getTrueIndices(catA, catB);
        catA = indices[0]; catB = indices[1];

        return getSubgridDirectly(catA, catB);
    }

    private int[][] getSubgridDirectly(int catA, int catB) {
        return grid[catA][catB - catA - 1];
    }
    
    private void setSubgridDirectly(int catA, int catB, int[][] subgrid) {
        grid[catA][catB - catA - 1] = subgrid;
    }

    private int[] getSubgridRow(int catA, int catB, int row) {
        int[][] subgrid = getSubgrid(catA, catB);
        return subgrid[row];
    }

    private int[] getSubgridColumn(int catA, int catB, int col) {
        int[][] subgrid = getSubgrid(catA, catB);
        int[] column = new int[valueCount];
        for (int i = 0; i < valueCount; i++) {
            column[i] = subgrid[i][col];
        }
        return column;
    }

    public int[] getMarksForValueInCategory(int catA, int value, int catB) {
        // gets all values between catA-value and catB
        // name this better????
        if (catA < catB) {
            return getSubgridRow(catA, catB, value);
        } else {
            return getSubgridColumn(catA, catB, value);
        }
    }

    public int getMarkedValue(int catA, int valA, int catB, int valB) {
        if (catA == catB) throw new IllegalArgumentException("No subgrid exists between a category and itself");
        if (!isValidCategory(catA) || !isValidCategory(catB)) throw new IndexOutOfBoundsException("Invalid category");
        if (!isValidValue(valA) || !isValidValue(valB)) throw new IndexOutOfBoundsException("Invalid value");

        int[] indices = getTrueIndices(catA, catB, valA, valB);
        catA = indices[0]; catB = indices[1]; valA = indices[2]; valB = indices[3];
        int[][] subgrid = getSubgridDirectly(catA, catB);

        return subgrid[valA][valB];
    }

    // --- MARKING ---

    private void setMarkedValueDirectly(int mark, int catA, int valA, int catB, int valB) {
        grid[catA][catB - catA - 1][valA][valB] = mark;
    }

    public boolean markValue(int mark, int catA, int valA, int catB, int valB) {
        if (catA == catB) throw new IllegalArgumentException("No subgrid exists between a category and itself");
        if (!isValidCategory(catA) || !isValidCategory(catB)) throw new IndexOutOfBoundsException("Invalid category");
        if (!isValidValue(valA) || !isValidValue(valB)) throw new IndexOutOfBoundsException("Invalid value");

        if (mark < -1) mark = -1;
        else if (mark > 1) mark = 1;

        int[] indices = getTrueIndices(catA, catB, valA, valB);
        catA = indices[0]; catB = indices[1]; valA = indices[2]; valB = indices[3];
        int[][] subgrid = getSubgridDirectly(catA, catB);

        // CHECK BEFORE MARKING
        // if current value = -2 or -3 (forced false): DO NOT SET
        // if current value = 0 or -1: 
            // if setting to 1, double-check there is no other true in row or column
        // if current value = 1 (true): 
            // change -3 to -1 and -2 to 0 within subgrid row and column
        int prevValue = subgrid[valA][valB];
        switch (prevValue) {
            case 0:
            case -1:
                if (mark == 1) {
                    return setTrue(catA, valA, catB, valB);
                } else {
                    subgrid[valA][valB] = mark;
                    return true;
                }
            case 1: return removeTrue(mark, catA, valA, catB, valB);
            default: return false;
        }
    }

    private boolean setTrue(int catA, int valA, int catB, int valB) {
        if (catA == catB) throw new IllegalArgumentException("No subgrid exists between a category and itself");
        if (!isValidCategory(catA) || !isValidCategory(catB)) throw new IndexOutOfBoundsException("Invalid category");
        if (!isValidValue(valA) || !isValidValue(valB)) throw new IndexOutOfBoundsException("Invalid value");

        int[] indices = getTrueIndices(catA, catB, valA, valB);
        catA = indices[0]; catB = indices[1]; valA = indices[2]; valB = indices[3];
        int[][] subgrid = getSubgridDirectly(catA, catB);

        // check for existing true values
        for (int i = 0; i < valueCount; i++) {
            if (subgrid[valA][i] == 1 || subgrid[i][valB] == 1) return false;
        }

        // set specified square true, but also set row/column -2 (0 -> -2, -1 -> -3)
        for (int i = 0; i < valueCount; i++) {
            if (i != valA) subgrid[valA][i] -= 2; // update value i in row
            if (i != valB) subgrid[i][valB] -= 2; // update value i in column
        }

        subgrid[valA][valB] = 1;
        setSubgridDirectly(catA, catB, subgrid);
        return true;
    }

    private boolean removeTrue(int newMark, int catA, int valA, int catB, int valB) {
        if (newMark == 1) return false;
        if (catA == catB) throw new IllegalArgumentException("No subgrid exists between a category and itself");
        if (!isValidCategory(catA) || !isValidCategory(catB)) throw new IndexOutOfBoundsException("Invalid category");
        if (!isValidValue(valA) || !isValidValue(valB)) throw new IndexOutOfBoundsException("Invalid value");

        int[] indices = getTrueIndices(catA, catB, valA, valB);
        catA = indices[0]; catB = indices[1]; valA = indices[2]; valB = indices[3];
        int[][] subgrid = getSubgridDirectly(catA, catB);

        subgrid[valA][valB] = newMark;

        // change -3 to -1 and -2 to 0 within subgrid row and column (+2)
        for (int i = 0; i < valueCount; i++) {
            if (i != valA) subgrid[valA][i] += 2; // update value i in row
            if (i != valB) subgrid[i][valB] += 2; // update value i in column
        }

        setSubgridDirectly(catA, catB, subgrid);
        return true;
    }

    // --- CURSOR ---

    public int[] getCursor() {
        return cursor;
    }

    public void setCursor() {
        // TODO


    }

    public void resetCursor() {
        // TODO



    }

    public boolean moveCursorLeft() {
        // TODO: return true if able to move, false if not



        return true;
    }

    public boolean moveCursorRight() {
        // TODO: return true if able to move, false if not



        return true;
    }

    public boolean moveCursorUp() {
        // TODO: return true if able to move, false if not



        return true;
    }

    public boolean moveCursorDown() {
        // TODO: return true if able to move, false if not



        return true;
    }

    // --- RESOLVE GRID ---

    public boolean resolveGrid() {
        // returns true if anything changed, false otherwise
        boolean changesMade = false;

        boolean changedThisLoop = true;
        while (changedThisLoop) {
            changedThisLoop = false;

            for (int[] indices : subgridIndices) {
                if (resolveSubgrid(indices)) changedThisLoop = true;
            }

            for (int i = 0; i < categoryCount; i++) {
                if (resolveCategory(i)) changedThisLoop = true;
            }

            if (changedThisLoop) changesMade = true;
        }

        return changesMade;
    }

    public boolean resolveCategory(int cat) {
        // returns true if anything changed, false otherwise
        boolean changesMade = false;

        boolean changedThisLoop = true;
        while (changedThisLoop) {
            changedThisLoop = false;

            for (int i = 0; i < valueCount; i++) {
                if (resolveValue(cat, i)) changedThisLoop = true;
            }

            if (changedThisLoop) changesMade = true;
        }

        return changesMade;
    }

    public boolean resolveValue(int cat, int val) {
        // returns true if anything changed, false otherwise
        boolean changesMade = false;


        // TODO



        return false;
    }

    public boolean resolveSubgrid(int catA, int catB) {
        // returns true if anything changed, false otherwise
        if (catA == catB) throw new IllegalArgumentException("No subgrid exists between a category and itself");
        if (!isValidCategory(catA) || !isValidCategory(catB)) throw new IndexOutOfBoundsException("Invalid category");
        
        int[] indices = getTrueIndices(catA, catB);
        catA = indices[0]; catB = indices[1];
        int[][] subgrid = getSubgridDirectly(catA, catB);

        // TODO
        // align with marked true values for other categories
        // if 2 values have only same 2 possibilities left, mark those false for other categories, etc
        // etc

        boolean changesMade = false;

        boolean changedThisLoop = true;
        while (changedThisLoop) {
            changedThisLoop = false;

            for (int i = 0; i < valueCount; i++) {
                if (resolveSubgridRow(catA, catB, i)) changedThisLoop = true;
            }
            for (int i = 0; i < valueCount; i++) {
                if (resolveSubgridColumn(catA, catB, i)) changedThisLoop = true;
            }

            // TODO: SUBGRID-SPECIFIC RESOLVE HERE...



            if (changedThisLoop) changesMade = true;
        }

        return changesMade;
    }

    private boolean resolveSubgrid(int[] cats) {
        if (cats.length != 2) throw new IllegalArgumentException("Must give exactly two categories");
        
        return resolveSubgrid(cats[0], cats[1]);
    }

    public boolean resolveSubgridRow(int catA, int catB, int r) {
        // returns true if anything changed, false otherwise
        if (catA == catB) throw new IllegalArgumentException("No subgrid exists between a category and itself");
        if (!isValidCategory(catA) || !isValidCategory(catB)) throw new IndexOutOfBoundsException("Invalid category");
        if (!isValidValue(r)) throw new IndexOutOfBoundsException("Invalid row");

        int[] indices = getTrueIndices(catA, catB);
        catA = indices[0]; catB = indices[1];
        int[][] subgrid = getSubgridDirectly(catA, catB);
        int[] row = getSubgridRow(catA, catB, r);

        // TODO
        // if 4 values in row are marked false, set last to true
        // etc

        boolean changesMade = false;

        boolean changedThisLoop = true;
        while (changedThisLoop) {
            changedThisLoop = false;

            // TODO: RESOLVE HERE...



            if (changedThisLoop) changesMade = true;
        }

        return changesMade;
    }

    public boolean resolveSubgridColumn(int catA, int catB, int c) {
        // returns true if anything changed, false otherwise
        if (catA == catB) throw new IllegalArgumentException("No subgrid exists between a category and itself");
        if (!isValidCategory(catA) || !isValidCategory(catB)) throw new IndexOutOfBoundsException("Invalid category");
        if (!isValidValue(c)) throw new IndexOutOfBoundsException("Invalid column");

        int[] indices = getTrueIndices(catA, catB);
        catA = indices[0]; catB = indices[1];
        int[][] subgrid = getSubgridDirectly(catA, catB);
        int[] column = getSubgridRow(catA, catB, c);


        // TODO
        // etc

        boolean changesMade = false;

        boolean changedThisLoop = true;
        while (changedThisLoop) {
            changedThisLoop = false;

            // TODO: RESOLVE HERE...



            if (changedThisLoop) changesMade = true;
        }



        for (int i = 0; i < valueCount; i++) subgrid[i][c] = column[i];

        return changesMade;
    }

    // --- MISC ---

    private boolean isValidCategory(int cat) {
        return cat >= 0 && cat < categoryCount;
    }

    private boolean isValidValue(int val) {
        return val >= 0 && val < valueCount;
    }

    @Override
    public String toString() {
        String s = "";

        // TODO


        return s;
    }

}
