public class LogicPuzzle {

    // Grid size
    protected final int categoryCount;
    protected final int valueCount;

    // Categories
    protected final NumericalCategory numCategory;
    protected final StandardCategory[] categories;

    // Grid & clues
    protected final LogicPuzzleGrid grid;
    protected final ClueList clues;

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
        clues = new ClueList();
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
    
    // --- MANAGE CLUES ---

    public void addClue(Clue c) {
        clues.add(c);
    }

    // --- RESOLVE CLUES ---

    public boolean resolveAllClues() {
        // returns true if anything changed, false otherwise
        boolean changesMade = false;


        // TODO: loop through all clues until no changes are made in a loop; have resolve[clue type] functions for all types of clues and direct to those



        return changesMade;
    }

}