import java.util.ArrayList;

public class ClueList extends ArrayList<Clue> {
    
    // --- CONSTRUCTORS ---

    // --- GETTERS & SETTERS ---

    public Clue[] asArray() {
        Clue[] arr = new Clue[this.size()];
        return this.toArray(arr);
    }

    public ArrayList<ArrayList<Clue>> getSplitClues() {
        ArrayList<Clue> active = new ArrayList<>();
        ArrayList<Clue> inactive = new ArrayList<>();
        ArrayList<ArrayList<Clue>> output = new ArrayList<>();
        output.add(active);
        output.add(inactive);

        for (Clue c : this) {
            if (c.isActive()) active.add(c);
            else inactive.add(c);
        }

        return output;
    }

    public ArrayList<Clue> getActiveClues() {
        ArrayList<Clue> active = new ArrayList<>();
        for (Clue c : this) {
            if (c.isActive()) active.add(c);
        }
        return active;
    }

    public ArrayList<Clue> getInactiveClues() {
        ArrayList<Clue> inactive = new ArrayList<>();
        for (Clue c : this) {
            if (!c.isActive()) inactive.add(c);
        }
        return inactive;
    }

    public String getClueDisplayText(int i) {
        return this.get(i).getDisplayText();
    }

    public void overrideClueDisplayText(int i, String display) {
        this.get(i).overrideDisplayText(display);
    }

    public void setAllActive(boolean state) {
        for (Clue c : this) c.setActive(state);
    }

    public void setAllActive() {
        for (Clue c : this) c.setActive(true);
    }

    public void setAllInactive() {
        for (Clue c : this) c.setActive(false);
    }

    public void setClueActive(int i, boolean state) {
        this.get(i).setActive(state);
    }

    public void setClueActive(int i) {
        this.get(i).setActive(true);
    }

    public void setClueInactive(int i) {
        this.get(i).setActive(false);
    }

    public boolean toggleClueActive(int i) {
        return this.get(i).toggleActive();
    }

    // --- STRING REPRESENTATION ---

    public String activeClueList() {
        ArrayList<Clue> clues = getActiveClues();
        String s = "";
        for (int i = 0; i < clues.size(); i++) {
            if (i != 0) s += "\n";
            s += (i+1) + ".) " + clues.get(i).getDisplayText();
        }

        return s;
    }

    public String inactiveClueList() {
        ArrayList<Clue> clues = getInactiveClues();
        String s = "";
        for (int i = 0; i < clues.size(); i++) {
            if (i != 0) s += "\n";
            s += (i+1) + ".) " + clues.get(i).getDisplayText();
        }

        return s;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) return "--- Active Clues ---\nNo clues to display.";

        ArrayList<ArrayList<Clue>> splitClues = getSplitClues();
        ArrayList<Clue> activeClues = splitClues.get(0);
        ArrayList<Clue> inactiveClues = splitClues.get(1);

        String s = "";
        if (!inactiveClues.isEmpty()) {
            s += "--- Inactive Clues ---";
            for (int i = 0; i < inactiveClues.size(); i++) {
                s += "\n" + (i+1) + ".) " + inactiveClues.get(i).getDisplayText();
            }
        }
        if (!activeClues.isEmpty()) {
            if (!inactiveClues.isEmpty()) s += "\n\n";
            s += "--- Active Clues ---";
            for (int i = 0; i < activeClues.size(); i++) {
                s += "\n" + (i+1) + ".) " + activeClues.get(i).getDisplayText();
            }
        }

        return s;
    }

}
