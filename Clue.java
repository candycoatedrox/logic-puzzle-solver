public abstract class Clue {

    protected String displayText;

    // --- GETTERS & SETTERS ---

    public String getDisplayText() {
        return displayText;
    }

    protected void setDisplayText(String s) {
        displayText = Utils.toSentenceCase(s);
    }

}