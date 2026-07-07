public class LogicPuzzle4xN extends LogicPuzzle {

    // --- CONSTRUCTORS ---

    public LogicPuzzle4xN(int valueCount, String numCategoryName, String categoryNameA, String categoryNameB, String categoryNameC) {
        super(4, valueCount, numCategoryName, categoryNameA, categoryNameB, categoryNameC);
    }

    public LogicPuzzle4xN(int valueCount, String numCategoryName, String... categoryNames) {
        super(4, valueCount, numCategoryName, categoryNames);
        if (categoryNames.length != 3) throw new IllegalArgumentException("Puzzle must have exactly 3 non-numerical categories");
    }

    // --- GETTERS & SETTERS ---
    
}
