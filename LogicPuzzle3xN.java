public class LogicPuzzle3xN extends LogicPuzzle {

    // --- CONSTRUCTORS ---

    public LogicPuzzle3xN(int valueCount, String numCategoryName, String categoryNameA, String categoryNameB) {
        super(3, valueCount, numCategoryName, categoryNameA, categoryNameB);
    }

    public LogicPuzzle3xN(int valueCount, String numCategoryName, String... categoryNames) {
        super(3, valueCount, numCategoryName, categoryNames);
        if (categoryNames.length != 2) throw new IllegalArgumentException("Puzzle must have exactly 2 non-numerical categories");
    }

    // --- GETTERS & SETTERS ---
    
}
