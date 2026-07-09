public abstract class Clue {

    protected boolean overrideDisplayText = false;
    protected String displayText = "";
    
    protected boolean isActive = true;

    // --- CONSTRUCTORS ---

    public Clue() {
    }

    public Clue(String displayText) {
        overrideDisplayText(displayText);
    }

    // --- GETTERS & SETTERS ---

    @Override
    public String toString() {
        return displayText;
    }

    protected boolean setDisplayText(String display) {
        if (!overrideDisplayText) displayText = Utils.toSentenceCase(display);
        return !overrideDisplayText;
    }

    public final void overrideDisplayText(String display) {
        displayText = Utils.toSentenceCase(display);
        overrideDisplayText = true;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean state) {
        isActive = state;
    }

    public boolean toggleActive() {
        setActive(!isActive);
        return isActive;
    }

}