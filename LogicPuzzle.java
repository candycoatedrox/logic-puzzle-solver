import java.util.ArrayList;

public class LogicPuzzle {

    protected int valueCount;
    protected NumericalCategory numCategory;
    protected StandardCategory[] categories;

    protected ArrayList<Clue> clues;

    // --- GETTERS & SETTERS ---

    public ArrayList<Clue> getClues() {
        return clues;
    }

    public int nClues() {
        return clues.size();
    }

    public void addClue(Clue c) {
        clues.add(c);
    }

}