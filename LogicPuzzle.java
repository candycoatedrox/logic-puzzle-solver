public class LogicPuzzle {

    // Grid size
    protected final int categoryCount;
    protected final int valueCount;

    // Categories
    protected final NumericalCategory numCategory;
    protected final StandardCategory[] categories;

    // Grid & clues
    protected final LogicPuzzleGrid grid;
    protected final GridFrame frame;
    protected final ClueList clues;

    // Solution
    protected int[][] solution; // TODO: STORE CORRECT SOLUTION SOMEHOW (either manually input or automatically found using clues)

    // --- CONSTRUCTOR ---

    public LogicPuzzle(int categoryCount, int valueCount, String numCategoryName, String... categoryNames) {
        this.categoryCount = categoryCount;
        this.valueCount = valueCount;
        numCategory = new NumericalCategory(numCategoryName, valueCount);

        if (categoryNames.length < categoryCount - 1) throw new IllegalArgumentException("Not enough category names given");
        
        categories = new StandardCategory[categoryCount - 1];
        for (int i = 0; i < categoryCount - 1; i++) {
            categories[i] = new StandardCategory(categoryNames[i], valueCount);
        }

        grid = new LogicPuzzleGrid(categoryCount, valueCount);
        frame = grid.getFrame();
        clues = new ClueList();
        solution = new int[valueCount][categoryCount - 1];
    }

    // --- GETTERS & SETTERS ---

    public int getValueCount() {
        return valueCount;
    }

    public Category[] getCategories() {
        Category[] cats = new Category[categoryCount];
        cats[0] = numCategory;
        for (int i = 0; i < categoryCount - 1; i++) {
            cats[i+1] = categories[i];
        }
        return cats;
    }

    public Category getCategory(int i) {
        if (i == 0) {
            return numCategory;
        } else {
            return categories[i-1];
        }
    }

    public ClueList getClues() {
        return clues;
    }

    public int nClues() {
        return clues.size();
    }

    public boolean autoResolveEnabled() {
        return grid.autoResolveEnabled();
    }

    public int autoResolveLevel() {
        return grid.autoResolveLevel();
    }

    public void setAutoResolve(int level) {
        grid.setAutoResolve(level);
    }

    public void setAutoResolve(boolean value) {
        grid.setAutoResolve(value);
    }

    public int[][] getSolution() {
        return solution;
    }

    public boolean setSolution(int[][] newSolution) {
        if (newSolution.length == valueCount) {
            for (int i = 0; i < valueCount; i++) {
                if (newSolution[i].length != categoryCount - 1) return false;
            }

            // ensure new solution is valid
            int val;
            for (int c = 0; c < categoryCount - 1; c++) {
                for (int i = 0; i < valueCount; i++) {
                    val = newSolution[i][c];

                    if (val < 0 || val >= valueCount) return false; // value is invalid
                    for (int j = 0; j < i; j++) {
                        if (newSolution[j][c] == val) return false; // value is a duplicate
                    }
                }
            }

            solution = newSolution;
            return true;
        } else {
            return false;
        }
    }

    public boolean setSolution(int... newSolution) {
        if (newSolution.length != valueCount * (categoryCount-1)) {
            return false;
        } else {
            int[][] sol = new int[valueCount][categoryCount - 1];
            int startIndex;
            for (int i = 0; i < valueCount; i++) {
                startIndex = i * (categoryCount - 1);
                for (int j = 0; j < categoryCount - 1; j++) {
                    sol[i][j] = newSolution[startIndex + j];
                }
            }

            return setSolution(sol);
        }
    }

    public boolean setValueSolution(int numericalVal, int[] valueSolution) {
        if (valueSolution.length == categoryCount - 1) {
            solution[numericalVal] = valueSolution;
            return true;
        } else {
            return false;
        }
    }

    // --- MANAGE GRID ---

    public boolean gridHasErrors() {
        return grid.checkForErrors(solution);
    }

    public boolean removeGridErrors() {
        return grid.removeErrors(solution);
    }

    public boolean markValue(int mark, int catA, int valA, int catB, int valB) {
        return grid.markValue(mark, catA, valA, catB, valB);
    }

    public boolean markValue(int mark, int row, int col) {
        return grid.markValue(mark, row, col);
    }

    public void resetGrid() {
        grid.reset();
    }
    
    // --- MANAGE CLUES ---

    public void addClue(Clue c) {
        clues.add(c);
    }

    public void setAllCluesActive() {
        clues.setAllActive();
    }

    public void setClueActive(int i, boolean state) {
        clues.setClueActive(i, state);
    }

    public void setClueActive(int i) {
        clues.setClueActive(i);
    }

    public void setClueInactive(int i) {
        clues.setClueInactive(i);
    }

    public boolean toggleClueActive(int i) {
        return clues.toggleClueActive(i);
    }

    public boolean resolveAllClues() {
        // returns true if anything changed, false otherwise
        boolean changesMade = false;

        boolean changedThisLoop = true;
        while (changedThisLoop) {
            changedThisLoop = false;
            for (Clue c : clues) {
                if (c.resolve(grid)) {
                    changesMade = true;
                    changedThisLoop = true;
                }
            }
        }

        return changesMade;
    }

    public boolean resolveClue(int i) {
        return clues.resolveClue(i, grid);
    }

    // --- MISC ---

    public void resetPuzzle() {
        resetGrid();
        setAllCluesActive();
    }

    @Override
    public String toString() {
        String s = "";

        // TODO

        s = clues.toString();


        return s;
    }

}